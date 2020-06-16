package com.fsd2020.security.utils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.fsd2020.security.data.entity.TokenEntity;
import lombok.ToString;

@ToString
public class Tokens {

	protected static List<TokenEntity> userTokens = new ArrayList<TokenEntity>();
		
	static {
		userTokens.clear();
		userTokens.add(new TokenEntity("cyz1", "1233", new Date().getTime()));
	}
	
	// validate
	public static Boolean validateToken(String token) {
		return TokenUtil.validateToken(token);
	}
	
	// add or modify
	public static void addToken(TokenEntity tokenEntity) {
		TokenUtil.changeToken(tokenEntity.getName(), tokenEntity.getToken());
	}

	public static List<TokenEntity> getUserTokens() {
		return userTokens;
	}
	
}
