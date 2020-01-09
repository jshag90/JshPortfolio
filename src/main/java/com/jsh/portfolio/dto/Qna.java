package com.jsh.portfolio.dto;

import java.util.Date;

public class Qna {

	private long qnaId;
	private String qnaUserName;
	private String qnaQuestion;
	private String qnaAnswer;
	private Date qnaRegDate;

	public long getqnaId() {
		return qnaId;
	}

	public void setqnaId(long qnaId) {
		this.qnaId = qnaId;
	}

	public String getqnaUserName() {
		return qnaUserName;
	}

	public void setqnaUserName(String qnaUserName) {
		this.qnaUserName = qnaUserName;
	}

	public String getqnaQuestion() {
		return qnaQuestion;
	}

	public void setqnaQuestion(String qnaQuestion) {
		this.qnaQuestion = qnaQuestion;
	}

	public String getqnaAnswer() {
		return qnaAnswer;
	}

	public void setqnaAnswer(String qnaAnswer) {
		this.qnaAnswer = qnaAnswer;
	}

	public Date getqnaRegDate() {
		return qnaRegDate;
	}

	public void setqnaRegDate(Date qnaRegDate) {
		this.qnaRegDate = qnaRegDate;
	}

}
