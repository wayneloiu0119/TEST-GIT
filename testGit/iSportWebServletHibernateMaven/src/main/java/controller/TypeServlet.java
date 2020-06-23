package controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import model.bean.TypeBean;
import model.service.TypeService;

//@WebServlet(urlPatterns = "/pages/type.controller")
public class TypeServlet extends HttpServlet {

	private TypeService typeService;

	@Override
	public void init() throws ServletException {
		ApplicationContext context = WebApplicationContextUtils
				.getRequiredWebApplicationContext(this.getServletContext());

		typeService = (TypeService) context.getBean("typeService");
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("hahahah");

		// 接收資料
		String temp1 = request.getParameter("typeId");
		String typeName = request.getParameter("typeName");
		String prodaction = request.getParameter("prodaction");

		// 轉換資料
		Map<String, String> errors = new HashMap<>();
		request.setAttribute("errors", errors);

		int typeId = 0;
		if (temp1 != null && temp1.length() != 0) {
			try {
				typeId = Integer.parseInt(temp1);
			} catch (NumberFormatException e) {
				e.printStackTrace();
				errors.put("xxx1", "Id必須是整數");
			}
		}

		// 驗證資料
		if ("Update".equals(prodaction) || "Delete".equals(prodaction)) {
			if (typeId == 0) {
				errors.put("xxx1", "請輸入Id以便執行" + prodaction);
			}
		}

		if (errors != null && !errors.isEmpty()) {
			request.getRequestDispatcher("/pages/type.jsp").forward(request, response);
			return;
		}

		// 呼叫model
		TypeBean bean = new TypeBean();
		bean.setTypeId(typeId);
		bean.setTypeName(typeName);

		// 根據model執行結果，導向view

		if ("Select".equals(prodaction)) {
			List<TypeBean> result = typeService.select(bean);
			request.setAttribute("select", result);
			request.getRequestDispatcher("/pages/type_display.jsp").forward(request, response);
		} else if (prodaction != null && prodaction.equals("Insert")) {
			TypeBean result = typeService.insert(bean);
			if (result == null) {
				errors.put("action", "Insert fail");
			} else {
				request.setAttribute("insert", result);
			}
			request.getRequestDispatcher("/pages/type.jsp").forward(request, response);
		} else if (prodaction != null && prodaction.equals("Update")) {
			TypeBean result = typeService.update(bean);
			if (result == null) {
				errors.put("action", "Update fail");
			} else {
				request.setAttribute("update", result);
			}
			request.getRequestDispatcher("/pages/type.jsp").forward(request, response);
		} else if (prodaction != null && prodaction.equals("Delete")) {
			boolean result = typeService.delete(bean);
			if (!result) {
				request.setAttribute("delete", 0);
			} else {
				request.setAttribute("delete", 1);
			}
			request.getRequestDispatcher("/pages/type.jsp").forward(request, response);
		} else {
			errors.put("action", "Unknown Action:" + prodaction);
			request.getRequestDispatcher("/pages/type.jsp").forward(request, response);
		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doGet(req, resp);
	}

}
