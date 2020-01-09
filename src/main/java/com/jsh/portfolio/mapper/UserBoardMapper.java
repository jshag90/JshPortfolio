package com.jsh.portfolio.mapper;

import java.util.ArrayList;

import com.jsh.portfolio.dto.Board;

public interface UserBoardMapper {
	/////////////////// ï¿½ï¿½ï¿½ï¿½ï¿? ï¿½Ô½ï¿½ï¿½ï¿½ ////////////////////////
	public void userBoardWrite(Board board);

	public ArrayList<Board> userBoardList(String pageNo);
	
	public ArrayList<Board> userBoardListPaging(int offset, int noOfRecords);
	
	public int userBoardListCount();
	
	public Board userBoardViewbybId(long bId);

	public void userBoardModifybyBId(Board board);

	public void userBoardDelete(long bId);

	public void userBoardHitCount(long bId);


}
