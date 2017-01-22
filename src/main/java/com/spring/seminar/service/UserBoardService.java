package com.spring.seminar.service;

import com.spring.paging.ListVO;
import com.spring.seminar.dto.Board;

public interface UserBoardService {

	public void userBoardWrite(Board board);

	ListVO userBoardList(String pageNo);

	public Board userBoardViewbybId(long bId);

	public void userBoardModifybyBId(Board board);

	public void userBoardDeletebyBId(long bId);

	public void userBoardHitCount(long bId);

}
