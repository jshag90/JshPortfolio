package com.jsh.portfolio.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsh.paging.CommonConstants;
import com.jsh.paging.ListVO;
import com.jsh.paging.PagingBean;
import com.jsh.portfolio.dto.Board;
import com.jsh.portfolio.mapper.UserBoardMapper;

@Service("userBoardService")
public class UserBoardServiceImpl implements UserBoardService {

	@Autowired
	UserBoardMapper userBoardMapper;

	@Override
	public ListVO userBoardList(String pageNo) {
		if (pageNo == null | pageNo == "")
			pageNo = "1";

		ArrayList<Board> boardResult = new ArrayList<Board>();
		Integer offSet = (Integer.parseInt(pageNo) - 1) * CommonConstants.CONTENT_NUMBER_PER_PAGE;
		
		boardResult = userBoardMapper.userBoardList(offSet.toString());
		int total = userBoardMapper.userBoardListCount();
		PagingBean paging = new PagingBean(total, Integer.parseInt(pageNo));
		ListVO listVo = new ListVO(boardResult, paging);

		return listVo;
	}

	@Override
	public void userBoardWrite(Board board) {
		userBoardMapper.userBoardWrite(board);

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
