package controller;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import model.bean.BlobExBean;
import model.service.BlobExService;
import model.spring.PrimitiveNumberEditor;

@Controller
@RequestMapping("/pages/blobEx.controller")
public class BlobExController {

	@Autowired
	private SessionFactory sessionFactory;
	@Autowired
	private BlobExService blobExService;

	@InitBinder
	public void initBinder(WebDataBinder webDataBinder) {
		webDataBinder.registerCustomEditor(int.class, new PrimitiveNumberEditor(java.lang.Integer.class, true));
	}

	@RequestMapping(method = { RequestMethod.POST })

	public String method(BlobExBean bean, BindingResult bindingResult, Model model,
			@RequestParam("photo") MultipartFile file, @RequestParam("prodaction") String prodaction) {
		// 接收資料

		// 轉換資料
		Map<String, String> errors = new HashMap<>();
		model.addAttribute("errors", errors);


		////////////////////////////////////////////////////////////////////
		InputStream inputStream = null;
		if (!file.isEmpty()) {
			try {
				inputStream = file.getInputStream();
			} catch (IOException e) {
				System.out.println("GG");
				e.printStackTrace();
			}

		}
		// Blob photo =
		// Hibernate.getLobCreator(sessionFactory.getCurrentSession()).createBlob(fileContent,
		// photoFile.getSize());

		// https://stackoverflow.com/questions/20614973/read-write-blob-data-in-chunks-with-hibernate

		Blob photo = this.sessionFactory.getCurrentSession().getLobHelper().createBlob(inputStream, file.getSize());
		////////////////////////////////////////////////////////////////////

		// 驗證資料
		if ("Update".equals(prodaction) || "Delete".equals(prodaction)) {
			if (bean.getId() == 0) {
				errors.put("xxx1", "請輸入Id以便執行" + prodaction);
			}
		}

		if (errors != null && !errors.isEmpty()) {
			return "blobEx.error";
		}

		// 呼叫model
		bean.setId(bean.getId());
		bean.setName(bean.getName());
		bean.setPhoto(photo);

		// 根據model執行結果，導向view

		if ("Select".equals(prodaction)) {
			List<BlobExBean> result = blobExService.select(bean);
			model.addAttribute("select", result);
			return "blobEx.select";
		} else if (prodaction != null && prodaction.equals("Insert")) {
			BlobExBean result = blobExService.insert(bean);
			if (result == null) {
				errors.put("action", "Insert fail");
			} else {
				model.addAttribute("insert", result);
			}
			return "blobEx.error";
		} else if (prodaction != null && prodaction.equals("Update")) {
			BlobExBean result = blobExService.update(bean);
			if (result == null) {
				errors.put("action", "Update fail");
			} else {
				model.addAttribute("update", result);
			}
			return "blobEx.error";
		} else if (prodaction != null && prodaction.equals("Delete")) {
			boolean result = blobExService.delete(bean);
			if (!result) {
				model.addAttribute("delete", 0);
			} else {
				model.addAttribute("delete", 1);
			}
			return "blobEx.error";
		} else {
			errors.put("action", "Unknown Action:" + prodaction);
			return "blobEx.error";
		}

	}

}
