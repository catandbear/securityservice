package com.fsd2020.security.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fsd2020.security.data.User;
import com.fsd2020.security.data.mappers.UserMapper;

@Service
public class UserUtil {
	private static Logger logger = LoggerFactory.getLogger(UserUtil.class);
	private UserMapper userMapper;
	
	@Autowired
	private UserUtil(UserMapper userMapper) {
		this.userMapper = userMapper;
	}
	
	public boolean validateUser(String username){
		User user = userMapper.selectUserByName(username);
		logger.warn(user.toString());
		if (user != null) {
			if("Y".equals(user.getConfirmed().trim())||"y".equals(user.getConfirmed().trim()))
				return true;
		}
		return false;
	}
}
