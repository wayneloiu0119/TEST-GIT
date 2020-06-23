package controller;

import java.text.SimpleDateFormat;
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

import model.bean.GameListBean;
import model.service.GameListService;
import model.spring.PrimitiveNumberEditor;

@Controller
@RequestMapping("/Game/JoinQuitGame.controller")
public class GameListController {

	@Autowired
	GameListService gameListService;

	@InitBinder
	public void initBinder(WebDataBinder webDataBinder) {
		webDataBinder.registerCustomEditor(int.class, "gameListId", new PrimitiveNumberEditor(Integer.class, true));
		webDataBinder.registerCustomEditor(int.class, "gameId", new PrimitiveNumberEditor(Integer.class, true));
		webDataBinder.registerCustomEditor(int.class, "memberId", new PrimitiveNumberEditor(Integer.class, true));
		webDataBinder.registerCustomEditor(String.class, "gameJoinDate",
				new CustomDateEditor(new SimpleDateFormat("yyyy/MM/dd"), true));
		webDataBinder.registerCustomEditor(String.class, "gameJoinTime",
				new CustomDateEditor(new SimpleDateFormat("HH:mm"), true));
	}

	@RequestMapping(method= {RequestMethod.GET, RequestMethod.POST})
	public String method(GameListBean gameListBean, BindingResult bindingResult, Model model,
			@RequestParam("prodaction") String prodaction) {
		// 接收資料
				// 轉換資料
				Map<String, String> errors = new HashMap<>();
				model.addAttribute("errors", errors);
				if (bindingResult != null && bindingResult.hasFieldErrors()) {
//					if (bindingResult.getFieldError("gameListId") != null) {
//						errors.put("gameListId", "GameListId必須為整數(MVC)");
//					}
					if (bindingResult.getFieldError("gameId") != null) {
						errors.put("gameId", "GameId必須為整數(MVC)");
					}
					if (bindingResult.getFieldError("memberId") != null) {
						errors.put("memberId", "MemberId必須為整數(MVC)");
					}
					if (bindingResult.getFieldError("gameJoinDate") != null) {
						errors.put("gameJoinDate", "GameJoinDate格式必須為yyyy/MM/dd(MVC)");
					}
					if (bindingResult.getFieldError("gameJoinTime") != null) {
						errors.put("gameJoinTime", "GameJoinTime格式必須為HH:mm(MVC)");
					}
				}
				if (errors != null && !errors.isEmpty()) {
					return "gameList.error";
				}
				// 驗證資料
				if ("Insert".equals(prodaction) || "Delete".equals(prodaction)) {
					if (gameListBean.getGameId() == 0) {
						errors.put("gameId", "請輸入GameId以便執行" + prodaction);
					}
					if(gameListBean.getMemberId() ==0) {
						errors.put("memberId", "請入MemberId以執行" + prodaction);
					}
				}

				if (errors != null && !errors.isEmpty()) {
					return "gameList.error";
				}
				// 呼叫Model
				// 根據Model執行結果，呼叫View
				if ("SelectAll".equals(prodaction)) {
					List<Object[]> result = gameListService.selectAllGameAllMember();
					model.addAttribute("select", result);
					return "gameList.manager";
				}else if(prodaction != null && prodaction.equals("ShowGameByMemberId")) {
						List<Object[]> result = gameListService.showGameByMemberId(gameListBean.getMemberId());
						model.addAttribute("select", result);	
						return "gameList.succe";
					
				} else if(prodaction != null && prodaction.equals("ShowMemberByGameId")) {
					List<Object[]> result = gameListService.showMemberByGameId(gameListBean.getGameId());
					model.addAttribute("select", result);
					return "gameList.succe";
				}else if (prodaction != null && prodaction.equals("Insert")) {
					System.out.println("SDADASD");
					GameListBean result = gameListService.joinGame(gameListBean);
					if (result == null) {
						errors.put("action", "join fail");
					} else {
						model.addAttribute("insert", result);
					}
					return "gameList.error";
				} else if (prodaction != null && prodaction.equals("Delete")) {
					boolean result = gameListService.quitGame(gameListBean.getMemberId(), gameListBean.getGameId());
					if (!result) {
						model.addAttribute("delete", 0);
					} else {
						model.addAttribute("delete", 1);
					}
					return "gameList.error";
				} else {
					errors.put("action", "Unknown Action:" + prodaction);
					return "gameList.error";
				}
			}

}
