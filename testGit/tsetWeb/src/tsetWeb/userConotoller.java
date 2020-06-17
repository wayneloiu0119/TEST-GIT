package tsetWeb;

import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class userConotoller extends HttpServlet  {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Enumeration<String> paramNames = req.getParameterNames();
		
		Map<String, Object> errorMassge = new HashMap<>();
		
		Map<String, userBean> userMaps = new HashMap<>();
 		
		while(paramNames.hasMoreElements()) {
			
			String paramName = paramNames.nextElement();
			
			Object paraValues = req.getParameter(paramName);
			
			if(null==paraValues) {
				errorMassge.put(paramName, paramName+"不能為空");
				System.out.println(paramName+"不能為空");
			}else {
				userMaps.put(paramName,(userBean) paraValues);
			}
				
			
		   userBean userBean = new userBean();
			
		   userBean.toString();
		}
		
		
		super.doPost(req, resp);
	}
	
	
}
