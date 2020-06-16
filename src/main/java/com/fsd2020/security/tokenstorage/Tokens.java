package com.fsd2020.security.tokenstorage;

import java.util.List;
import com.fsd2020.security.data.entity.TokenEntity;
import lombok.ToString;

@ToString
public class Tokens {

	private static List<TokenEntity> userTokens;
	
	// 验证方法
	public static Boolean validateToken(String username, String token) {
		
		return TokenUtil.validateToken(username, token, userTokens);
	}
	
	public static void addToken(TokenEntity tokenEntity) {
		String uname = tokenEntity.getName();
		TokenUtil.changeToken(uname, tokenEntity.getToken(), userTokens);
	}
	
}
