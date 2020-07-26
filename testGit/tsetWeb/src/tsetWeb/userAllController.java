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

@WebServlet("/userAll")
public class userAllController extends HttpServlet {

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
//		// 存放錯誤訊息的Map
//		Map<String, String> errorMsgMap = new HashMap<String, String>();
//		req.setAttribute("ErrorMsgKey", errorMsgMap);
		userDAO userdao = new userDAO();
		
		//查詢所有
		String sendType = req.getParameter("sendType");

			List<userBean> allbean = new ArrayList<userBean>();
			allbean = userdao.selectUserAll();
			session.setAttribute("allbean", allbean);
	     	System.out.println("所有會員");
		    RequestDispatcher rd = req.getRequestDispatcher("/view/alluser.jsp");
			rd.forward(req, resp);
		//return;	
		
	}

}
