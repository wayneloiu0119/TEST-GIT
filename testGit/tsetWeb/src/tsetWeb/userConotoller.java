package tsetWeb;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class userConotoller extends HttpServlet  {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//避免jsp回傳解析成亂碼
		req.setCharacterEncoding("UTF-8");
		Enumeration<String> paramNames = req.getParameterNames();
		HttpSession session = req.getSession();
		
		Map<String, Object> errorMassge = new HashMap<>();
		
		Map<String, userBean> userMaps = new HashMap<>();
 		
		//把request回傳的值全部跑一遍，但因為型態不會都一樣，故需要給Object
		//Bean的設定也是需要都給Object
		/*
		while(paramNames.hasMoreElements()) {
			
			String paramName = paramNames.nextElement();
			
			Object paraValues = req.getParameter(paramName);
			
			if(null==paraValues) {
				errorMassge.put(paramName, paramName+"不能為空");
				System.out.println(paramName+"不能為空");
			}else {
				userMaps.put(paramName,(userBean) paraValues);
			}
			}
			*/			
		   userBean userbean = new userBean();		   
		   userbean.setUserId(req.getParameter("userId"));
		   userbean.setUserName(req.getParameter("userName"));
		   userbean.setPswd(req.getParameter("pswd"));
		   userbean.setGender(req.getParameter("gender"));
		   userbean.setEmail(req.getParameter("email"));
		   userbean.setAddress(req.getParameter("address"));
		   //字串轉數字
		   int phone = Integer.valueOf(req.getParameter("phone"));
		   userbean.setPhone(phone);
		   //字串轉日期
		   SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		   Date birth = new Date();
		   Date nwtime = new Date();
		   try {
			birth = df.parse(req.getParameter("birthday"));
			userbean.setBirthday(birth);
			userbean.setInsertTime(nwtime);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	   
		   userDAO userdao = new userDAO();
		   userdao.insertUser(userbean);
		   session.setAttribute("userbean",userbean);
		   System.out.println("insert");
		  System.out.println(userbean.toString());
		  RequestDispatcher rd = req.getRequestDispatcher("/view/userin.jsp");
		  rd.forward(req, resp);
		  return;
		//super.doPost(req, resp);
	}
	
	
}
