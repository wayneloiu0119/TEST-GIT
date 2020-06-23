package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import model.bean.CalendarBean;
import model.service.CalendarService;

@Controller
public class DataController {
	@Autowired
	private CalendarService calendarService;

	@ResponseBody
	@RequestMapping(value = "/json", method = { RequestMethod.GET, RequestMethod.POST }, produces = "application/json")
	public List<CalendarBean> select(Model model) {
		return calendarService.select(null);
	}
}
