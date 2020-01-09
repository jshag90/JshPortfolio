package com.jsh.portfolio.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsh.portfolio.dto.User;
import com.jsh.portfolio.dto.UserInfo;
import com.jsh.portfolio.mapper.UsersMapper;

@Service("userLoginService")
public class UserLoginServiceImpl implements UserLoginService {

	@Autowired
	private UsersMapper usersMapper;

	@Override
	public void insertUsers(User user) {

		usersMapper.insertUsers(user);

	}

	@Override
	public boolean getIsUserByUserName(String userName) {
		User user = usersMapper.getUserByUserName(userName);
		if (user != null) {
			return true;
		}

		return false;
	}

	@Override
	public boolean getUserByLogin(String userName, String password) {

		User user = usersMapper.getUserByUserName(userName);

		if (user != null && user.getPassword().equals(password)) {
			return true;
		}
		return false;
	}

	@Override
	public boolean getUserByUserNameAndIsAdmin(String userName, String password, String isAdmin) {
		User user = usersMapper.getUserByUserName(userName);

		if (user != null && user.getPassword().equals(password) && user.getIsAdmin().equals(isAdmin)) {
			return true;
		}

		return false;
	}

	@Override
	public void insertUsersInfo(UserInfo userInfo) {
		// TODO Auto-generated method stub
		usersMapper.insertUsersInfo(userInfo);
	}

	@Override
	public ArrayList<UserInfo> userInfoList() {
		// TODO Auto-generated method stub
		ArrayList<UserInfo> userInfo = usersMapper.userInfoList();
		return userInfo;
	}

	@Override
	public UserInfo getUserInfoByInfoId(long infoId) {
		UserInfo userInfo = usersMapper.getUserInfoByInfoId(infoId);

		return userInfo;
	}

	@Override
	public void userInfoManagerDeleteByInfoId(long infoId) {
		usersMapper.userInfoManagerDeleteByInfoId(infoId);

	}

	@Override
	public void userInfoAccountModifybyUserName(UserInfo userInfo) {
		usersMapper.userInfoAccountModifybyUserName(userInfo);

	}

	@Override
	public ArrayList<User> userList() {
		ArrayList<User> userListResult = usersMapper.userList();
		return userListResult;
	}

	@Override
	public void userManagerDeleteById(long Id) {
		usersMapper.userManagerDeleteById(Id);
	}

	@Override
	public void userAccountModifybyUserName(User user) {
		usersMapper.userAccountModifybyUserName(user);

	}

	@Override
	public void userManagerIsAdminUpdateById(User user) {
		// TODO Auto-generated method stub
		usersMapper.userManagerIsAdminUpdateById(user);

	}

	@Override
	public long getIdbyUserName(String userName) {
		long id = usersMapper.getIdbyUserName(userName);
		return id;
	}

	@Override
	public User getUserByUserName(String userName) {
		User user = usersMapper.getUserByUserName(userName);
		return user;
	}

}
