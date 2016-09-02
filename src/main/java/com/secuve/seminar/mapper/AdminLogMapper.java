package com.secuve.seminar.mapper;

import java.util.ArrayList;

import com.secuve.seminar.dto.Log;

public interface AdminLogMapper {
	
///////////////////// 접근 로그////////////////////////////
public void logInsert(Log log);

public ArrayList<Log> logList(); 

public ArrayList<Log> logListbyLogUserName(String LogUserName);

public ArrayList<Log> logListbyAccessIp(String accessIp);

public ArrayList<Log> logListbyDate(String logDate);

public ArrayList<Log> logListbyContent(String content);



}
