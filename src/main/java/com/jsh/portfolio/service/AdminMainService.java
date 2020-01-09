package com.jsh.portfolio.service;

import java.util.ArrayList;

import com.jsh.portfolio.dto.Board;
import com.jsh.portfolio.dto.Log;
import com.jsh.portfolio.dto.LogStatis;
import com.jsh.portfolio.dto.Qna;

public interface AdminMainService {

	ArrayList<Log> accessIdSearch();

	ArrayList<Board> latestBoard();

	ArrayList<Qna> latestQnaBoard();

	public int countUser();

	public int todayAccessUserCount();

	public ArrayList<LogStatis> accessLogStatis();
	
	public ArrayList<LogStatis> accessLogStatisbyLogUserName(String UserName);
	
	public void accessLogLogInHit(String UserName);

}
