package com.fsd2020.security.utils;

import java.util.List;
import com.fsd2020.security.data.entity.TokenEntity;
import lombok.ToString;

@ToString
public class Tokens {

	private static List<TokenEntity> userTokens;
	
	// validate
	public static Boolean validateToken(String username, String token) {
		return Tokens.validateToken(username, token);
	}
	
	// add or modify
	public static void addToken(TokenEntity tokenEntity) {
		TokenUtil.changeToken(tokenEntity.getName(), tokenEntity.getToken(), userTokens);
	}
	
}
