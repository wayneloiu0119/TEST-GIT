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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import model.bean.MessageBean;
import model.service.MessageService;
import model.spring.PrimitiveNumberEditor;

@Controller
@RequestMapping("/pages/MessageMemberId.controller")
public class MessageMemberIdController {

	@Autowired
	private MessageService messageService;
	@Autowired
	private SessionFactory sessionFactory;

	@InitBinder
	public void initBinder(WebDataBinder webDataBinder) {
		webDataBinder.registerCustomEditor(int.class, "messageId",new PrimitiveNumberEditor(java.lang.Integer.class, true));
		webDataBinder.registerCustomEditor(int.class, "memberId", new PrimitiveNumberEditor(java.lang.Integer.class, true));
		webDataBinder.registerCustomEditor(int.class, "star",new PrimitiveNumberEditor(java.lang.Integer.class, true));
		webDataBinder.registerCustomEditor(java.util.Date.class, "messageTime",
				new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));

	}

	// @RequestMapping(method = { RequestMethod.GET, RequestMethod.POST })
	// public static void main(String[] args) {
	// System.out.println("hahahahahah");
	// }

	@RequestMapping(method = { RequestMethod.GET, RequestMethod.POST })
	public String method(MessageBean bean, BindingResult bindingResult, Model model,
			@RequestParam("messagePic") MultipartFile file, @RequestParam("prodaction") String prodaction) {
		System.out.println("bean=" + bean);
		System.out.println("bindingResult=" + bindingResult);
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
		//
		// // Blob photo =
		// //
		// //
		// Hibernate.getLobCreator(sessionFactory.getCurrentSession()).createBlob(fileContent,
		// // photoFile.getSize());
		//
		// //
		// //
		// https://stackoverflow.com/questions/20614973/read-write-blob-data-in-chunks-with-hibernate
		// }
		//
		Blob messagePic = this.sessionFactory.getCurrentSession().getLobHelper().createBlob(inputStream,
				file.getSize());
		////////////////////////////////////////////////////////////////////

		if (bindingResult != null && bindingResult.hasErrors()) {
			if (bindingResult.getFieldError("blackFriendId") != null) {
				errors.put("xxx1", "messageId必須是整數(MVC)");
			}
			if (bindingResult.getFieldError("memberId") != null) {
				errors.put("xxx2", "memberId必須是數字(MVC)");
			}

		}

		// 驗證資料
		 if ("Update".equals(prodaction) || "Delete".equals(prodaction)) {
		 if (bean.getMessageId() == 0) {
		 errors.put("xxx1", "請輸入Id以便執行" + prodaction);
		 }
		 }
		
		 if (errors != null && !errors.isEmpty()) {
		
		 return "message.error";
		 }

		// 呼叫model
		bean.setMessageId(bean.getMessageId());
		bean.setMemberId(bean.getMemberId());
		bean.setMessageTime(bean.getMessageTime());
		bean.setTypeName(bean.getTypeName());
		
		bean.setMessageText(bean.getMessageText());
		
		bean.setMessagePic(messagePic);
		
		bean.setStar(bean.getStar());
		;
		// 驗證資料
		if ("Update".equals(prodaction) || "Delete".equals(prodaction)) {
			if (bean.getMessageId() == 0) {
				errors.put("xxx1", "請輸入Id以便執行" + prodaction);
			}
		}

		if (errors != null && !errors.isEmpty()) {
			return "message.error";
		}

		// 呼叫model
		bean.setMessagePic(messagePic);

		// 根據model執行結果，導向view

		if ("Select".equals(prodaction)) {
			List<Object[]> result = messageService.selectAll(bean);
			model.addAttribute("select", result);
			return "messageMemberIdDelete.select";
		}else if(prodaction != null && prodaction.equals("SelectMessageMemberId")) {
			List<Object[]> result = messageService.selectMemberId(bean.getMemberId());
			model.addAttribute("select", result);
			return "messageMyMemberId.select";
		}else if (prodaction != null && prodaction.equals("Insert")) {
			MessageBean result = messageService.insert(bean);
			if (result == null) {
				errors.put("action", "Insert fail");
			} else {
				model.addAttribute("insert", result);
			}
			return "messageMemberSelect.error";
		} else if (prodaction != null && prodaction.equals("Update")) {
			MessageBean result = messageService.update(bean);
			if (result == null) {
				errors.put("action", "Update fail");
			} else {
				model.addAttribute("update", result);
			}
			return "messageMemberSelect.error";
		} else if (prodaction != null && prodaction.equals("Delete")) {
			boolean result = messageService.delete(bean);
			if (!result) {
				model.addAttribute("delete", 0);
			} else {
				model.addAttribute("delete", 1);
			}
			return "messageMemberSelect.error";
		} else {
			errors.put("action", "Unknown Action:" + prodaction);
			return "messageMemberSelect.error";
		}

	}

}
