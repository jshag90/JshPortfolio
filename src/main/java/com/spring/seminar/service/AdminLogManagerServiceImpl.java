package com.spring.seminar.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.seminar.dto.Log;
import com.spring.seminar.mapper.AdminLogMapper;

@Service("AdminLogManagerService")
public class AdminLogManagerServiceImpl implements AdminLogManagerService {

	@Autowired
	AdminLogMapper adminLogMapper;

	@Override
	public void logInsert(Log log) {
		adminLogMapper.logInsert(log);
	}

	@Override
	public ArrayList<Log> adminLogList() {

		ArrayList<Log> logResult = new ArrayList<Log>();

		logResult = adminLogMapper.logList();

		return logResult;
	}

	@Override
	public ArrayList<Log> logListbyLogUserName(String LogUserName) {
		ArrayList<Log> logListbyLogUserName = adminLogMapper.logListbyLogUserName(LogUserName);

		return logListbyLogUserName;
	}

	@Override
	public ArrayList<Log> logListbyAccessIp(String accessIp) {
		ArrayList<Log> logListbyAccessIp = adminLogMapper.logListbyAccessIp(accessIp); 
		return logListbyAccessIp;
	}

	@Override
	public ArrayList<Log> logListbyDate(String logDate) {
		ArrayList<Log> logListbylogDate = adminLogMapper.logListbyDate(logDate);
		return logListbylogDate;
	}

	@Override
	public ArrayList<Log> logListbyContent(String content) {
		ArrayList<Log> logListbyContent = adminLogMapper.logListbyContent(content);
		return logListbyContent;
	}



}
