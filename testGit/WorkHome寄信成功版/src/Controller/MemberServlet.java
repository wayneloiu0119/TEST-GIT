package Controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
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
import ModelDAO.MemberDAO;
import ModelService.PasswordMD5;



  @WebServlet("/Controller/MemberServlet")
//@WebServlet(
//		urlPatterns="/ModelDAO/MemberServlet",
//		initParams= {
//				@WebInitParam(name="DBString",
//						value="java:comp/env/jdbc/MemberDB")
//		}
//		)
public class MemberServlet extends HttpServlet {
//---------------------------------------------------------------------------
	
	
	  
	  
	  
	  
	  
//---------------------------------------------------------------------------	  
	private static final long serialVersionUID = 1L;
//	String memberDBString;
//	public void init() throws ServletException {
//		memberDBString = getInitParameter("DBString");
//		}
	
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
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
		
		String passwordmd5 = request.getParameter("pswd");
		PasswordMD5 md5 = new PasswordMD5();
		String password =  md5.md5(passwordmd5);
	
		
		
		if (password.equalsIgnoreCase("D41D8CD98F00B204E9800998ECF8427E")) {
			errorMessage.put("password","密碼欄必須輸入");
		}
		
		
		String name = request.getParameter("mName");
		// 檢查使用者所輸入的資料
		if (name == null || name.trim().length() == 0) {
			errorMessage.put("name","姓名欄必須輸入");
		}

		
		String bday = request.getParameter("mBirthday");
	
		java.sql.Date date = null;
		if (bday != null && bday.trim().length() > 0) {
			try {
				date = java.sql.Date.valueOf(bday);
			} catch (IllegalArgumentException e) {
				errorMessage.put("bday","生日欄格式錯誤");
			}
		}else if(bday != null || bday.trim().length() == 0 ){
			errorMessage.put("bday2","生日欄不得為空");
		}
	
		String email = request.getParameter("mEmail");
		// 檢查使用者所輸入的資料
		if (email == null || email.trim().length() == 0) {
			errorMessage.put("email","信箱必須輸入");
		}
		String phone = request.getParameter("mPhone");
		// 檢查使用者所輸入的資料
		if (phone == null || phone.trim().length() == 0) {
			errorMessage.put("phone","電話必須輸入");
		}

		
		if (!errorMessage.isEmpty()) {
			RequestDispatcher rd = request
					.getRequestDispatcher("/pages/InsertMember.jsp");
			rd.forward(request, response);
			return;
		}


		MemberBean mb = new MemberBean(id, password,name, date,email, phone);
		try {
			MemberDAO mfio = new MemberDAO();
			mfio.insertMemberTb(mb);
			session.setAttribute("memberBean",mb);
			
	
			RequestDispatcher rd = request
					.getRequestDispatcher("/pages/InsertMemberSuccess.jsp");
	
			rd.forward(request, response);
//			response.encodeRedirectURL("/pages/InsertMemberSuccess.jsp");
//			System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
			return;
		} catch (SQLException e) {
			if (e.getMessage().indexOf("重複的索引鍵") != -1 || 
				e.getMessage().indexOf("Duplicate entry") != -1) {
				errorMessage.put("id","帳號重複，請重新輸入帳號");
			} else {
				errorMessage.put("exception","資料庫存取錯誤:" + e.getMessage());
			}
			RequestDispatcher rd = request
				.getRequestDispatcher("/pages/InsertMember.jsp");
			rd.forward(request, response);
			return;
		}
	}
}
