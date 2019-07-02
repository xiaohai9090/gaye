package com.ssm.crm.service;

import com.ssm.crm.domain.User;

public interface UserService {

	void addUser(User user);
	
	User loginUser(String username,String password);
}
