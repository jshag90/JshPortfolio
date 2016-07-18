package com.secuve.seminar;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.secuve.seminar.dto.User;

@Controller
public class HomeController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate);

		return "home";
	}

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String index(Locale locale, Model model) {

		return "index";
	}

	@RequestMapping(value = "/menu", method = RequestMethod.GET)
	public String menu(Locale locale, Model model) {

		return "menu";
	}

	@RequestMapping(value = "/content", method = RequestMethod.GET)
	public String content(Locale locale, Model model) {

		return "content";
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String List(Model model) {

		AbstractApplicationContext ctx = new GenericXmlApplicationContext("classpath*:data-context.xml");

		List<Object> userList = new ArrayList<Object>();
		User user01 = (User) ctx.getBean("userInfo01");
		User user02 = (User) ctx.getBean("userInfo02");
		userList.add(user01);
		userList.add(user02);

		model.addAttribute("userList", userList);

		return "list";
	}

}
