package com.spring.seminar.dto;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class User implements BeanNameAware, ApplicationContextAware {

	private long id;
	private String userName;
	private String password;
	private String isAdmin;

	public String getPassword() {
		return password;
	}

	public void getUserInfo() {
		System.out.println("ID :" + getId());
		System.out.println("UserName :" + getUserName());
		System.out.println("Password :" + getPassword());
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setBeanName(String beanName) {

		System.out.println(beanName + " bean has been init");
	}

	public void setApplicationContext(ApplicationContext context) throws BeansException {

		System.out.println(context + " is ApplicationContext");

	}

	public String getIsAdmin() {
		return isAdmin;
	}

	public void setIsAdmin(String isAdmin) {
		this.isAdmin = isAdmin;
	}

}
