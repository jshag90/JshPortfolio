package com.jsh.portfolio.mapper;

import java.util.ArrayList;

import com.jsh.portfolio.dto.Qna;

public interface QnaBoardMapper {
	////////////////////////// Q&A �Խ���////////////////////////

	public Qna qnaBoardViewbyQnaId(long qnaId);

	public void qnaBoardUpdatebyQnaId(Qna board);

	public ArrayList<Qna> qnaList();

	public void qnaBoardWrite(Qna qna);
	
	public void qnaBoradDeleteByQnaId(long qnaId);

}
