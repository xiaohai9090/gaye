package com.ssm.crm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssm.crm.domain.User;
import com.ssm.crm.mapper.UserMapper;
import com.ssm.crm.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;
	
	@Override
	public void addUser(User user) {
		userMapper.addUser(user);
	}

	@Override
	public User loginUser(String username, String password) {
		User user = userMapper.loginUser(username, password);
		return user;
	}

}
