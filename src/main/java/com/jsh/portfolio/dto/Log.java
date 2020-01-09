package com.jsh.portfolio.dto;

import java.sql.Timestamp;

public class Log {

	private long LogId;
	private String LogUserName;
	private Timestamp LogRegDate;
	private String LogContent;
	private String IpAddress;
	private int LogInHit;

	public int getLogInHit() {
		return LogInHit;
	}

	public void setLogInHit(int logInHit) {
		LogInHit = logInHit;
	}

	public String getIpAddress() {
		return IpAddress;
	}

	public void setIpAddress(String ipAddress) {
		IpAddress = ipAddress;
	}

	public long getLogId() {
		return LogId;
	}

	public void setLogId(long logId) {
		LogId = logId;
	}

	public String getLogUserName() {
		return LogUserName;
	}

	public void setLogUserName(String logUserName) {
		LogUserName = logUserName;
	}

	/*
	 * public Date getLogRegDate() { return LogRegDate; }
	 * 
	 * public void setLogRegDate(Date logRegDate) { LogRegDate = logRegDate; }
	 */
	public String getLogContent() {
		return LogContent;
	}

	public Timestamp getLogRegDate() {
		return LogRegDate;
	}

	public void setLogRegDate(Timestamp logRegDate) {
		LogRegDate = logRegDate;
	}

	public void setLogContent(String logContent) {
		LogContent = logContent;
	}

}
