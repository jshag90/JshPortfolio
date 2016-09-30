package com.spring.seminar.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.seminar.dto.Board;
import com.spring.seminar.mapper.UserBoardMapper;

@Service("userBoardService")
public class UserBoardServiceImpl implements UserBoardService {

	@Autowired
	UserBoardMapper userBoardMapper;

	@Override
	public void userBoardWrite(Board board) {
		userBoardMapper.userBoardWrite(board);

	}

	@Override
	public ArrayList<Board> userBoardList() {
		ArrayList<Board> boardResult = new ArrayList<Board>();

		boardResult = userBoardMapper.userBoardList();

		return boardResult;
	}

	@Override
	public Board userBoardViewbybId(long bId) {

		Board board = new Board();
		board = userBoardMapper.userBoardViewbybId(bId);
		return board;
	}

	@Override
	public void userBoardModifybyBId(Board board) {

		userBoardMapper.userBoardModifybyBId(board);
	}

	@Override
	public void userBoardDeletebyBId(long bId) {
		userBoardMapper.userBoardDelete(bId);

	}

	@Override
	public void userBoardHitCount(long bId) {

		userBoardMapper.userBoardHitCount(bId);
		
	}

}
