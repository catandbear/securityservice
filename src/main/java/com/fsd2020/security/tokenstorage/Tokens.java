package com.fsd2020.security.tokenstorage;

import java.util.Date;
import java.util.List;
import com.fsd2020.security.data.entity.TokenEntity;
import lombok.ToString;

@ToString
public class Tokens {

	private static List<TokenEntity> userTokens;
	
	// token过期时间
	private static long expireMilliSeconds = 1000000;
	
	// 验证方法
	public static Boolean validateToken(String username, String token) {
		
		System.out.println("validate token -> ");
		System.out.println("input: " + username + " , " + token);
		
		TokenEntity tokenEntity = TokenUtil.getToken(username, userTokens);
		
		/*
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
	
	public static void addToken(TokenEntity token) {
		String uname = token.getName();
		TokenEntity token2= TokenUtil.getToken(uname, userTokens);
		// 
		if (uname.equals(token2.getName())) {
			// user token exist in token list, need to change
			
		}
	}
	
}
