package com.secuve.seminar;

import java.util.Locale;

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

import com.secuve.seminar.dto.Board;
import com.secuve.seminar.dto.Log;
import com.secuve.seminar.dto.Notice;
import com.secuve.seminar.dto.Qna;
import com.secuve.seminar.dto.User;
import com.secuve.seminar.dto.UserInfo;
import com.secuve.seminar.mapper.UsersMapper;
import com.secuve.seminar.service.UserLoginService;

@Controller
@SessionAttributes({ "user", "board", "log", "qna", "notice", "userInfo" })
public class UserLoginServiceController {

	@Autowired(required = false)
	private UserLoginService userLoginService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {//세션을 위한 객체 초기화

		model.addAttribute("user", new User());
		model.addAttribute("board", new Board());
		model.addAttribute("log", new Log());
		model.addAttribute("qna", new Qna());
		model.addAttribute("notice", new Notice());
		model.addAttribute("userInfo", new UserInfo());

		return "home";
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
			//userInfo.setTel(null); //트랙잭션 Test
			
			userLoginService.insertUsers(user);
			userLoginService.insertUsersInfo(userInfo);

			return "home";

		}
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String loginProcess(@ModelAttribute("user") User user, @RequestParam("userName") String userName,
			@RequestParam("password") String password, Model model) {
		System.out.println("userName:" + userName);
		System.out.println("password:" + password);

		if (userLoginService.getUserByLogin(userName, password)) {

			if (userLoginService.getUserByUserNameAndIsAdmin(userName, password, "y")) {
				return "index";
			}
			return "userIndex";

		} else {

			model.addAttribute("message", "no register information! please check your Account or sign up.");
			System.out.println("등록된 ID가 없음");

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

		user = userLoginService.getUserByUserName(user.getUserName());// 세션에서 받은 UserName을 통하여 해당 user객체를 Return

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
		
		user = userLoginService.getUserByUserName(user.getUserName());//user테이블에서 해당 UserName의 id값 받기
		userInfo.setInfoId(user.getId());
		userInfo.setEmail(userInfo.getEmail());
		userInfo.setTel(userInfo.getTel());
		
		userLoginService.userInfoAccountModifybyUserName(userInfo);

		return "redirect:/usercontent";
	}

}
