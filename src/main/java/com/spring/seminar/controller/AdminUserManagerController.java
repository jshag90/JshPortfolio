package com.spring.seminar.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.spring.seminar.dto.User;
import com.spring.seminar.dto.UserInfo;
import com.spring.seminar.service.UserManagerService;

@Controller
@SessionAttributes({ "user", "board", "log", "qna", "notice", "userInfo" })
public class AdminUserManagerController {

	@Autowired(required = false)
	private UserManagerService userManagerService;

	@RequestMapping(value = "/adminmanagerlist", method = RequestMethod.GET)
	public String list(@ModelAttribute("user") User user, Model model) {

		List<User> userList = userManagerService.userList();
		List<UserInfo> userInfoList = userManagerService.userInfoList();

		model.addAttribute("userList", userList);
		model.addAttribute("userInfoList", userInfoList);

		return "adminManagerList";

	}

	@RequestMapping(value = "/adminmanagerdelete", method = RequestMethod.GET)
	@Transactional(propagation=Propagation.REQUIRED)
	public String adminManagerDelete(@ModelAttribute("user") User user, @RequestParam("id") long id, Model model) {

		System.out.println("���޹��� id �� :" + id);

		userManagerService.userInfoManagerDeleteByInfoId(id);
		userManagerService.userManagerDeletebyBId(id);

		return "redirect:/adminmanagerlist";

	}

	@RequestMapping(value = "/adminmanagerisadmin", method = RequestMethod.GET)
	public String adminManagerIsAdmin(@ModelAttribute("user") User user, @RequestParam("id") long id,
			@RequestParam("isAdmin") String isAdmin, Model model) {
		System.out.println("adminManagerIsAdmin()");
		System.out.println("���޹��� id �� :" + id);
		System.out.println("���޹��� isAdmin" + isAdmin);
		user.setId(id);
		user.setIsAdmin(isAdmin);

		userManagerService.userManagerIsAdminUpdateById(user);

		return "redirect:/adminmanagerlist";

	}

}
