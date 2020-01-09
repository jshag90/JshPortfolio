package com.jsh.portfolio.service;

import java.util.ArrayList;

import com.jsh.portfolio.dto.User;
import com.jsh.portfolio.dto.UserInfo;

public interface UserManagerService {
	
	ArrayList<User> userList();
	
	public void userManagerDeletebyBId(long id);
	
	public void userManagerIsAdminUpdateById(User user);
	
	public ArrayList<UserInfo> userInfoList();
	
	public void userInfoManagerDeleteByInfoId(long infoId);//ï¿½ï¿½ï¿½ï¿½ï¿? ï¿½ï¿½ï¿½ï¿½ ï¿½ï¿½ï¿½ï¿½

}
