package com.jsh.portfolio.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsh.portfolio.dto.Board;
import com.jsh.portfolio.dto.Log;
import com.jsh.portfolio.dto.LogStatis;
import com.jsh.portfolio.dto.Qna;
import com.jsh.portfolio.mapper.AdminMainMapper;

@Service("adminMainService")
public class AdminMainServiceImpl implements AdminMainService {

	@Autowired
	AdminMainMapper adminMainMapper;

	@Override
	public ArrayList<Log> accessIdSearch() {
		ArrayList<Log> accessIdResult = adminMainMapper.accessIdSearch();
		return accessIdResult;
	}

	@Override
	public ArrayList<Board> latestBoard() {
		ArrayList<Board> latestBoardResult = adminMainMapper.latestBoard();
		return latestBoardResult;
	}

	@Override
	public ArrayList<Qna> latestQnaBoard() {
		ArrayList<Qna> latestQnaBoardResult = adminMainMapper.latestQnaBoard();
		return latestQnaBoardResult;
	}

	@Override
	public int countUser() {
		int usersCount = adminMainMapper.countUser();
		return usersCount;
	}

	@Override
	public int todayAccessUserCount() {
		int todayAccessUserCount = adminMainMapper.todayAccessUserCount();
		return todayAccessUserCount;
	}

	@Override
	public ArrayList<LogStatis> accessLogStatis() {
		ArrayList<LogStatis> logStatisList = adminMainMapper.accessLogStatis();
		return logStatisList;
	}

	@Override
	public ArrayList<LogStatis> accessLogStatisbyLogUserName(String UserName) {
		ArrayList<LogStatis> logStatisListbyLogUserName = adminMainMapper.accessLogStatisbyLogUserName(UserName);
		return logStatisListbyLogUserName;
	}

	@Override
	public void accessLogLogInHit(String UserName) {

		adminMainMapper.accessLogLogInHit(UserName);

	}

}
