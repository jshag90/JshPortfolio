package com.secuve.seminar.mapper;

import java.util.ArrayList;

import com.secuve.seminar.dto.Board;
import com.secuve.seminar.dto.Log;
import com.secuve.seminar.dto.LogStatis;
import com.secuve.seminar.dto.Qna;

public interface AdminMainMapper {

	public ArrayList<Log> accessIdSearch();

	public ArrayList<Board> latestBoard();

	public ArrayList<Qna> latestQnaBoard();

	public int countUser();

	public int todayAccessUserCount();

	public ArrayList<LogStatis> accessLogStatis();
	
	//해당 UserName이 매시간마다 로그인한 값을 List에 저장
	public ArrayList<LogStatis> accessLogStatisbyLogUserName(String UserName);
	
	public void accessLogLogInHit(String UserName);
	
	

}
