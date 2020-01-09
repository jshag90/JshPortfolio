package com.jsh.portfolio.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.jsh.portfolio.dto.Qna;
import com.jsh.portfolio.dto.User;
import com.jsh.portfolio.service.QnaBoardService;
import com.jsh.portfolio.service.UserLoginService;

@Controller
@SessionAttributes({ "user", "board", "log", "qna", "notice", "userInfo" })
public class QnaController {

	@Autowired(required = false)
	private UserLoginService userLoginService;

	@Autowired(required = false)
	private QnaBoardService qnaBoardService;

	@RequestMapping(value = "/adminqnaboard")
	public String adminqnaBoard(@ModelAttribute("user") User user, Model model) {

		return "adminqnaBoard";
	}

	@RequestMapping(value = "/userqnaboard")
	public String userQnaBoard(@ModelAttribute("user") User user, Model model) {

		if (userLoginService.getUserByUserNameAndIsAdmin(user.getUserName(), user.getPassword(), "y")) {
			model.addAttribute("userIsAdmin", "y");
		}
		ArrayList<Qna> qnaResult = qnaBoardService.qnaList();
		model.addAttribute("qnaList", qnaResult);

		return "qnaBoard";
	}

	@RequestMapping(value = "/qnaboardwrite")
	public String qnaBoardWrite() {

		return "qnaBoardWrite";
	}

	@RequestMapping(value = "/adminqnaboardanswerwrite")
	public String adminQnaBoardAnswer(@ModelAttribute("user") User user, Model model, @ModelAttribute("qna") Qna qna,
			@RequestParam("qnaId") long qnaId) {
		System.out.println("�̰� ana ���� " + qnaId);
		qna = qnaBoardService.qnaBoardViewbyQnaId(qnaId);
		model.addAttribute("qnaUser", qna.getqnaUserName());
		model.addAttribute("qnaQuestion", qna.getqnaQuestion());
		model.addAttribute("qnaAnswer", qna.getqnaAnswer());

		return "adminQnaBoardAnswerWrite";
	}

	@RequestMapping(value = "/adminqnaboardanswerwriteproc")
	public String adminQnaBoardAnswerWriteProc(@ModelAttribute("user") User user, @ModelAttribute("qna") Qna qna,
			@ModelAttribute("qnaAnswer") String qnaAnswer, Model model) {

		qna.setqnaAnswer(qnaAnswer);

		qnaBoardService.qnaBoardUpdatebyQnaId(qna);

		return "redirect:/userqnaboard";
	}

	@RequestMapping(value = "/qnaboardwriteproc")
	public String qnaBoardWriteProc(@ModelAttribute("user") User user, Model model, @ModelAttribute("qna") Qna qna,
			@RequestParam("qnaQuestion") String qnaQuestion) {

		long qnaId = 0;
	

		qna.setqnaId(qnaId++);
		qna.setqnaUserName(user.getUserName());
		qna.setqnaQuestion(qnaQuestion);
		qna.setqnaAnswer("not yet write answer");


		qnaBoardService.qnaBoardWrite(qna);

		return "redirect:/userqnaboard";
	}
	
	@RequestMapping(value="/qnaboraddeleteproc")
	public String qnaBoardDeleteProc(@ModelAttribute("user") User user,@ModelAttribute("qna") Qna qna, @RequestParam("qnaId") long qnaId){
		qnaBoardService.qnaBoradDeleteByQnaId(qnaId);
		
		return "redirect:/userqnaboard";
	}
}
