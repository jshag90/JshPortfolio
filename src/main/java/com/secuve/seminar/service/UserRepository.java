package com.secuve.seminar.service;

import java.util.ArrayList;
import java.util.List;

import com.secuve.seminar.dto.User;

public class UserRepository {

	private List<User> userList = new ArrayList<User>();

	
	public void setUserList(List<User> userList) {
		this.userList = userList;
	}
	
	public void findUserByid(String id) {
		for(int i=0; i<userList.size();i++){
		if(userList.get(i).getId().equals(id)){
			System.out.println(id+"의 비밀번호"+userList.get(i).getPassword());
		}
		}
		
	}




}
