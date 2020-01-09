package com.jsh.portfolio.mapper;

import java.util.ArrayList;

import com.jsh.portfolio.dto.Board;
import com.jsh.portfolio.dto.Log;
import com.jsh.portfolio.dto.LogStatis;
import com.jsh.portfolio.dto.Qna;

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
