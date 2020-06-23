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

import model.bean.GameBean;
import model.service.GameService;
import model.spring.PrimitiveNumberEditor;

@Controller
//@RequestMapping({ "/Game/GameCRUD.controller" })
public class GameController {
	@Autowired
	private GameService gameService;

	@InitBinder
	public void initBinder(WebDataBinder webDataBinder) {
		webDataBinder.registerCustomEditor(int.class, "gameId", new PrimitiveNumberEditor(Integer.class, true));
		webDataBinder.registerCustomEditor(String.class, "gameDate",
				new CustomDateEditor(new SimpleDateFormat("yyyy/MM/dd"), true));
		webDataBinder.registerCustomEditor(String.class, "gameTime",
				new CustomDateEditor(new SimpleDateFormat("HH:mm"), true));
		webDataBinder.registerCustomEditor(int.class, "number", new PrimitiveNumberEditor(Integer.class, true));
		webDataBinder.registerCustomEditor(int.class, "numberMax", new PrimitiveNumberEditor(Integer.class, true));
		webDataBinder.registerCustomEditor(String.class, "deadLine",
				new CustomDateEditor(new SimpleDateFormat("yyyy/MM/dd"), true));
		webDataBinder.registerCustomEditor(int.class, "typeId", new PrimitiveNumberEditor(Integer.class, true));

	}

	@RequestMapping(value= {"/Game/GameCRUD.controller" },method = { RequestMethod.GET, RequestMethod.POST })
	public String method(GameBean gameBean, BindingResult bindingResult, Model model,
			@RequestParam("prodaction") String prodaction) {
		System.out.println("gameBean =" + gameBean);
		System.out.println("bindingResult =" + bindingResult);

		Map<String, String> errors = new HashMap<>();
		model.addAttribute("errors", errors);

		if (bindingResult != null && bindingResult.hasFieldErrors()) {
			if (bindingResult.getFieldError("gameId") != null) {
				errors.put("gameId", "GameId必須為整數(MVC)");
			}
			if (bindingResult.getFieldError("gameDate") != null) {
				errors.put("gameDate", "GameDate格式必須為yyyy/MM/dd(MVC)");
			}
			if (bindingResult.getFieldError("gameTime") != null) {
				errors.put("gameTime", "GameTime格式必須為HH:mm(MVC)");
			}
			if (bindingResult.getFieldError("number") != null) {
				errors.put("number", "number必須為整數(MVC)");
			}
			if (bindingResult.getFieldError("numberMax") != null) {
				errors.put("numberMax", "NumberMax格式必須為yyyy/MM/dd(MVC)");
			}
			if (bindingResult.getFieldError("deadLine") != null) {
				errors.put("deadLine", "deadLine格式必須為yyyy/MM/dd(MVC)");
			}
			if (bindingResult.getFieldError("typeId") != null) {
				errors.put("typeId", "typeId必須為整數(MVC)");
			}
		}
		if (errors != null && !errors.isEmpty()) {
			return "game.error";
		}

		if ("Update".equals(prodaction) || "Delete".equals(prodaction)) {
			if (gameBean.getGameId() == 0) {
				errors.put("gameId", "請輸入Id以便執行" + prodaction);
			}
		}

		if (errors != null && !errors.isEmpty()) {
			return "game.error";
		}

		if ("Select".equals(prodaction)) {
			List<GameBean> result = gameService.selectALLGame();
			model.addAttribute("showAllGame", result);
			return "gameManager.succe";
		} else if (prodaction != null && prodaction.equals("Insert")) {
			GameBean result = gameService.insertNewGame(gameBean);
			if (result == null) {
				errors.put("action", "Insert fail");
			} else {
				model.addAttribute("insert", result);
			}
			return "game.error";
		} else if (prodaction != null && prodaction.equals("Update")) {
			GameBean result = gameService.updateGameInfo(gameBean);
			if (result == null) {
				errors.put("action", "Update fail");
			} else {
				model.addAttribute("update", result);
			}
			return "game.error";
		} else if (prodaction != null && prodaction.equals("Delete")) {
			boolean result = gameService.deleteGame(gameBean.getGameId());
			if (!result) {
				model.addAttribute("delete", 0);
			} else {
				model.addAttribute("delete", 1);
			}
			return "game.error";
		} else {
			errors.put("action", "Unknown Action:" + prodaction);
			return "game.error";
		}

	}
	
	@RequestMapping(value= {"/SelectAllGame.controller"})
	public String method2( Model model) {
		List<GameBean> result = gameService.selectALLGame();
		model.addAttribute("showAllGame", result);
		return "game.succe";
	}
}
