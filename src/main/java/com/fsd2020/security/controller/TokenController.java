package com.fsd2020.security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fsd2020.security.utils.Tokens;
import com.fsd2020.security.utils.UserUtil;

@RestController
public class TokenController {

	private UserUtil userUtil;
	
	@Autowired
	private TokenController(UserUtil userUtil) {
		this.userUtil = userUtil;
	}
	
	@GetMapping("querytoken")
	public boolean query(String username, String token) {
		boolean tokenStatus = Tokens.validateToken(username, token);
		boolean userStatus = userUtil.validateUser(username);
		return tokenStatus && userStatus;
	}
	
	@GetMapping("addtoken")
    public String addormodify(String username, String token){
		
        return "index";
    }
}
