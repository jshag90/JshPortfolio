package com.jsh.portfolio.dto;

import java.sql.Date;

public class Notice {

	private long NoticeId;
	private String NoticeUserName;
	private String NoticeTitle;
	private String NoticeContent;
	private Date NoticeRegDate;


	public long getNoticeId() {
		return NoticeId;
	}

	public void setNoticeId(long noticeId) {
		NoticeId = noticeId;
	}

	public String getNoticeUserName() {
		return NoticeUserName;
	}

	public void setNoticeUserName(String noticeUserName) {
		NoticeUserName = noticeUserName;
	}

	public String getNoticeTitle() {
		return NoticeTitle;
	}

	public void setNoticeTitle(String noticeTitle) {
		NoticeTitle = noticeTitle;
	}

	public String getNoticeContent() {
		return NoticeContent;
	}

	public void setNoticeContent(String noticeContent) {
		NoticeContent = noticeContent;
	}

	public Date getNoticeRegDate() {
		return NoticeRegDate;
	}

	public void setNoticeRegDate(Date noticeRegDate) {
		NoticeRegDate = noticeRegDate;
	}



}
