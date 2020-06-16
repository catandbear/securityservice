package com.fsd2020.security.utils;

import java.util.Date;
import java.util.List;

import com.fsd2020.security.data.entity.TokenEntity;

public class TokenUtil {

	// token
	private static long expireMilliSeconds = 1000000;
	
	// Judge if token list has this username
	protected static TokenEntity getToken(String username, List<TokenEntity> allTokens) {
		for (TokenEntity tokenEntity : allTokens) {
			if (username.equals(tokenEntity.getName())) {
				return tokenEntity;
			}
		}
		return new TokenEntity("","",-1);
	}
	
	// validation method
	public static Boolean validateToken(String username, String token, List<TokenEntity> userTokens) {
		
		System.out.println("validate token -> ");
		System.out.println("input: " + username + " , " + token);
		
		TokenEntity tokenEntity = getToken(username, userTokens);
		
		/*
		 * 
		 * Situation of Token is blank
		 * Attention: This situation will not happens, but we should add a judge here
		 * */
		if (tokenEntity.getToken().equals("")) {
			return false;
		}
		/*
		 * Situation of Token is not equals with the one in storage 
		 * */
		if (!token.equals(tokenEntity.getToken())) {
			return false;
		}
		/*
		 * Judge if token has been expired
		 * */
		if (((new Date().getTime()) - tokenEntity.getCreateTimestamp()) < expireMilliSeconds) {
			return false;
		}
		return true;
	}
	
	// update user token
	protected static List<TokenEntity> changeToken(String username, String token, List<TokenEntity> allTokens) {
		for (TokenEntity tokenEntity : allTokens) {
			if (username.equals(tokenEntity.getName())) {
				tokenEntity.setToken(token);
				tokenEntity.setCreateTimestamp(new Date().getTime());
				return allTokens;
			}
		}
		
		allTokens.add(new TokenEntity(username, token, new Date().getTime()));
		return allTokens;
	}
	
}
