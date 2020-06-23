package controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import model.bean.TypeBean;
import model.service.TypeService;
import model.spring.PrimitiveNumberEditor;

@Controller
@RequestMapping("/pages/type.controller")
public class TypeController {

	@Autowired
	private TypeService typeService;

	@InitBinder
	public void initBinder(WebDataBinder webDataBinder) {
		webDataBinder.registerCustomEditor(int.class, new PrimitiveNumberEditor(java.lang.Integer.class, true));
	}

	// @RequestMapping(method = { RequestMethod.GET, RequestMethod.POST })
	// public static void main(String[] args) {
	// System.out.println("hahahahahah");
	// }

	@RequestMapping(method = { RequestMethod.GET, RequestMethod.POST })
	public String method(TypeBean bean, BindingResult bindingResult, Model model,
			@RequestParam("prodaction") String prodaction) {

		System.out.println("bean=" + bean);
		System.out.println("bindingResult=" + bindingResult);
		// 接收資料

		// 轉換資料
		Map<String, String> errors = new HashMap<>();
		model.addAttribute("errors", errors);

		if (bindingResult != null && bindingResult.hasErrors()) {
			if (bindingResult.getFieldError("typeId") != null) {
				errors.put("xxx1", "Id必須是整數");
			}
		}

		// 驗證資料
		if ("Insert".equals(prodaction)) {
			if (bean.getTypeName() == null || bean.getTypeName().length() == 0) {
				errors.put("xxx2", "請輸入TypeName以便執行" + prodaction);
			}
		}
		if ("Update".equals(prodaction) || "Delete".equals(prodaction)) {
			if (bean.getTypeId() == 0) {
				errors.put("xxx1", "請輸入Id以便執行" + prodaction);
			}
		}

		if (errors != null && !errors.isEmpty()) {

			return "type.error";
		}

		// 呼叫model

		// 根據model執行結果，導向view

		if ("Select".equals(prodaction)) {
			List<TypeBean> result = typeService.select(bean);
			model.addAttribute("select", result);
			return "type.select";
		} else if (prodaction != null && prodaction.equals("Insert")) {
			TypeBean result = typeService.insert(bean);
			if (result == null) {
				errors.put("action", "Insert fail");
			} else {
				model.addAttribute("insert", result);
			}
			return "type.error";
		} else if (prodaction != null && prodaction.equals("Update")) {
			TypeBean result = typeService.update(bean);
			if (result == null) {
				errors.put("action", "Update fail");
			} else {
				model.addAttribute("update", result);
			}
			return "type.error";
		} else if (prodaction != null && prodaction.equals("Delete")) {
			boolean result = typeService.delete(bean);
			if (!result) {
				model.addAttribute("delete", 0);
			} else {
				model.addAttribute("delete", 1);
			}
			return "type.error";
		} else {
			errors.put("action", "Unknown Action:" + prodaction);
			return "type.error";
		}

	}

}
