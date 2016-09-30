package com.spring.seminar.service;

import java.util.ArrayList;

import com.spring.seminar.dto.User;
import com.spring.seminar.dto.UserInfo;

public interface UserManagerService {
	
	ArrayList<User> userList();
	
	public void userManagerDeletebyBId(long id);
	
	public void userManagerIsAdminUpdateById(User user);
	
	public ArrayList<UserInfo> userInfoList();
	
	public void userInfoManagerDeleteByInfoId(long infoId);//사용자 정보 삭제

}
