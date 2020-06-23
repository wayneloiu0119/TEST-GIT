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

import model.bean.BlackFriendBean;
import model.service.BlackFriendService;
import model.spring.PrimitiveNumberEditor;

@Controller
@RequestMapping("/pages/blackFriend.controller")
public class BlackFriendController {
	
	
	@Autowired
	private BlackFriendService blackFriendService;

		@InitBinder
		public void initBinder(WebDataBinder webDataBinder) {
			webDataBinder.registerCustomEditor(int.class,"blackFriendId",new PrimitiveNumberEditor(java.lang.Integer.class, true));
			webDataBinder.registerCustomEditor(int.class,"memberId", new PrimitiveNumberEditor(java.lang.Integer.class, true));
			webDataBinder.registerCustomEditor(int.class,"relationMemberId", new PrimitiveNumberEditor(java.lang.Integer.class, true));
					
		}

//		@RequestMapping(method = { RequestMethod.GET, RequestMethod.POST })
//		public static void main(String[] args) {
//			System.out.println("hahahahahah");
//		}

		@RequestMapping(method = { RequestMethod.GET, RequestMethod.POST })
		public String method(BlackFriendBean bean, BindingResult bindingResult, Model model,
				@RequestParam(value = "prodaction") String prodaction) {
			System.out.println("bean=" + bean);
			System.out.println("bindingResult=" + bindingResult);
			// 接收資料
			// 轉換資料
			Map<String, String> errors = new HashMap<>();
			model.addAttribute("errors", errors);

			if (bindingResult != null && bindingResult.hasErrors()) {
				if (bindingResult.getFieldError("blackFriendId") != null) {
					errors.put("xxx1", "blackFriendId必須是整數(MVC)");
				}
				if (bindingResult.getFieldError("memberId") != null) {
					errors.put("xxx2", "memberId必須是數字(MVC)");
				}
				if (bindingResult.getFieldError("relationMemberId") != null) {
					errors.put("xxx3", "relationMemberId必須是整數(MVC)");
				}

				

			}

			// 驗證資料
//			if ("Insert".equals(prodaction) || "Update".equals(prodaction) || "Delete".equals(prodaction)) {
//				if (bean.getBlackFriendId() == 0) {
//					errors.put("xxx1", "請輸入Id以便執行" + prodaction);
//				}
//			}
//	
//			if (errors != null && !errors.isEmpty()) {
//	
//				return "blackFriend.error";
//			}

			// 呼叫model

			// 根據model執行結果，導向view

			if ("SelectBlackFriend".equals(prodaction)) {
				List<BlackFriendBean> result = blackFriendService.selects(bean);
				model.addAttribute("select", result);
				return "blackFriend.select";
				
			}else if(prodaction != null && prodaction.equals("SelectMemberId")) {
				List<Object[]> result = blackFriendService.selectFriendMemberId(bean.getMemberId());
				model.addAttribute("select",result);
				return "blackFriendSelectMemberId.select";
			}else if(prodaction != null && prodaction.equals("SelectBlackFriendType")) {
				List<Object[]> result = blackFriendService.selectFriendType(bean.getMemberId(), bean.getBlackFriendType());
				model.addAttribute("select",result);
				return "blcakFriendSelectType.select";
			} 
			else if (prodaction != null && prodaction.equals("Insert")) {
				BlackFriendBean result = blackFriendService.insert(bean);
				if (result == null) {
					errors.put("action", "Insert fail");
				} else {
					model.addAttribute("insert", result);
				}
				return "blackFriend.error";
			} else if (prodaction != null && prodaction.equals("Update")) {
				BlackFriendBean result = blackFriendService.update(bean);
				if (result == null) {
					errors.put("action", "Update fail");
				} else {
					model.addAttribute("update", result);
				}
				return "blackFriend.error";
			} else if (prodaction != null && prodaction.equals("Delete")) {
				boolean result = blackFriendService.delete(bean);
				if (!result) {
					model.addAttribute("delete", 0);
				} else {
					model.addAttribute("delete", 1);
				}
				return "blackFriend.error";
			} else {
				errors.put("action", "Unknown Action:" + prodaction);
				return "blackFriend.error";
			}

		}

}
