package com.spring.seminar.service;

import java.util.ArrayList;

import com.spring.seminar.dto.Qna;

public interface QnaBoardService {

	public ArrayList<Qna> qnaList();

	public void qnaBoardWrite(Qna qna);

	public Qna qnaBoardViewbyQnaId(long qnaId);

	public void qnaBoardUpdatebyQnaId(Qna board);

	public void qnaBoradDeleteByQnaId(long qnaId);

}
