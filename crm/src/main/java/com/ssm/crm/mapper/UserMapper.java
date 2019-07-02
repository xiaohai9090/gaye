package com.ssm.crm.mapper;

import org.apache.ibatis.annotations.Param;

import com.ssm.crm.domain.User;

public interface UserMapper {

	void addUser(User user);
	
	User loginUser(@Param("username")String username,@Param("password")String password);
}
