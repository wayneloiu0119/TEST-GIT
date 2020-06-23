package controller;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.text.ParseException;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import model.bean.CourseBean;
import model.bean.TypeBean;
import model.service.CourseService;
import model.service.TypeService;
import model.spring.PrimitiveNumberEditor;

@Controller
// @MultipartConfig
// @RequestMapping(value = "/pages/course.controller")
public class CourseController {
	@Autowired
	private CourseService courseService;
	@Autowired
	private TypeService typeService;
	@Autowired
	SessionFactory sessionFactory;

	@InitBinder
	public void initBinder(WebDataBinder webDataBinder) {
		webDataBinder.registerCustomEditor(int.class, new PrimitiveNumberEditor(java.lang.Integer.class, true));
		webDataBinder.registerCustomEditor(double.class, new PrimitiveNumberEditor(java.lang.Double.class, true));
		webDataBinder.registerCustomEditor(java.util.Date.class,
				new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));
	}

	//// @RequestMapping(value = "/upload", method = RequestMethod.POST)
	// @RequestMapping(value = "/pages/course.controlle", method =
	//// RequestMethod.POST)
	// public String handleFormUpload(@RequestParam("coursePic") MultipartFile file)
	//// throws IOException{
	// if (!file.isEmpty()) {
	// BufferedImage src = ImageIO.read(new ByteArrayInputStream(file.getBytes()));
	// File destination = new File("File directory with file name"); // something
	//// like C:/Users/tom/Documents/nameBasedOnSomeId.png
	// ImageIO.write(src, "jpg", destination);
	// //Save the id you have used to create the file name in the DB. You can
	//// retrieve the image in future with the ID.
	// }
	// }
	//
	// @RequestMapping(method = { RequestMethod.GET, RequestMethod.POST })
	// public void method(CourseBean bean, @RequestParam("courseId") String
	// courseId, HttpServletResponse response) {
	// InputStream is = null;
	//
	// bean.setCourseId(Integer.parseInt(courseId));
	// List<CourseBean> courseBean = courseService.select(bean);
	//
	// // 設定圖片輸出格式
	//
	// try {
	//
	// System.out.println("courseBean.get(0)=" + courseBean.get(0));
	// is = courseBean.get(0).getCoursePic().getBinaryStream();
	// System.out.println("is=" + is);
	// response.setContentType("image/jpg");
	// int len = 0;
	// byte[] bytes = new byte[8192];
	// while ((len = is.read(bytes)) != -1) {
	// response.getOutputStream().write(bytes, 0, len);
	// }
	// } catch (SQLException e) {
	// e.printStackTrace();
	// } catch (IOException e) {
	// e.printStackTrace();
	// } finally {
	// try {
	// response.getOutputStream().flush();
	// response.getOutputStream().close();
	// } catch (IOException e) {
	// e.printStackTrace();
	// }
	// try {
	// is.close();
	// } catch (IOException e) {
	// e.printStackTrace();
	// }
	// }
	// }
	// // 以上為圖片處理

	@RequestMapping(value = "/pages/counse_front.controller", method = { RequestMethod.GET, RequestMethod.POST })
	public String method1(CourseBean coursebean, TypeBean typeBean, Model model)
			throws ParseException {
		List<CourseBean> result1 = courseService.select(coursebean);
		typeBean.setTypeId(coursebean.getTypeId());
		List<TypeBean> result2 = typeService.select(typeBean);
		if (!result1.isEmpty()) {
			model.addAttribute("select1", result2);
			model.addAttribute("select", result1);
//			System.out.println("result1="+result1);
//			System.out.println("result2="+result2);
		}
		return "course_front";
	}

	@RequestMapping(value = "/pages/course.controller", method = { RequestMethod.GET, RequestMethod.POST })
	public String method2(CourseBean bean, BindingResult bindingResult, Model model,
			@RequestParam("coursePic") MultipartFile coursePic, @RequestParam("prodaction") String prodaction) {

		System.out.println("bean=" + bean);
		System.out.println("bindingResult=" + bindingResult);
		// 接收資料
		// 轉換資料
		Map<String, String> errors = new HashMap<>();
		model.addAttribute("errors", errors);
		// 放入圖片進資料庫
		InputStream inputStream = null;
		if (!coursePic.isEmpty()) {
			try {
				inputStream = coursePic.getInputStream();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		Blob photo = this.sessionFactory.getCurrentSession().getLobHelper().createBlob(inputStream,
				coursePic.getSize());
		bean.setCoursePic(photo);

		// 判斷格式是否正確
		if (bindingResult != null && bindingResult.hasErrors()) {
			if (bindingResult.getFieldError("courseId") != null) {
				errors.put("xxx01", "courseId必須是整數(MVC)");
			}
			if (bindingResult.getFieldError("courseStartDate") != null) {
				errors.put("xxx02", "courseStartDate必須是符合YYYY-MM-DD格式的日期(MVC)");
			}
			if (bindingResult.getFieldError("courseEndDate") != null) {
				errors.put("xxx03", "courseEndDate必須是符合YYYY-MM-DD格式的日期(MVC)");
			}
			if (bindingResult.getFieldError("frequency") != null) {
				errors.put("xxx04", "frequency必須是整數(MVC)");
			}
			if (bindingResult.getFieldError("coursePrice") != null) {
				errors.put("xxx05", "coursePrice必須是數字(MVC)");
			}
			if (bindingResult.getFieldError("discount") != null) {
				errors.put("xxx06", "discount必須是數字(MVC)");
			}
			if (bindingResult.getFieldError("discountPrice") != null) {
				errors.put("xxx07", "discountPrice必須是數字(MVC)");
			}
			if (bindingResult.getFieldError("typeId") != null) {
				errors.put("xxx08", "typeId必須是整數(MVC)");
			}
			if (bindingResult.getFieldError("roomId") != null) {
				errors.put("xxx10", "roomId必須是整數(MVC)");
			}
			if (bindingResult.getFieldError("memberId") != null) {
				errors.put("xxx11", "memberId必須是整數(MVC)");
			}
		}

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
			return "course.error";
		}

		// 呼叫Model, 根據Model執行結果，呼叫View
		if ("Select".equals(prodaction)) {
			List<CourseBean> result = courseService.select(bean);
			model.addAttribute("select", result);
			return "course.select";
		} else if (prodaction != null && prodaction.equals("Insert")) {
			CourseBean result = courseService.insert(bean);
			if (result == null) {
				errors.put("action", "Insert fail");
			} else {
				model.addAttribute("insert", result);
			}
			return "course.error";
		} else if (prodaction != null && prodaction.equals("Update")) {
			CourseBean result = courseService.update(bean);
			if (result == null) {
				errors.put("action", "Update fail");
			} else {
				model.addAttribute("update", result);
			}
			return "course.error";
		} else if (prodaction != null && prodaction.equals("Delete")) {
			boolean result = courseService.delete(bean);
			if (!result) {
				model.addAttribute("delete", 0);
			} else {
				model.addAttribute("delete", 1);
			}
			return "course.error";
		} else {
			errors.put("action", "Unknown Action:" + prodaction);
			return "course.error";
		}
	}
}
