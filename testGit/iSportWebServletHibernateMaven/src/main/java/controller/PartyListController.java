package controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

import model.bean.PartyBean;
import model.bean.PartyListBean;
import model.service.PartyListService;
import model.service.PartyService;
import model.spring.PrimitiveNumberEditor;

@Controller
@RequestMapping("/Party/JoinQuitParty.controller")
public class PartyListController {

	@Autowired
	PartyListService partyListService;
	@Autowired
	PartyService partyService;

	@InitBinder
	public void initBinder(WebDataBinder webDataBinder) {
		webDataBinder.registerCustomEditor(int.class, "partyListId", new PrimitiveNumberEditor(Integer.class, true));
		webDataBinder.registerCustomEditor(int.class, "partyId", new PrimitiveNumberEditor(Integer.class, true));
		webDataBinder.registerCustomEditor(int.class, "memberId", new PrimitiveNumberEditor(Integer.class, true));
		webDataBinder.registerCustomEditor(String.class, "partyJoinDate",
				new CustomDateEditor(new SimpleDateFormat("yyyy/MM/dd"), true));
		webDataBinder.registerCustomEditor(String.class, "partyJoinTime",
				new CustomDateEditor(new SimpleDateFormat("HH:mm"), true));
		webDataBinder.registerCustomEditor(String.class, "partyDate",
				new CustomDateEditor(new SimpleDateFormat("yyyy/MM/dd"), true));
		webDataBinder.registerCustomEditor(String.class, "partyTime",
				new CustomDateEditor(new SimpleDateFormat("HH:mm"), true));
		webDataBinder.registerCustomEditor(int.class, "number", new PrimitiveNumberEditor(Integer.class, true));
		webDataBinder.registerCustomEditor(int.class, "numberMax", new PrimitiveNumberEditor(Integer.class, true));
	}

	@RequestMapping(method = { RequestMethod.GET, RequestMethod.POST })
	public String method(PartyListBean partyListBean, PartyBean partyBean, BindingResult bindingResult, Model model,
			@RequestParam("prodaction") String prodaction) {
		// 轉換資料
		Map<String, String> errors = new HashMap<>();
		model.addAttribute("errors", errors);
		if (bindingResult != null && bindingResult.hasFieldErrors()) {
			// if (bindingResult.getFieldError("partyListId") != null) {
			// errors.put("partyListId", "PartyListId必須為整數(MVC)");
			// }
			if (bindingResult.getFieldError("partyId") != null) {
				errors.put("partyId", "PartyId必須為整數(MVC)");
			}
			if (bindingResult.getFieldError("memberId") != null) {
				errors.put("memberId", "MemberId必須為整數(MVC)");
			}
			if (bindingResult.getFieldError("partyJoinDate") != null) {
				errors.put("partyJoinDate", "PartyJoinDate格式必須為yyyy/MM/dd(MVC)");
			}
			if (bindingResult.getFieldError("partyJoinTime") != null) {
				errors.put("partyJoinTime", "PartyJoinTime格式必須為HH:mm(MVC)");
			}
		}
		if (errors != null && !errors.isEmpty()) {
			return "partyList.error";
		}
		// 驗證資料
		if ("Insert".equals(prodaction) || "Delete".equals(prodaction)) {
			if (partyListBean.getPartyId() == 0) {
				errors.put("partyId", "請輸入PartyId以便執行" + prodaction);
			}
			if (partyListBean.getMemberId() == 0) {
				errors.put("memberId", "請入MemberId以執行" + prodaction);
			}
		}

		if (errors != null && !errors.isEmpty()) {
			return "partyList.error";
		}
		// 呼叫Model
		// 根據Model執行結果，呼叫View
		if ("SelectAll".equals(prodaction)) {
			List<Object[]> plb = partyListService.showAllPartyAllMember();
			model.addAttribute("select", plb);
	
			return "partyList.succe";
		} else if (prodaction != null && prodaction.equals("ShowPartyByMemberId")) {
			List<Object[]> result = partyListService.showPartyByMemeberId(partyListBean.getMemberId());
			model.addAttribute("select", result);
			return "partyList.succe";

		} else if (prodaction != null && prodaction.equals("ShowMemberByPartyId")) {
			List<Object[]> result = partyListService.showMemberByPartyID(partyListBean.getPartyId());
			model.addAttribute("select", result);
			return "partyList.succe";
		} else if (prodaction != null && prodaction.equals("Insert")) {
			PartyListBean result = partyListService.joinParty(partyListBean);
			if (result == null) {
				errors.put("action", "join fail");
			} else {
				model.addAttribute("insert", result);
			}
			return "partyList.error";
		} else if (prodaction != null && prodaction.equals("Delete")) {
			boolean result = partyListService.quitParty(partyListBean.getMemberId(), partyListBean.getPartyId());
			if (!result) {
				model.addAttribute("delete", 0);
			} else {
				model.addAttribute("delete", 1);
			}
			return "partyList.error";
		} else {
			errors.put("action", "Unknown Action:" + prodaction);
			return "partyList.error";
		}
	}

}
