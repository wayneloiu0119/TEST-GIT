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
import model.service.OredersListService;
import model.spring.PrimitiveNumberEditor;

@Controller
@RequestMapping("/pages/ordersList.controller")
public class OredersListController extends HttpServlet {

	@Autowired
	private OredersListService oredersListService;

	@InitBinder
	public void initBinder(WebDataBinder webDataBinder) {
		webDataBinder.registerCustomEditor(int.class, new PrimitiveNumberEditor(java.lang.Integer.class, true));
	}

	@RequestMapping(method = { RequestMethod.GET, RequestMethod.POST })
	public String method(OrdersListBean bean, BindingResult bindingResult, Model model,
			@RequestParam("prodaction") String prodaction) {

		System.out.println("OredersListController_bean=" + bean);
		System.out.println("OredersListController_bindingResult=" + bindingResult);
		// 接收資料

		// 轉換資料
		Map<String, String> errors = new HashMap<>();
		model.addAttribute("errors", errors);

		if (bindingResult != null && bindingResult.hasErrors()) {
			if (bindingResult.getFieldError("orderId") != null) {
				errors.put("xxx1", "Id必須是整數");
			}
		}

		// 驗證資料
		if ("Insert".equals(prodaction)) {
			if (bean.getOrderId() == 0) {
				errors.put("xxx1", "請輸入OrderId以便執行" + prodaction);
			}
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
			if (bean.getOrderId() == 0) {
				errors.put("xxx1", "請輸入OrderId以便執行" + prodaction);
			}
			if (bean.getMemberId() == 0) {
				errors.put("xxx2", "請輸入MemberId以便執行" + prodaction);
			}
		}

		if (errors != null && !errors.isEmpty()) {

			return "oredersList.error";
		}

		// 呼叫model

		// 根據model執行結果，導向view

		if ("Select".equals(prodaction)) {
			if (bean.getOrderId() != 0 && bean.getCourseId() == 0) {

				List<OrdersListBean> result = oredersListService.selectByOrderId(bean);
				model.addAttribute("select", result);
				return "oredersList.select";
			} else {

				List<OrdersListBean> result = oredersListService.select(bean);
				model.addAttribute("select", result);
				return "oredersList.select";
			}

		} else if (prodaction != null && prodaction.equals("Insert")) {
			OrdersListBean result = oredersListService.insert(bean);
			if (result == null) {
				errors.put("action", "Insert fail");
			} else {
				model.addAttribute("insert", result);
			}
			return "oredersList.error";

		} else if (prodaction != null && prodaction.equals("Update")) {
			OrdersListBean result = oredersListService.update(bean);
			if (result == null) {
				errors.put("action", "Update fail");
			} else {
				model.addAttribute("update", result);
			}
			return "oredersList.error";

		} else if (prodaction != null && prodaction.equals("Delete")) {
			boolean result = oredersListService.delete(bean);
			if (!result) {
				model.addAttribute("delete", 0);
			} else {
				model.addAttribute("delete", 1);
			}
			return "oredersList.error";

		} else {
			errors.put("action", "Unknown Action:" + prodaction);
			return "oredersList.error";
		}

	}
}
