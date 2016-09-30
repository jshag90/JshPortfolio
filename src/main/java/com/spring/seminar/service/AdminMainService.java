package com.spring.seminar.service;

import java.util.ArrayList;

import com.spring.seminar.dto.Board;
import com.spring.seminar.dto.Log;
import com.spring.seminar.dto.LogStatis;
import com.spring.seminar.dto.Qna;

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
