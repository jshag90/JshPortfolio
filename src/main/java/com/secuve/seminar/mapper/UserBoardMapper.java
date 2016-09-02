package com.secuve.seminar.mapper;

import java.util.ArrayList;

import com.secuve.seminar.dto.Board;

public interface UserBoardMapper {
	/////////////////// 사용자 게시판 ////////////////////////
	public void userBoardWrite(Board board);

	public ArrayList<Board> userBoardList();

	public Board userBoardViewbybId(long bId);

	public void userBoardModifybyBId(Board board);

	public void userBoardDelete(long bId);

	public void userBoardHitCount(long bId);

}
