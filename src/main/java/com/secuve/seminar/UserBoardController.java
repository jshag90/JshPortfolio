package com.secuve.seminar;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.secuve.seminar.dto.Board;
import com.secuve.seminar.dto.User;
import com.secuve.seminar.service.UserBoardService;

@Controller
@SessionAttributes({ "user", "board", "log", "qna", "notice", "userInfo" })
public class UserBoardController {

	@Autowired(required = false)
	private UserBoardService userBoardService;

	@RequestMapping(value = "/usercontent", method = RequestMethod.GET)
	public String userContent(@ModelAttribute("user") User user, @ModelAttribute("board") Board board, Model model) {
		List<Board> boardList = userBoardService.userBoardList();
		model.addAttribute("userBoardList", boardList);

		return "userContent";
	}

	@RequestMapping("/userboardwrite")
	public String userBoardWrite(@ModelAttribute("user") User user, @ModelAttribute("board") Board board) {
		System.out.println("userBoardWrite()");
		return "userBoardWrite";
	}

	@RequestMapping(value = "/boardwritepro", method = RequestMethod.POST)
	public String userBoardWriteProcess(@ModelAttribute("user") User user, @ModelAttribute("board") Board board) {

		System.out.println("userboardwriteprocess()");

		int hit = 0;
		int bId = 0;

		board.setbId(bId++);
		board.setbUserName(user.getUserName());
		board.setbTitle(board.getbTitle());
		board.setbContent(board.getbContent());
		board.setbHit(hit++);

		Date regDate = new Date(System.currentTimeMillis());
		board.setbRegDate((java.sql.Date) regDate);

		userBoardService.userBoardWrite(board);

		return "redirect:/usercontent";
	}

	@RequestMapping("/userobardview")
	public String userBoardView(@ModelAttribute("user") User user, @ModelAttribute("board") Board board,
			@RequestParam("bId") long bId, Model model) {

		board = userBoardService.userBoardViewbybId(bId);
		model.addAttribute("boardbybId", board);
		userBoardService.userBoardHitCount(bId);
		return "userBoardView";
	}

	@RequestMapping("/userobardmodify")
	public String userBoardModify(@ModelAttribute("user") User user, @ModelAttribute("board") Board board,
			@RequestParam("bId") long bId, Model model) {
		board = userBoardService.userBoardViewbybId(bId);
		model.addAttribute("boardbybId", board);
		return "userBoardModify";
	}

	@RequestMapping("/userboardmodifyProc")
	public String userBoardModifyProcess(@ModelAttribute("user") User user, @ModelAttribute("board") Board board,
			@RequestParam("bTitle") String bTitle, @RequestParam("bContent") String bContent,
			@RequestParam("bId") long bId) {

		board.setbId(bId);
		board.setbTitle(bTitle);
		board.setbContent(bContent);

		userBoardService.userBoardModifybyBId(board);

		return "redirect:/usercontent";
	}

	@RequestMapping("/userboardDeleteProc")
	public String userBoardDeleteProcess(@ModelAttribute("user") User user, @RequestParam("bId") long bId) {

		userBoardService.userBoardDeletebyBId(bId);

		return "redirect:/usercontent";
	}

}
