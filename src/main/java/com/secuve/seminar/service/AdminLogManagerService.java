package com.secuve.seminar.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.secuve.seminar.dto.Log;

public interface AdminLogManagerService {
	
	public void logInsert(Log log) throws SQLException;

	ArrayList<Log> adminLogList();
	
	public ArrayList<Log> logListbyLogUserName(String LogUserName);
	
	public ArrayList<Log> logListbyAccessIp(String accessIp);

	public ArrayList<Log> logListbyDate(String logDate);

	public ArrayList<Log> logListbyContent(String content);
}
