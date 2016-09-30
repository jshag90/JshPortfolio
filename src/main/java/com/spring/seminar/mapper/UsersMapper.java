package com.spring.seminar.mapper;

import java.util.ArrayList;

import com.spring.seminar.dto.User;
import com.spring.seminar.dto.UserInfo;

public interface UsersMapper {

	/////////////////////////����� ����////////////////////
	public void insertUsers(User user);
	
	public ArrayList<User> userList();
	
	public User getUserByUserName(String userName);
	
	public void userManagerDeleteById(long Id);

	public void userAccountModifybyUserName(User user);	//����� ���� ����
	
	public void userManagerIsAdminUpdateById(User user);//���� ������Ʈ
	
	public long getIdbyUserName(String userName);
	
	///////////////////////����� ���� ����///////////////////
	

	public void insertUsersInfo(UserInfo userInfo);

	public ArrayList<UserInfo> userInfoList();
	
	public UserInfo getUserInfoByInfoId(long infoId);//����� ���� ȣ��
	
	public void userInfoManagerDeleteByInfoId(long infoId);//����� ���� ����
	
	public void userInfoAccountModifybyUserName(UserInfo userInfo);//����� ���� ����
	

}
