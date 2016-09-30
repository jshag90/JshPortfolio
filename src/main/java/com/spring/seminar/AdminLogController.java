package com.spring.seminar;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.spring.seminar.dto.Log;
import com.spring.seminar.dto.User;
import com.spring.seminar.service.AdminLogManagerService;

@Controller
@SessionAttributes({ "user", "board", "log", "qna", "notice", "userInfo" })
public class AdminLogController {

	@Autowired(required = false)
	private AdminLogManagerService AdminLogManagerService;

	@RequestMapping("/adminlogmanager")
	public String adminLogManager(@ModelAttribute("user") User user, @ModelAttribute("log") Log log, Model model) {
		List<Log> logList = AdminLogManagerService.adminLogList();
		model.addAttribute("logList", logList);

		return "adminLogManager";
	}

	@RequestMapping(value = "/adminloglistbylogusername",  method = RequestMethod.POST)
	public String adminLogListSearch(@RequestParam("columName") String columName,
			@RequestParam("searchWord") String searchWord, Model model) {
		

		System.out.println("searchWord:"+searchWord);
		ArrayList<Log> logList = new ArrayList<Log>();
		if (columName.contains("userName")) {
			logList = AdminLogManagerService.logListbyLogUserName(searchWord);
		} else if (columName.contains("accessIp")) {
			logList = AdminLogManagerService.logListbyAccessIp(searchWord);
		} else if (columName.contains("date")) {
			logList = AdminLogManagerService.logListbyDate(searchWord);
		} else if (columName.contains("content")) {
			logList = AdminLogManagerService.logListbyContent(searchWord);
		}

		model.addAttribute("logList", logList);

		return "adminLogManager";
	}

}
