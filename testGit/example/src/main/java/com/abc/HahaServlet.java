package com.abc;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HahaServlet
 */
@WebServlet("/ch01/helloAgain.jpg")
public class HahaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public HahaServlet() {    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html><head>");
        out.println("<link rel='stylesheet' href='../css/styles.css' type='text/css' />");
        out.println("<title>Hello, World 大家好 (Servlet)</title>");
        out.println("</head>");
        out.println("<body>");
		out.write("哈哈，大家好!!!<BR>");
		String reqURI = request.getRequestURI();
		out.write("requestURI="+ reqURI   +"<BR>");
		RequestDispatcher  rd = request.getRequestDispatcher("/commons/previousPage.jsp");
		rd.include(request, response);
		out.println("</body>");
        out.println("</html>");
		return;
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
