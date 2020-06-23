package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;
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
import model.service.PartyService;
import model.spring.PrimitiveNumberEditor;

@Controller
//@RequestMapping("/Party/PartyCRUD.controller")
public class PartyController {

	@Autowired
	PartyService partyService;

	@InitBinder
	public void initBinder(WebDataBinder webDataBinder) {
		webDataBinder.registerCustomEditor(int.class, "partyId", new PrimitiveNumberEditor(Integer.class, true));
		webDataBinder.registerCustomEditor(int.class, "MemberId", new PrimitiveNumberEditor(Integer.class, true));
		webDataBinder.registerCustomEditor(String.class, "partyDate",
				new CustomDateEditor(new SimpleDateFormat("yyyy/MM/dd"), true));
		webDataBinder.registerCustomEditor(String.class, "partyTime",
				new CustomDateEditor(new SimpleDateFormat("HH:mm"), true));
		webDataBinder.registerCustomEditor(int.class, "number", new PrimitiveNumberEditor(Integer.class, true));
		webDataBinder.registerCustomEditor(int.class, "numberMax", new PrimitiveNumberEditor(Integer.class, true));
	}

	@RequestMapping(value= {"/Party/PartyCRUD.controller"},method= {RequestMethod.GET, RequestMethod.POST})
	public String method(PartyBean partyBean, BindingResult bindingResult, Model model,
			@RequestParam("prodaction") String prodaction) {
		// 轉換資料
		Map<String, String> errors = new HashMap<>();
		model.addAttribute("errors", errors);
		if (bindingResult != null && bindingResult.hasFieldErrors()) {
			if (bindingResult.getFieldError("partyID") != null) {
				errors.put("partyId", "PartyId必須為整數(MVC)");
			}
			if (bindingResult.getFieldError("memberID") != null) {
				errors.put("memberId", "MemberId必須為整數(MVC)");
			}
			if (bindingResult.getFieldError("partyDate") != null) {
				errors.put("partyDate", "PartyDate格式必須為yyyy/MM/dd(MVC)");
			}
			if (bindingResult.getFieldError("partyTime") != null) {
				errors.put("partyTime", "PartyTime格式必須為HH:mm(MVC)");
			}
			if (bindingResult.getFieldError("number") != null) {
				errors.put("number", "number必須為整數(MVC)");
			}
			if (bindingResult.getFieldError("numberMax") != null) {
				errors.put("numberMax", "NumberMax格式必須為yyyy/MM/dd(MVC)");
			}

		}

		// 驗證資料

		if ("Update".equals(prodaction) || "Delete".equals(prodaction)) {
			if (partyBean.getPartyId() == 0) {
				errors.put("partyId", "請輸入Id以便執行");
			}
		}

		if (errors != null && !errors.isEmpty()) {
			return "party.error";
		}
		// 根據Model執行結果，呼叫View
		if ("Select".equals(prodaction)) {
			List<PartyBean> result = partyService.selectALLParty();
			model.addAttribute("select", result);
			return "party.succe";
		} else if (prodaction != null && prodaction.equals("SelectOne")) {
			List<PartyBean> result = partyService.selectMemeberParty(partyBean.getMemberId());
			System.out.println("result = " + result);
			if (result == null) {
				errors.put("action", "Insert fail");
			} else {
				model.addAttribute("SelectOne", result);
			}
			return "partyMan.succe";
		}else if (prodaction != null && prodaction.equals("Insert")) {
			PartyBean result = partyService.insertNewParty(partyBean);
			if (result == null) {
				errors.put("action", "Insert fail");
			} else {
				model.addAttribute("insert", result);
			}
			return "party.error";
		} else if (prodaction != null && prodaction.equals("Update")) {
			PartyBean result = partyService.updatePartyInfo(partyBean);
			System.out.println("result =" +result );
			if (result == null) {
				errors.put("action", "Update fail");
			} else {
				model.addAttribute("update", result);
			}
			return "party.error";
		} else if (prodaction != null && prodaction.equals("Delete")) {
			boolean result = partyService.deleteParty(partyBean.getPartyId());
			if (!result) {
				model.addAttribute("delete", 0);
			} else {
				model.addAttribute("delete", 1);
			}
			return "party.error";
		} else {
			errors.put("action", "Unknown Action:" + prodaction);
			return "party.error";
		}

	}
	
	@RequestMapping(value= {"/SelectAllParty.controller"})
	public String method2(Model model) {
		List<PartyBean> result = partyService.selectALLParty();
		model.addAttribute("select", result);
		return "party.succe";
	}
	
	
	
	
	
	
	
	
	
	
	
	@RequestMapping(value= {"/Party/SelectOneParty.view"},method=RequestMethod.POST)
	public void method( String partyId, Model model, HttpServletResponse response) throws IOException {
		System.out.println("SDAD");
		System.out.println(partyId);
		int partyD = Integer.parseInt(partyId);
		System.out.println(partyD);
		PrintWriter out = response.getWriter();
		JSONArray jsonArray = new JSONArray();
		JSONObject obj = new JSONObject();
		PartyBean bean = partyService.selectOneParty(partyD);
		obj.put("partyName", bean.getPartyName());
		obj.put("partyDate", bean.getPartyDate());
		obj.put("partyTime", bean.getPartyTime());
		obj.put("partyNumber", bean.getNumber());
		obj.put("partyNumberMax", bean.getNumberMax());
		obj.put("partyLocation", bean.getPartyLocation());
		jsonArray.put(obj);
		out.write(jsonArray.toString());
		out.close();
//		return;
	}
}
