package Controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ModelBean.MemberBean;
import ModelService.LoginService;
import ModelService.PasswordMD5;




@WebServlet("/Controller/LoginServlet")
public class LoginServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();

		Map<String, String> errorMsgMap = new HashMap<String, String>();
	
		request.setAttribute("ErrorMsgKey", errorMsgMap);

		String id = request.getParameter("mId");

		if (id == null || id.trim().length() == 0) {
			errorMsgMap.put("AccountEmptyError", "帳號欄必須輸入");
		}else if(id.getBytes().length != id.length()) {
			errorMsgMap.put("id2", "帳號不能為中文");
		}
		
		String passwordmd5 = request.getParameter("pswd");
		PasswordMD5 md5 = new PasswordMD5();
		String password =  md5.md5(passwordmd5);
	

		if (password.equalsIgnoreCase("D41D8CD98F00B204E9800998ECF8427E")) {
			errorMsgMap.put("PasswordEmptyError", "密碼欄必須輸入");
		}

		if (!errorMsgMap.isEmpty()) {
			RequestDispatcher rd = request
					.getRequestDispatcher("/pages/LogIn.jsp");
			rd.forward(request, response);
			return;
		}

		LoginService ls = new LoginService();

		MemberBean mb = ls.checkIDPassword(id, password);

		if (mb != null) {

			session.setAttribute("LoginOK", mb);
			
		} else {
		
			errorMsgMap.put("LoginError", "該帳號不存在或密碼錯誤");
		}

		if (errorMsgMap.isEmpty()) {

			String contextPath = getServletContext().getContextPath();
			String target = (String) session.getAttribute("target");
			if (target != null) {

				session.removeAttribute("target");

				response.sendRedirect(
			       response.encodeRedirectURL(contextPath + target));

			} else {

                response.sendRedirect(
			      response.encodeRedirectURL(contextPath + "/index.jsp" ));

			}
			return;
		} else {

			RequestDispatcher rd = request
					.getRequestDispatcher("/pages/LogIn.jsp");
			rd.forward(request, response);
			return;
		}
	}

}
