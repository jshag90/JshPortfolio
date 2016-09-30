package com.spring.seminar.mapper;

import java.util.ArrayList;

import com.spring.seminar.dto.User;
import com.spring.seminar.dto.UserInfo;

public interface UsersMapper {

	/////////////////////////사용자 관리////////////////////
	public void insertUsers(User user);
	
	public ArrayList<User> userList();
	
	public User getUserByUserName(String userName);
	
	public void userManagerDeleteById(long Id);

	public void userAccountModifybyUserName(User user);	//사용자 계정 수정
	
	public void userManagerIsAdminUpdateById(User user);//권한 업데이트
	
	public long getIdbyUserName(String userName);
	
	///////////////////////사용자 정보 관리///////////////////
	

	public void insertUsersInfo(UserInfo userInfo);

	public ArrayList<UserInfo> userInfoList();
	
	public UserInfo getUserInfoByInfoId(long infoId);//사용자 정보 호출
	
	public void userInfoManagerDeleteByInfoId(long infoId);//사용자 정보 삭제
	
	public void userInfoAccountModifybyUserName(UserInfo userInfo);//사용자 정보 수정
	

}
