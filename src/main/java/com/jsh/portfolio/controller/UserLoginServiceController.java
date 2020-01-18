package com.jsh.portfolio.controller;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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

import com.jsh.paging.ListVO;
import com.jsh.portfolio.dto.Board;
import com.jsh.portfolio.dto.Log;
import com.jsh.portfolio.dto.Notice;
import com.jsh.portfolio.dto.Qna;
import com.jsh.portfolio.dto.User;
import com.jsh.portfolio.dto.UserInfo;
import com.jsh.portfolio.service.UserBoardService;
import com.jsh.portfolio.service.UserLoginService;

@Controller
@SessionAttributes({ "user", "board", "log", "qna", "notice", "userInfo" })
public class UserLoginServiceController {

	@Autowired(required = false)
	private UserLoginService userLoginService;
	
	@Autowired(required = false)
	private UserBoardService userBoardService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(HttpServletRequest httpServletRequest, Model model) {//?��?��?�� ?��?�� 객체 초기?��

		model.addAttribute("user", new User());
		model.addAttribute("board", new Board());
		model.addAttribute("log", new Log());
		model.addAttribute("qna", new Qna());
		model.addAttribute("notice", new Notice());
		model.addAttribute("userInfo", new UserInfo());

		return "/bootstrap/index";
	}

	@RequestMapping(value = "/join", method = RequestMethod.POST)
	@Transactional(propagation=Propagation.REQUIRED)
	public String join(@ModelAttribute("user") User user, @ModelAttribute("userInfo") UserInfo userInfo, Model model) {
		System.out.println("join()");
		long id = 0;

		if (userLoginService.getIsUserByUserName(user.getUserName())) {
			model.addAttribute("message", "Join Fail!!!, please check your id");
			return "home";
		} else {
			model.addAttribute("message", "Join success");

			user.setId(id++);
			user.setUserName(user.getUserName());
			user.setPassword(user.getPassword());
			
			userInfo.setEmail(userInfo.getEmail());
			userInfo.setTel(userInfo.getTel());
			//userInfo.setTel(null); //?��?��?��?�� Test
			
			userLoginService.insertUsers(user);
			userLoginService.insertUsersInfo(userInfo);

			return "home";

		}
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String loginProcess(HttpServletRequest httpServletRequest, @ModelAttribute("user") User user, @RequestParam("userName") String userName,
			@RequestParam("password") String password, Model model) {
		System.out.println("userName:" + userName);
		System.out.println("password:" + password);

		if (userLoginService.getUserByLogin(userName, password)) {
			ListVO listVo = userBoardService.userBoardList("1");
			model.addAttribute("userBoardList", listVo);
			
			if (userLoginService.getUserByUserNameAndIsAdmin(userName, password, "y")) {
				return "index";
			}
			return "userContent";

		} else {

			model.addAttribute("message", "no register information! please check your Account or sign up.");
			System.out.println("?��록된 ID�?? ?��?��");

			return "home";
		}

	}

	@RequestMapping(value = "/menu", method = RequestMethod.GET)
	public String adminMenu(@ModelAttribute("user") User user, Locale locale, Model model) {

		return "menu";
	}

	@RequestMapping("/logout")
	public String logOut(@ModelAttribute("user") User user, HttpSession session) {

		System.out.println("logOut");
		session.invalidate();

		return "home";
	}

	@RequestMapping(value = "/usermenu", method = RequestMethod.GET)
	public String userMenu(@ModelAttribute("user") User user, Locale locale, Model model) {

		return "userMenu";
	}

	@RequestMapping("/useraccountmodify")
	public String userAccountModify(@ModelAttribute("user") User user, Model model,
			@ModelAttribute("userInfo") UserInfo userInfo) {

		user = userLoginService.getUserByUserName(user.getUserName());// ?��?��?��?�� 받�? UserName?�� ?��?��?�� ?��?�� user객체�?? Return

		long userInfoId = userLoginService.getIdbyUserName(user.getUserName());
		userInfo = userLoginService.getUserInfoByInfoId(userInfoId);
		

		model.addAttribute("userbyUserName", user);
		model.addAttribute("userInfobyInfoId", userInfo);

		return "userAccountModify";
	}

	@RequestMapping(value = "/useraccountmodifyProc", method = RequestMethod.POST)
	public String userAccountModityProc(@ModelAttribute("user") User user,
			@ModelAttribute("userInfo") UserInfo userInfo,@RequestParam("password")String password) {
		
		user.setPassword(password);
		userLoginService.userAccountModifybyUserName(user);
		
		user = userLoginService.getUserByUserName(user.getUserName());//user?��?��블에?�� ?��?�� UserName?�� id�?? 받기
		userInfo.setInfoId(user.getId());
		userInfo.setEmail(userInfo.getEmail());
		userInfo.setTel(userInfo.getTel());
		
		userLoginService.userInfoAccountModifybyUserName(userInfo);

		return "redirect:/usercontent";
	}

}
