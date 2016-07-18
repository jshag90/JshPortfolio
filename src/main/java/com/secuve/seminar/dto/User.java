package com.secuve.seminar.dto;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class User implements BeanNameAware, ApplicationContextAware {

	private String id;
	private String password;
	private String name;
	private String email;

	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getId() {
		return id;
	}

	public String getPassword() {
		return password;
	}

	public void getUserInfo() {
		System.out.println("ID :" + getId());
		System.out.println("Password :" + getPassword());
	}

	public void setId(String id) {
		this.id = id;
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

}
