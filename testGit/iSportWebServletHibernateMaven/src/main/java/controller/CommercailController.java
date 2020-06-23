package controller;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import model.bean.CommercialBean;
import model.service.CommercialService;
import model.spring.PrimitiveNumberEditor;

@Component
@RequestMapping("/Commercial/CommercialCRUD.controller")
public class CommercailController {

	@Autowired
	CommercialService commService;
	@Autowired
	SessionFactory sessionFactory;

	@InitBinder
	public void initBinder(WebDataBinder webDataBinder) {
		webDataBinder.registerCustomEditor(int.class, new PrimitiveNumberEditor(java.lang.Integer.class, true));
	}

	@RequestMapping(method = { RequestMethod.GET, RequestMethod.POST })
	public String method(CommercialBean commBean, BindingResult bindingResult, Model model,
			@RequestParam("pic") MultipartFile pic, @RequestParam("prodaction") String prodaction) {

		// 轉換資料
		Map<String, String> errors = new HashMap<>();
		model.addAttribute("errors", errors);

		InputStream is = null;
		if(!pic.isEmpty()) {
			try {
				is = pic.getInputStream();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		Blob pic1 =  this.sessionFactory.getCurrentSession().getLobHelper().createBlob(is, pic.getSize());
		commBean.setPic(pic1);
		
		if (bindingResult != null && bindingResult.hasFieldErrors()) {
			if (bindingResult.getFieldError("commercialId") != null) {
				errors.put("commercialId", "CommercialId必須為整數(MVC)");
			}
			if (bindingResult.getFieldError("gameId") != null) {
				errors.put("gameId", "gameId必須為整數(MVC)");
			}
			if (bindingResult.getFieldError("courseId") != null) {
				errors.put("courseId", "courseId必須為整數(MVC)");
			}
		}

		if (errors != null && !errors.isEmpty()) {
			return "comm.error";
		}

		// 驗證資料

		if ("Update".equals(prodaction) || "Delete".equals(prodaction)) {
			if (commBean.getCourseId() == 0) {
				if (commBean.getGameId() != 0)
					errors.put("gameId", "請輸入Id以便執行");
			}
			if (commBean.getGameId() == 0) {
				if (commBean.getCourseId() != 0) {
					errors.put("courseId", "請輸入Id以便執行");
				}
			}
		}

		if (errors != null && !errors.isEmpty()) {
			return "comm.error";
		}

		// 根據Model執行結果，呼叫View
		if ("Select".equals(prodaction)) {
			List<CommercialBean> result = commService.selectAllCommercial();
			model.addAttribute("select", result);
			return "comm.succe";

		} else if (prodaction != null && prodaction.equals("Insert")) {
			CommercialBean result = null;
			if(commBean.getGameId()==0) {
				result = commService.insertNewGcourseDM(commBean);
			}
			if(commBean.getCourseId()==0) {
				result = commService.insertNewGameDM(commBean);
			}
			
			if(result==null) {
				errors.put("action", "Insert fail");
			} else {
				model.addAttribute("insert", result);
			}
			return "comm.error";
		}else if (prodaction != null && prodaction.equals("Delete")) {

			boolean result = commService.deleteCommercial(commBean.getCommercialId());
			if (!result) {
				model.addAttribute("delete", 0);
			} else {
				model.addAttribute("delete", 1);
			}
			return "comm.error";
		} else {
			errors.put("action", "Unknown Action:" + prodaction);
			return "comm.error";
		}

	}

}
