package com.secuve.seminar;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.secuve.seminar.dto.Notice;
import com.secuve.seminar.dto.User;
import com.secuve.seminar.service.NoticeBoardService;
import com.secuve.seminar.service.UserLoginService;

@Controller
@SessionAttributes({ "user", "board", "log", "qna", "notice", "userInfo" })
public class NoticeBoardController {

	@Autowired(required = false)
	NoticeBoardService noticeBoardService;

	@Autowired(required = false)
	UserLoginService userLoginService;

	@RequestMapping(value = "/noticeboardlist")
	public String noticeBoardList(@ModelAttribute("user") User user, 
			
			Model model) {
		ArrayList<Notice> noticeList = noticeBoardService.noticeBoardList();
		model.addAttribute("noticeList", noticeList);
		if (userLoginService.getUserByUserNameAndIsAdmin(user.getUserName(), user.getPassword(), "y")) {
			model.addAttribute("userIsAdmin", "y");
		}

		return "noticeBoard";

	}

	@RequestMapping(value = "/noticeboardwrite")
	public String noticBoardWrite(@ModelAttribute("user") User user, Model model) {

		return "noticeBoardWrite";
	}

	@RequestMapping(value = "/noticeboardwriteproc")
	public String noticeBoardWriteProc(@ModelAttribute("user") User user, @ModelAttribute("notice") Notice notice,
			@RequestParam("noticeTitle") String noticeTitle, @RequestParam("noticeContent") String noticeContent,
			Model model) {

		long noticeId = 0;
		
		notice.setNoticeId(noticeId++);
		notice.setNoticeTitle(noticeTitle);
		notice.setNoticeContent(noticeContent);
		System.out.println(user.getUserName());
		notice.setNoticeUserName(user.getUserName());

		noticeBoardService.noticeBoardWrite(notice);

		return "redirect:/noticeboardlist";
	}

	@RequestMapping("/noticeboarddeleteproc")
	public String noticeBoardDeleteProcess(@ModelAttribute("user") User user, @RequestParam("noticeId") long noticeId) {

		noticeBoardService.noticeBoardDelete(noticeId);

		return "redirect:/noticeboardlist";
	}

	@RequestMapping("/noticeboardmodify")
	public String noticeBoardModify(@ModelAttribute("notice") Notice notice, @RequestParam("noticeId") long noticeId,
			Model model) {
		notice = noticeBoardService.noticeBoardViewbyNoticeId(noticeId);
		model.addAttribute("notice", notice);

		return "noticeBoardModify";
	}

	@RequestMapping("/noticeboardmodifyproc")
	public String noticeBoardModifyProc(@ModelAttribute("notice") Notice notice,
			@RequestParam("noticeTitle") String noticeTitle,@RequestParam("noticeContent") String noticeContent) {
	
		notice.setNoticeTitle(noticeTitle);
		notice.setNoticeContent(noticeContent);
		System.out.println("noticeContent::::"+noticeContent);
		
		noticeBoardService.noticeBoardModifybyNoticeId(notice);

		return "redirect:/noticeboardlist";
	}

}
