package com.jsh.portfolio.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.jsh.portfolio.dto.Board;
import com.jsh.portfolio.dto.Log;
import com.jsh.portfolio.dto.LogStatis;
import com.jsh.portfolio.dto.Qna;
import com.jsh.portfolio.dto.User;
import com.jsh.portfolio.service.AdminMainService;

@Controller
@SessionAttributes({ "user", "board", "log", "qna", "notice", "userInfo" })
public class AdminMainController {

	@Autowired(required = false)
	AdminMainService adminMainService;

	@RequestMapping(value = "/content", method = RequestMethod.GET)
	public String adminContent( @ModelAttribute("qna") Qna qna, @ModelAttribute("user")  User user, Model model) {
		System.out.println("adminContent()");
		ArrayList<Log> accessIdList = adminMainService.accessIdSearch();
		model.addAttribute("accessIdList", accessIdList);

		ArrayList<Board> latestBoardList = adminMainService.latestBoard();
		model.addAttribute("latestBoardList", latestBoardList);

		ArrayList<Qna> latestQnaBoardList = adminMainService.latestQnaBoard();
		for(int i=0; i<latestQnaBoardList.size(); i++){
			System.out.println(latestBoardList.get(i));
		}
		model.addAttribute("latestQnaBoardList", latestQnaBoardList);
		

		int usersCount = adminMainService.countUser();
		model.addAttribute("usersCount", usersCount);

		int todayAccessUserCount = adminMainService.todayAccessUserCount();
		model.addAttribute("todayAccessUserCount", todayAccessUserCount);

		ArrayList<LogStatis> logStatisList = adminMainService.accessLogStatis();

		ArrayList<String> logStatisListHour = new ArrayList<String>();
		ArrayList<String> logStatisListAccessCount = new ArrayList<String>();
		
		for(int i=0; i<logStatisList.size();i++){
			logStatisListHour.add(logStatisList.get(i).getHour());
			logStatisListAccessCount.add(logStatisList.get(i).getAccessCount());
		}
		
		model.addAttribute("logStatisListHour", logStatisListHour);
		model.addAttribute("logStatisListAccessCount", logStatisListAccessCount);	

		return "content";
	}
	
	@RequestMapping(value = "/contentstatic", method = RequestMethod.GET)
	public String adminContent(@RequestParam("logUserName") String logUserName,Model model){
		ArrayList<Log> accessIdList = adminMainService.accessIdSearch();

		model.addAttribute("accessIdList", accessIdList);

		ArrayList<Board> latestBoardList = adminMainService.latestBoard();
		model.addAttribute("latestBoardList", latestBoardList);

		ArrayList<Qna> latestQnaBoardList = adminMainService.latestQnaBoard();
		model.addAttribute("latestQnaBoardList", latestQnaBoardList);

		int usersCount = adminMainService.countUser();
		model.addAttribute("usersCount", usersCount);

		int todayAccessUserCount = adminMainService.todayAccessUserCount();
		model.addAttribute("todayAccessUserCount", todayAccessUserCount);
		
		ArrayList<LogStatis> logStatisListByUserName = adminMainService.accessLogStatisbyLogUserName(logUserName);
		//UserName�� �Ķ���ͷ�? �Ѱ��ְ� �ش� UserName�� ���� Ƚ���� ���� �ð��� Return
		ArrayList<String> logStatisListHourByUserName = new ArrayList<String>();
		ArrayList<String> logStatisListAccessCountByUserName = new ArrayList<String>();
		
		for(int i=0; i< logStatisListByUserName.size(); i++){
			logStatisListHourByUserName.add(logStatisListByUserName.get(i).getHour());
			System.out.println(logStatisListByUserName.get(i).getAccessCount());
			logStatisListAccessCountByUserName.add(logStatisListByUserName.get(i).getAccessCount());
			System.out.println(logStatisListByUserName.get(i).getHour());
		
		}

		model.addAttribute("statisUserName", logUserName);
		model.addAttribute("logStatisListHourByUserName", logStatisListHourByUserName);
		model.addAttribute("logStatisListAccessCountByUserName", logStatisListAccessCountByUserName);
		
		
		return "/contentStatisbyId";
		
	}

}
