package com.fsd2020.security.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fsd2020.security.data.User;
import com.fsd2020.security.data.mappers.UserMapper;

@Service
public class UserUtil {

	private UserMapper userMapper;
	
	@Autowired
	private UserUtil(UserMapper userMapper) {
		this.userMapper = userMapper;
	}
	
	public boolean validateUser(String username){
		User user = userMapper.selectUserByName(username);
		if (user != null) {
			if("Y".equals(user.getConfirmed()))
				return true;
		}
		return false;
	}
}
