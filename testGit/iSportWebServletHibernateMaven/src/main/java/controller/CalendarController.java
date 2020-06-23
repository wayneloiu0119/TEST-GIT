package controller;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import model.CalendarDAO;
import model.bean.CalendarBean;
import model.bean.CourseBean;
import model.service.CalendarService;
import model.spring.PrimitiveNumberEditor;

@Controller
//@MultipartConfig
//@RequestMapping(value = "/pages/calendar.controller")
public class CalendarController {
	@Autowired
	private CalendarService calendarService;
	@Autowired
	SessionFactory sessionFactory;

	@InitBinder
	public void initBinder(WebDataBinder webDataBinder) {
		webDataBinder.registerCustomEditor(int.class, new PrimitiveNumberEditor(java.lang.Integer.class, true));
		webDataBinder.registerCustomEditor(double.class, new PrimitiveNumberEditor(java.lang.Double.class, true));
		webDataBinder.registerCustomEditor(java.util.Date.class,
				new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));
	}
//
//	 @ResponseBody
//	@RequestMapping(value = "/json.controller", method = { RequestMethod.GET, RequestMethod.POST }, produces = "application/json")
//	public List<CalendarBean> select(Model model) {
//		return calendarService.select(null);
//	}
//	public Map<String, Object> json(CalendarBean bean){
//		Map<String, Object> modelMap=new HashMap<String, Object>();
//		modelMap.put("title", bean.getCourseName());
//		modelMap.put("start", bean.getCourseStart());
//		modelMap.put("end", bean.getCourseEnd());
//		return modelMap;
//	}
	
	
	@RequestMapping(value = "/pages/calendar.controller", method = { RequestMethod.GET, RequestMethod.POST })
	public String method1(CalendarBean bean, BindingResult bindingResult, Model model,
			@RequestParam("prodaction") String prodaction) {

//		System.out.println("bean=" + bean);
//		System.out.println("bindingResult=" + bindingResult);
		// 接收資料
		// 轉換資料
		Map<String, String> errors = new HashMap<>();
		model.addAttribute("errors", errors);

		// 判斷格式是否正確
		// if (bindingResult != null && bindingResult.hasErrors()) {
		// if (bindingResult.getFieldError("courseId") != null) {
		// errors.put("xxx01", "courseId必須是整數(MVC)");
		// }
		// if (bindingResult.getFieldError("courseStartDate") != null) {
		// errors.put("xxx02", "courseStartDate必須是符合YYYY-MM-DD格式的日期(MVC)");
		// }
		// if (bindingResult.getFieldError("courseEndDate") != null) {
		// errors.put("xxx03", "courseEndDate必須是符合YYYY-MM-DD格式的日期(MVC)");
		// }
		// if (bindingResult.getFieldError("frequency") != null) {
		// errors.put("xxx04", "frequency必須是整數(MVC)");
		// }
		// if (bindingResult.getFieldError("coursePrice") != null) {
		// errors.put("xxx05", "coursePrice必須是數字(MVC)");
		// }
		// if (bindingResult.getFieldError("discount") != null) {
		// errors.put("xxx06", "discount必須是數字(MVC)");
		// }
		// if (bindingResult.getFieldError("discountPrice") != null) {
		// errors.put("xxx07", "discountPrice必須是數字(MVC)");
		// }
		// if (bindingResult.getFieldError("typeId") != null) {
		// errors.put("xxx08", "typeId必須是整數(MVC)");
		// }
		// if (bindingResult.getFieldError("roomId") != null) {
		// errors.put("xxx10", "roomId必須是整數(MVC)");
		// }
		// if (bindingResult.getFieldError("memberId") != null) {
		// errors.put("xxx11", "memberId必須是整數(MVC)");
		// }
		// }

		// 驗證資料
		// if("Insert".equals(prodaction) || "Update".equals(prodaction) ||
		// "Delete".equals(prodaction)) {
		// if(bean.getId()==0) {
		// errors.put("xxx1", "請輸入Id以便執行"+prodaction);
		// }
		// }
		if ("Update".equals(prodaction) || "Delete".equals(prodaction)) {
			if (bean.getCourseId() == 0) {
				errors.put("xxx01", "請輸入courseId以便執行" + prodaction);
			}
		}
		// insert時 courseId不能有值
		// if ("Insert".equals(prodaction)) {
		// if (bean.getCourseName() == null) {
		// errors.put("xxx01", "請輸入courseName以便執行" + prodaction);
		// }
		// }

		if (errors != null && !errors.isEmpty()) {
			return "calendar.error";
		}

		// 呼叫Model, 根據Model執行結果，呼叫View
		if ("Select".equals(prodaction)) {
			List<CalendarBean> result = calendarService.select(bean);
			model.addAttribute("select", result);
			System.out.println(result);
			return "calendar.select";
		} else if (prodaction != null && prodaction.equals("Insert")) {
			List<CalendarBean> result = calendarService.insertCourse(bean);
			if (result == null) {
				errors.put("action", "Insert fail");
			} else {
				model.addAttribute("insert", result);
			}
			return "calendar.error";
		} else if (prodaction != null && prodaction.equals("Update")) {
			CalendarBean result = calendarService.update(bean);
			if (result == null) {
				errors.put("action", "Update fail");
			} else {
				model.addAttribute("update", result);
			}
			return "calendar.error";
		} else if (prodaction != null && prodaction.equals("Delete")) {
			int result = calendarService.delete(bean);
			if (result==0) {
				model.addAttribute("delete", 0);
			} else {
				model.addAttribute("delete", result);
			}
			return "calendar.error";
		} else {
			errors.put("action", "Unknown Action:" + prodaction);
			return "calendar.error";
		}
	}
}
