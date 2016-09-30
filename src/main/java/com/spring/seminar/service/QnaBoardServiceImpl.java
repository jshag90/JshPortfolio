package com.spring.seminar.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.seminar.dto.Qna;
import com.spring.seminar.mapper.QnaBoardMapper;

@Service("qnaBoardService")
public class QnaBoardServiceImpl implements QnaBoardService {

	@Autowired
	QnaBoardMapper qnaBoardMapper;

	@Override
	public ArrayList<Qna> qnaList() {
		ArrayList<Qna> faqResult = qnaBoardMapper.qnaList();

		return faqResult;
	}

	@Override
	public void qnaBoardWrite(Qna qna) {

		qnaBoardMapper.qnaBoardWrite(qna);

	}

	@Override
	public Qna qnaBoardViewbyQnaId(long qnaId) {
		Qna qna = qnaBoardMapper.qnaBoardViewbyQnaId(qnaId);
		return qna;
	}

	@Override
	public void qnaBoardUpdatebyQnaId(Qna board) {

		qnaBoardMapper.qnaBoardUpdatebyQnaId(board);
	}

	@Override
	public void qnaBoradDeleteByQnaId(long qnaId) {
		qnaBoardMapper.qnaBoradDeleteByQnaId(qnaId);

	}

}
