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

import model.bean.AnnouncementBean;
import model.service.AnnouncementService;
import model.spring.PrimitiveNumberEditor;

@Controller
@RequestMapping("/pages/announcement.controller")
public class AnnouncementController {

@Autowired
private AnnouncementService announcementService;

	@InitBinder
	public void initBinder(WebDataBinder webDataBinder) {
		webDataBinder.registerCustomEditor(int.class, "memberId",new PrimitiveNumberEditor(java.lang.Integer.class, true));
		webDataBinder.registerCustomEditor(int.class, "announcementId",new PrimitiveNumberEditor(java.lang.Integer.class, true));
		webDataBinder.registerCustomEditor(int.class, "courseId",new PrimitiveNumberEditor(java.lang.Integer.class, true));
				
	}

//	@RequestMapping(method = { RequestMethod.GET, RequestMethod.POST })
//	public static void main(String[] args) {
//		System.out.println("hahahahahah");
//	}

	@RequestMapping(method = { RequestMethod.GET, RequestMethod.POST })
	public String method(AnnouncementBean bean, BindingResult bindingResult, Model model,
			@RequestParam(value = "prodaction") String prodaction) {
		System.out.println("bean=" + bean);
		System.out.println("bindingResult=" + bindingResult);
		// 接收資料
		// 轉換資料
		Map<String, String> errors = new HashMap<>();
		model.addAttribute("errors", errors);

//		if (bindingResult != null && bindingResult.hasErrors()) {
//			if (bindingResult.getFieldError("announcementId") != null) {
//				errors.put("xxx1", "announcementId必須是整數(MVC)");
//			}
//			if (bindingResult.getFieldError("memberId") != null) {
//				errors.put("xxx2", "memberId必須是整數(MVC)");
//			}
//			if (bindingResult.getFieldError("gameId") != null) {
//				errors.put("xxx3", "gameId必須是數字(MVC)");
//			}
//
//			if (bindingResult.getFieldError("courseId") != null) {
//				errors.put("xxx4", "courseId必須是數字(MVC)");
//			}
//
//		}

		// 驗證資料
		if ("Update".equals(prodaction) || "Delete".equals(prodaction)) {
			if (bean.getAnnouncementId() == 0) {
				errors.put("xxx1", "請輸入Id以便執行" + prodaction);
			}
		}

		if (errors != null && !errors.isEmpty()) {

			return "announcement.error";
		}

		// 呼叫model

		// 根據model執行結果，導向view

		if ("Select".equals(prodaction)) {
			List<AnnouncementBean> result = announcementService.selects(bean);
			model.addAttribute("select", result);
			return "announcement.select";
		} else if(prodaction != null && prodaction.equals("SelectGameId")) {
			List<Object[]> result = announcementService.selectGameId(bean.getGameId());
			model.addAttribute("select",result);
			return "announcementSelectGameId.select";
		}else if(prodaction != null && prodaction.equals("SelectGame")) {
			List<Object[]> result = announcementService.selectAllGame();
			model.addAttribute("select",result);
			return "announcementSelectGame.select";
		}else if (prodaction != null && prodaction.equals("SelectCourseId")) {
			List<Object[]> result = announcementService.selectCourseId(bean.getCourseId());
			model.addAttribute("select",result);
			return "announcementSelectCourseId.select";
		}else if(prodaction != null && prodaction.equals("SelectCourse")) {
			List<Object[]> result = announcementService.selectAllCourse();
			model.addAttribute("select",result);
			return "announcementSelectCourse.select";
		}
		else if (prodaction != null && prodaction.equals("Insert")) {
			AnnouncementBean result = announcementService.insert(bean);
			if (result == null) {
				errors.put("action", "Insert fail");
			} else {
				model.addAttribute("insert", result);
			}
			return "announcement.error";
		} else if (prodaction != null && prodaction.equals("Update")) {
			AnnouncementBean result = announcementService.update(bean);
			if (result == null) {
				errors.put("action", "Update fail");
			} else {
				model.addAttribute("update", result);
			}
			return "announcement.error";
		} else if (prodaction != null && prodaction.equals("Delete")) {
			boolean result = announcementService.delete(bean);
			if (!result) {
				model.addAttribute("delete", 0);
			} else {
				model.addAttribute("delete", 1);
			}
			return "announcement.error";
		} else {
			errors.put("action", "Unknown Action:" + prodaction);
			return "announcement.error";
		}

	}

}
