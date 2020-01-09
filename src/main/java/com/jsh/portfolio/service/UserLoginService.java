package com.jsh.portfolio.service;

import java.util.ArrayList;

import com.jsh.portfolio.dto.User;
import com.jsh.portfolio.dto.UserInfo;

public interface UserLoginService {

	////////////////////// ï¿½ï¿½ï¿½ï¿½ï¿? ï¿½ï¿½ï¿½ï¿½///////////////////////
	void insertUsers(User user);

	public ArrayList<User> userList();
	
	boolean getUserByLogin(String userName, String password);

	boolean getIsUserByUserName(String userName);

	boolean getUserByUserNameAndIsAdmin(String userName, String password, String isAdmin);
	
	public User getUserByUserName(String userName);

	public void userManagerDeleteById(long Id);

	public void userAccountModifybyUserName(User user); // ï¿½ï¿½ï¿½ï¿½ï¿? ï¿½ï¿½ï¿½ï¿½ ï¿½ï¿½ï¿½ï¿½

	public void userManagerIsAdminUpdateById(User user);// ï¿½ï¿½ï¿½ï¿½ ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½Æ®

	public long getIdbyUserName(String userName);

	//////////////////// ï¿½ï¿½ï¿½ï¿½ï¿? ï¿½ï¿½ï¿½ï¿½//////////////////////
	public void insertUsersInfo(UserInfo userInfo);

	public ArrayList<UserInfo> userInfoList();

	public UserInfo getUserInfoByInfoId(long infoId);// ï¿½ï¿½ï¿½ï¿½ï¿? ï¿½ï¿½ï¿½ï¿½ È£ï¿½ï¿½

	public void userInfoManagerDeleteByInfoId(long infoId);// ï¿½ï¿½ï¿½ï¿½ï¿? ï¿½ï¿½ï¿½ï¿½ ï¿½ï¿½ï¿½ï¿½

	public void userInfoAccountModifybyUserName(UserInfo userInfo);// ï¿½ï¿½ï¿½ï¿½ï¿? ï¿½ï¿½ï¿½ï¿½ ï¿½ï¿½ï¿½ï¿½
	
	
}
