package com.ssm.crm.controller;

import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssm.crm.domain.User;
import com.ssm.crm.service.UserService;

@RestController
@RequestMapping("user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@RequestMapping(value="add",produces="text/html;charset=UTF-8")
	public String addUser(User user) {
		String password = user.getPassword();
		Md5Hash md5hash = new Md5Hash(password, user.getUsername(), 2);
		String md5String = md5hash.toString();
		user.setPassword(md5String);
		try {
			userService.addUser(user);
			return "新增成功";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "新增失败";
		}
	}
	
	@RequestMapping("login")
	public String loginUser(String username,String password) {
		Md5Hash md5hash = new Md5Hash(password, username, 2);
		String pwd = md5hash.toString();
		User user = userService.loginUser(username, pwd);
		if(user != null) {
			return "登录成功";
		}else{
			return "登录失败";
		}
	}
}
