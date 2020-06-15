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

	// 工具方法，判断用户是否已经登录
	private static TokenEntity getToken(String username) {
		for (TokenEntity tokenEntity : userTokens) {
			if (username.equals(tokenEntity.getName())) {
				return tokenEntity;
			}
		}
		return new TokenEntity("","",0);
	}
	
	// 验证方法
	public static Boolean validateToken(String username, String token) {
		
		System.out.println("validate token -> ");
		System.out.println("input: " + username + " , " + token);
		
		TokenEntity tokenEntity = getToken(username);
		
		if (tokenEntity.getToken().equals("")) {
			return false;
		}
		
		if (!token.equals(tokenEntity.getToken())) {
			return false;
		}
				
		if (((new Date().getTime()) - tokenEntity.getCreateTimestamp()) < expireMilliSeconds) {
			return false;
		}
		return true;
	}
	
}
