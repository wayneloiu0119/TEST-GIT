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
import ModelService.ForgotPasswordService;
import ModelService.TestSetMail;


@WebServlet("/Controller/ForgotPassword")
public class ForgotPassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		Map<String, String> errorMessage = new HashMap<String, String>();
		request.setAttribute("ErrorMsg", errorMessage);
		
		String id = request.getParameter("mId");
		if (id == null || id.trim().length() == 0) {
			errorMessage.put("id","帳號欄必須輸入");
		}else if(id.getBytes().length != id.length()) {
			errorMessage.put("id2", "帳號不能為中文");
		}
		String email = request.getParameter("mEmail");
		// 檢查使用者所輸入的資料
		if (email == null || email.trim().length() == 0) {
			errorMessage.put("email","信箱必須輸入");
		}
		if (!errorMessage.isEmpty()) {
			RequestDispatcher rd = request
					.getRequestDispatcher("/pages/Forgot.jsp");
			rd.forward(request, response);
			return;
		}
		
		ForgotPasswordService fs = new ForgotPasswordService();
		
		MemberBean mb = fs.ForgotPassword(id, email);
		
		if(mb != null) {
			
			session.setAttribute("ForgotEmailOK", mb);
			
	//=================================================	
	
	  TestSetMail ts = new TestSetMail();
	  MemberBean fb = ts.setMail(mb);
	//====================================================		
			RequestDispatcher rd = request
					.getRequestDispatcher("/pages/SetMailOK.jsp");
	
			rd.forward(request, response);
			return;
			
		}else {
			
			errorMessage.put("ForgotEmailOKerror", "帳號或信箱錯誤");
		}
		if (errorMessage.isEmpty()) {

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
					.getRequestDispatcher("/pages/Forgot.jsp");
			rd.forward(request, response);
			return;
		}
		
	}
	

    public ForgotPassword() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}



}
