package com.secuve.seminar.service;

import java.util.ArrayList;

import com.secuve.seminar.dto.User;
import com.secuve.seminar.dto.UserInfo;

public interface UserLoginService {

	////////////////////// ����� ����///////////////////////
	void insertUsers(User user);

	public ArrayList<User> userList();
	
	boolean getUserByLogin(String userName, String password);

	boolean getIsUserByUserName(String userName);

	boolean getUserByUserNameAndIsAdmin(String userName, String password, String isAdmin);
	
	public User getUserByUserName(String userName);

	public void userManagerDeleteById(long Id);

	public void userAccountModifybyUserName(User user); // ����� ���� ����

	public void userManagerIsAdminUpdateById(User user);// ���� ������Ʈ

	public long getIdbyUserName(String userName);

	//////////////////// ����� ����//////////////////////
	public void insertUsersInfo(UserInfo userInfo);

	public ArrayList<UserInfo> userInfoList();

	public UserInfo getUserInfoByInfoId(long infoId);// ����� ���� ȣ��

	public void userInfoManagerDeleteByInfoId(long infoId);// ����� ���� ����

	public void userInfoAccountModifybyUserName(UserInfo userInfo);// ����� ���� ����
	
	
}
