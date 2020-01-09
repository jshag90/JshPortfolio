package com.jsh.portfolio.mapper;

import java.util.ArrayList;

import com.jsh.portfolio.dto.Log;

public interface AdminLogMapper {
	
///////////////////// ���� �α�////////////////////////////
public void logInsert(Log log);

public ArrayList<Log> logList(); 

public ArrayList<Log> logListbyLogUserName(String LogUserName);

public ArrayList<Log> logListbyAccessIp(String accessIp);

public ArrayList<Log> logListbyDate(String logDate);

public ArrayList<Log> logListbyContent(String content);



}
