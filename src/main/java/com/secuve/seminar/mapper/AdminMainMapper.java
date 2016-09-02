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
	
	//�ش� UserName�� �Žð����� �α����� ���� List�� ����
	public ArrayList<LogStatis> accessLogStatisbyLogUserName(String UserName);
	
	public void accessLogLogInHit(String UserName);
	
	

}
