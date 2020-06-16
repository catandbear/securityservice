package com.fsd2020.security.controller;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fsd2020.security.data.entity.TokenEntity;
import com.fsd2020.security.utils.TokenUtil;
import com.fsd2020.security.utils.Tokens;
import com.fsd2020.security.utils.UserUtil;

@RestController
@CrossOrigin("*")
public class TokenController {

	private final static Logger logger = LoggerFactory.getLogger(TokenController.class);
	private UserUtil userUtil;
	
	@Autowired
	private TokenController(UserUtil userUtil) {
		this.userUtil = userUtil;
	}
	
	@GetMapping("querytoken")
	public boolean query(@RequestParam(value="token", required = true) String token) {
		boolean tokenStatus = Tokens.validateToken(token);
		boolean userStatus = userUtil.validateUser(TokenUtil.getUnamebyToken(token).getName());
		logger.warn("token status: " + tokenStatus);
		logger.warn("user status: " + userStatus);
		return tokenStatus && userStatus;
	}
	
	@GetMapping("addtoken")
    public void addormodify(@RequestParam(value="username", required = true) String username, @RequestParam(value="token", required = true) String token){
		Tokens.addToken(new TokenEntity(username, token, new Date().getTime()));
		for (TokenEntity tokens : Tokens.getUserTokens()) {
			logger.warn(tokens.toString());
		}
    }
}
