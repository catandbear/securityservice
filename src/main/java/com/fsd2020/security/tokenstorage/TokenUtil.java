package com.fsd2020.security.tokenstorage;

import java.util.Date;
import java.util.List;

import com.fsd2020.security.data.entity.TokenEntity;

public class TokenUtil {

	// Judge if token list has this username
	protected static TokenEntity getToken(String username, List<TokenEntity> allTokens) {
		for (TokenEntity tokenEntity : allTokens) {
			if (username.equals(tokenEntity.getName())) {
				return tokenEntity;
			}
		}
		return new TokenEntity("","",0);
	}
	
	// update token for exist user
	protected static void changeToken(String username, String token, List<TokenEntity> allTokens) {
		for (TokenEntity tokenEntity : allTokens) {
			if (username.equals(tokenEntity.getName())) {
				tokenEntity.setToken(token);
				tokenEntity.setCreateTimestamp(new Date().getTime());
			}
		}
	}
	
}
