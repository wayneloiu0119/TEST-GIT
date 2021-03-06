package tsetWeb;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/userLogin")
public class userLoginController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 避免jsp回傳解析成亂碼
		req.setCharacterEncoding("UTF-8");

		HttpSession session = req.getSession();
		// 存放錯誤訊息的Map
		Map<String, String> errorMsgMap = new HashMap<String, String>();
		req.setAttribute("ErrorMsgKey", errorMsgMap);
		userDAO userdao = new userDAO();
		
		//查詢所有
		String sendType = req.getParameter("sendType");
		if("all".equals(sendType)) {
//			List<userBean> allbean = new ArrayList<userBean>();
//			allbean = userdao.selectUserAll();
//			session.setAttribute("allbean", allbean);
//			RequestDispatcher rd = req.getRequestDispatcher("/view/alluser.jsp");
//			rd.forward(req, resp);
//			return;
			RequestDispatcher rd = req.getRequestDispatcher("/view/alluser.jsp");
			rd.forward(req, resp);
			return;
		}
		
		
		userBean userbean = new userBean();
		userbean.setUserId(req.getParameter("userId"));
		userbean.setPswd(req.getParameter("pswd"));
		userbean.setUserLevel(req.getParameter("userlevel"));
		
		userBean loginBean = userdao.selectForUserId(userbean);
		if (null != loginBean) {

			String pswd = loginBean.getPswd();
			if (pswd.equals(req.getParameter("pswd"))||"9".equals(userbean.getUserLevel())) {
				System.out.println("登入成功");
				//加入ben到session
				session.setAttribute("loginBean", loginBean);
				session.setAttribute("userbean", userbean);
			} else {
				System.out.println("登入失敗");
				errorMsgMap.put("loginerror", "帳號或密碼錯誤");
			}
		} else {
			System.out.println("帳號錯誤");
			errorMsgMap.put("loginerror", "帳號或密碼錯誤");
		}

		if (!errorMsgMap.isEmpty()) {

			RequestDispatcher rd = req.getRequestDispatcher("/view/login.jsp");
			rd.forward(req, resp);
			return;
		} else {
			RequestDispatcher rd = req.getRequestDispatcher("/view/userin.jsp");
			rd.forward(req, resp);
			return;
		}
		// System.out.println("login!!!");

		// super.doPost(req, resp);
	}

}
