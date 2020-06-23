package controller;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;
import java.sql.Blob;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import model.bean.BlobExBean;
import model.service.BlobExService;

//@WebServlet(urlPatterns = "/pages/blobEx.controller")
@MultipartConfig
public class BlobExServlet extends HttpServlet {

	private SessionFactory sessionFactory;
	private BlobExService blobExService;

	@Override
	public void init() throws ServletException {
		ApplicationContext context = WebApplicationContextUtils
				.getRequiredWebApplicationContext(this.getServletContext());
		sessionFactory = (SessionFactory) context.getBean("sessionFactory");
		blobExService = (BlobExService) context.getBean("blobExService");

	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("sessionFactory=" + sessionFactory);
		// 接收資料
		String temp1 = request.getParameter("id");
		String name = request.getParameter("name");
		Part photoFile = request.getPart("photo");
		String prodaction = request.getParameter("prodaction");

		// 轉換資料
		Map<String, String> errors = new HashMap<>();
		request.setAttribute("errors", errors);

		int id = 0;
		if (temp1 != null && temp1.length() != 0) {
			try {
				id = Integer.parseInt(temp1);
			} catch (NumberFormatException e) {
				e.printStackTrace();
				errors.put("xxx1", "Id必須是整數");
			}
		}

		////////////////////////////////////////////////////////////////////
		// https://stackoverflow.com/questions/2422468/how-to-upload-files-to-server-using-jsp-servlet?rq=1
		String fileName = Paths.get(photoFile.getSubmittedFileName()).getFileName().toString(); // MSIE fix.
		System.out.println("fileName = " + fileName);

		InputStream fileContent = photoFile.getInputStream();
		// Blob photo =
		// Hibernate.getLobCreator(sessionFactory.getCurrentSession()).createBlob(fileContent,
		// photoFile.getSize());

		// https://stackoverflow.com/questions/20614973/read-write-blob-data-in-chunks-with-hibernate
		Blob photo = sessionFactory.getCurrentSession().getLobHelper().createBlob(fileContent, photoFile.getSize());

		////////////////////////////////////////////////////////////////////

		// 驗證資料
		if ("Update".equals(prodaction) || "Delete".equals(prodaction)) {
			if (id == 0) {
				errors.put("xxx1", "請輸入Id以便執行" + prodaction);
			}
		}

		if (errors != null && !errors.isEmpty()) {
			request.getRequestDispatcher("/pages/blobEx.jsp").forward(request, response);
			return;
		}

		// 呼叫model

		BlobExBean bean = new BlobExBean();
		bean.setId(id);
		bean.setName(name);
		bean.setPhoto(photo);

		// 根據model執行結果，導向view

		if ("Select".equals(prodaction)) {
			List<BlobExBean> result = blobExService.select(bean);
			request.setAttribute("select", result);
			request.getRequestDispatcher("/pages/blobEx_display.jsp").forward(request, response);
		} else if (prodaction != null && prodaction.equals("Insert")) {
			BlobExBean result = blobExService.insert(bean);
			if (result == null) {
				errors.put("action", "Insert fail");
			} else {
				request.setAttribute("insert", result);
			}
			request.getRequestDispatcher("/pages/blobEx.jsp").forward(request, response);
		} else if (prodaction != null && prodaction.equals("Update")) {
			BlobExBean result = blobExService.update(bean);
			if (result == null) {
				errors.put("action", "Update fail");
			} else {
				request.setAttribute("update", result);
			}
			request.getRequestDispatcher("/pages/blobEx.jsp").forward(request, response);
		} else if (prodaction != null && prodaction.equals("Delete")) {
			boolean result = blobExService.delete(bean);
			if (!result) {
				request.setAttribute("delete", 0);
			} else {
				request.setAttribute("delete", 1);
			}
			request.getRequestDispatcher("/pages/blobEx.jsp").forward(request, response);
		} else {
			errors.put("action", "Unknown Action:" + prodaction);
			request.getRequestDispatcher("/pages/blobEx.jsp").forward(request, response);
		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doGet(req, resp);
	}

}
