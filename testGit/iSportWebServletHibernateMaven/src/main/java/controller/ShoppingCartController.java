package controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServlet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import model.bean.OrdersListBean;
import model.bean.ShoppingCartBean;
import model.service.ShoppingCartService;
import model.spring.PrimitiveNumberEditor;

@Controller
@RequestMapping("/pages/shoppingCart.controller")
public class ShoppingCartController extends HttpServlet {
	@Autowired
	private ShoppingCartService shoppingCartService;

	@InitBinder
	public void initBinder(WebDataBinder webDataBinder) {
		webDataBinder.registerCustomEditor(int.class, new PrimitiveNumberEditor(java.lang.Integer.class, true));
	}

	@RequestMapping(method = { RequestMethod.GET, RequestMethod.POST })
	public String method(ShoppingCartBean bean, BindingResult bindingResult, Model model,
			@RequestParam("prodaction") String prodaction) {

		System.out.println("bean=" + bean);
		System.out.println("bindingResult=" + bindingResult);
		// 接收資料

		// 轉換資料
		Map<String, String> errors = new HashMap<>();
		model.addAttribute("errors", errors);

		if (bindingResult != null && bindingResult.hasErrors()) {
			if (bindingResult.getFieldError("shoppingCartId") != null) {
				errors.put("xxx1", "shoppingCartId必須是整數");
			}
		}

		// 驗證資料
		if ("Insert".equals(prodaction)) {
			if (bean.getMemberId() == 0) {
				errors.put("xxx2", "請輸入MemberId以便執行" + prodaction);
			}
			if (bean.getCourseId() == 0) {
				errors.put("xxx3", "請輸入CourseId以便執行" + prodaction);
			}
			if (bean.getCourseName() == null || bean.getCourseName().length() == 0) {
				errors.put("xxx4", "請輸入CourseName以便執行" + prodaction);
			}
			if (bean.getCoursePrice() == 0) {
				errors.put("xxx5", "請輸入CoursePrice以便執行" + prodaction);
			}

		}
		if ("Update".equals(prodaction) || "Delete".equals(prodaction)) {
			if (bean.getShoppingCartId() == 0) {
				errors.put("xxx1", "請輸入shoppingCartId以便執行" + prodaction);
			}
		}

		if (errors != null && !errors.isEmpty()) {

			return "shoppingCart.error";
		}

		// 呼叫model

		// 根據model執行結果，導向view

		if ("Select".equals(prodaction)) {
			if (bean.getMemberId() != 0 && bean.getShoppingCartId() == 0) {
				List<ShoppingCartBean> result = shoppingCartService.selectByMemberId(bean);
				model.addAttribute("select", result);
				return "shoppingCart.select";
			} else {
				List<ShoppingCartBean> result = shoppingCartService.select(bean);
				model.addAttribute("select", result);
				return "shoppingCart.select";
			}

		} else if (prodaction != null && prodaction.equals("Insert")) {
			ShoppingCartBean result = shoppingCartService.insert(bean);
			if (result == null) {
				errors.put("action", "Insert fail");
			} else {
				model.addAttribute("insert", result);
			}
			return "shoppingCart.error";

		} else if (prodaction != null && prodaction.equals("Update")) {
			ShoppingCartBean result = shoppingCartService.update(bean);
			if (result == null) {
				errors.put("action", "Update fail");
			} else {
				model.addAttribute("update", result);
			}
			return "shoppingCart.error";

		} else if (prodaction != null && prodaction.equals("Delete")) {
			boolean result = shoppingCartService.delete(bean);
			if (!result) {
				model.addAttribute("delete", 0);
			} else {
				model.addAttribute("delete", 1);
			}
			return "shoppingCart.error";

		} else {
			errors.put("action", "Unknown Action:" + prodaction);
			return "shoppingCart.error";
		}

	}

}
