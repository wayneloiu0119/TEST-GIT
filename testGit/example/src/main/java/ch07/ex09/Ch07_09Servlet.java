package ch07.ex09;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Ch07_09Servlet
 */
@WebServlet("/ch07/ch07_09.abc")
public class Ch07_09Servlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 ServletContext  context = getServletContext();
		 String requestgetContextPath = request.getContextPath();
		 String contextgetContextPath = context.getContextPath();
		 String contextgetServletContextName = context.getServletContextName();
		 request.setAttribute("rcp", requestgetContextPath);
		 request.setAttribute("ccp", contextgetContextPath);
		 request.setAttribute("cscn", contextgetServletContextName);
		 RequestDispatcher rd = request.getRequestDispatcher("ch07_09.jsp");
		 rd.forward(request, response);
		 return;

	}
	
}
