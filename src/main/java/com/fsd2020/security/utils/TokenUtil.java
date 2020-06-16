package com.fsd2020.security.utils;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fsd2020.security.data.entity.TokenEntity;

public class TokenUtil {

	private final static Logger logger = LoggerFactory.getLogger(TokenUtil.class);
	// token
	private static long expireMilliSeconds = 1000000;
	
	// Judge if token list has this username
	protected static TokenEntity getToken(String token, List<TokenEntity> allTokens) {
		if (allTokens!=null) {
			for (TokenEntity tokenEntity : allTokens) {
							
				if (token.equals(tokenEntity.getToken())) {
					return tokenEntity;
				}
			}
		}
		
		return new TokenEntity("","",-1);
	}
	
	public static TokenEntity getUnamebyToken(String token) {
		return getToken(token, Tokens.getUserTokens());
	}
	
	// validation method
	public static Boolean validateToken(String token) {
		TokenEntity tokenEntity = getToken(token, Tokens.getUserTokens());
		
		/*
		 * 
		 * Situation of Token is blank
		 * Attention: This situation will not happens, but we should add a judge here
		 * */
		if (tokenEntity.getToken().equals("")) {
			return false;
		}
		logger.warn("pass blank judgement");
		/*
		 * Situation of Token is not equals with the one in storage 
		 * */
		if (!token.equals(tokenEntity.getToken())) {
			return false;
		}
		logger.warn("pass equals judgement");
		/*
		 * Judge if token has been expired
		 * */
		long currentTime = new Date().getTime();
		long tokenTime = tokenEntity.getCreateTimestamp();
		long timePeoid = currentTime - tokenTime;
		if (!(timePeoid < expireMilliSeconds)) {
			return false;
		}
		return true;
	}
	
	// update user token
	protected static List<TokenEntity> changeToken(String username, String token) {
		for (TokenEntity tokenEntity : Tokens.userTokens) {
			if (username.equals(tokenEntity.getName())) {
				tokenEntity.setToken(token);
				tokenEntity.setCreateTimestamp(new Date().getTime());
				return Tokens.userTokens;
			}
		}
		
		Tokens.userTokens.add(new TokenEntity(username, token, new Date().getTime()));
		return Tokens.userTokens;
	}
	
}
