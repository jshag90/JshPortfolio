package com.spring.seminar.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.seminar.dto.Board;
import com.spring.seminar.dto.Log;
import com.spring.seminar.dto.LogStatis;
import com.spring.seminar.dto.Qna;
import com.spring.seminar.mapper.AdminMainMapper;

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
