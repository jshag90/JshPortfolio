package com.secuve.seminar.service;

import java.util.ArrayList;

import com.secuve.seminar.dto.Board;

public interface UserBoardService {

	public void userBoardWrite(Board board);
	ArrayList<Board> userBoardList();
	
	public Board userBoardViewbybId(long bId);
	
	public void userBoardModifybyBId(Board board);
	
	public void userBoardDeletebyBId(long bId);
	
	public void userBoardHitCount(long bId);
	
	
}
