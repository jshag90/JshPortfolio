package com.secuve.seminar.service;

import java.util.ArrayList;

import com.secuve.seminar.dto.Board;
import com.secuve.seminar.dto.Log;
import com.secuve.seminar.dto.LogStatis;
import com.secuve.seminar.dto.Qna;

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
