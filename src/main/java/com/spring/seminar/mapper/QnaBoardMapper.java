package com.spring.seminar.mapper;

import java.util.ArrayList;

import com.spring.seminar.dto.Qna;

public interface QnaBoardMapper {
	////////////////////////// Q&A °Ô½ÃÆÇ////////////////////////

	public Qna qnaBoardViewbyQnaId(long qnaId);

	public void qnaBoardUpdatebyQnaId(Qna board);

	public ArrayList<Qna> qnaList();

	public void qnaBoardWrite(Qna qna);
	
	public void qnaBoradDeleteByQnaId(long qnaId);

}
