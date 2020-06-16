package com.fsd2020.security.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fsd2020.security.data.User;
import com.fsd2020.security.data.entity.TokenEntity;
import com.fsd2020.security.data.mappers.UserMapper;

@RestController
public class TokenController {

	@Autowired
    private UserMapper userMapper;
	
	@GetMapping("querytoken")
	public List<User> indexPage() {
		List<User> users = userMapper.selectUser();
		return users;
	}
	
	@GetMapping("addtoken")
    public String index(String username, String token){
		
		
        return "index";
    }
}
