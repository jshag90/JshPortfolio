package com.secuve.seminar.dto;

import java.sql.Date;

public class Board {
	private long bId;
	private String bUserName;
	private String bTitle;
	private String bContent;
	private int bHit;
	private Date bRegDate;
	

	public Date getbRegDate() {
		return bRegDate;
	}

	public void setbRegDate(Date bRegDate) {
		this.bRegDate = bRegDate;
	}

	public int getbHit() {
		return bHit;
	}

	public void setbHit(int bHit) {
		this.bHit = bHit;
	}

	public long getbId() {
		return bId;
	}

	public void setbId(long bId) {
		this.bId = bId;
	}

	public String getbUserName() {
		return bUserName;
	}

	public void setbUserName(String bUserName) {
		this.bUserName = bUserName;
	}

	public String getbTitle() {
		return bTitle;
	}

	public void setbTitle(String bTitle) {
		this.bTitle = bTitle;
	}

	public String getbContent() {
		return bContent;
	}

	public void setbContent(String bContent) {
		this.bContent = bContent;
	}

}
