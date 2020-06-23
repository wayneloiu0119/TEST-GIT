package com.wayne.controller;

import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class userController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		System.out.println("doGet");
		String userName = req.getParameter("userName");
		String pswd = req.getParameter("pswd");
		String email = req.getParameter("email");
		System.out.println("姓名:"+userName+"密碼:"+pswd+"信箱:"+email);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//req.setCharacterEncoding("utf-8"); //解決中文亂碼問題，只支援post模式
        Enumeration<String> paramNames = req.getParameterNames();
		
		Map<String, Object> errorMassge = new HashMap<>();
		
		Map<String, Object> userMaps = new HashMap<>();
 		
		while(paramNames.hasMoreElements()) {
			
			String paramName = paramNames.nextElement();
			
			Object paraValues = req.getParameter(paramName);
			
			if(null==paraValues) {
				errorMassge.put(paramName, paramName+"不能為空");
				System.out.println(paramName+"不能為空");
			}else {
				
				userMaps.put(paramName,paraValues);
			}
				
			
		   
		
		}
		
		userBean userBean = new userBean();
		   
		   userBean.setUserName(userMaps.get("userName"));
		   userBean.setPswd(userMaps.get("pswd"));
		   userBean.setEmail(userMaps.get("email"));
		   userBean.setGender(userMaps.get("gender"));
		   userBean.setPhone(userMaps.get("phone"));
		   userBean.setBirthday(userMaps.get("birthday"));
		   userBean.setNowTime(userMaps.get("nowTime"));
		   
		   System.out.println(userBean.toString());
		  
		
	}

}
