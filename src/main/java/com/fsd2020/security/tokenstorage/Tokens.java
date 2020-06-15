package com.fsd2020.security.tokenstorage;

import java.util.Set;
import com.fsd2020.security.data.entity.TokenEntity;
import lombok.ToString;

@ToString
public class Tokens {

	private static Set<TokenEntity> userTokens;

	public static Set<TokenEntity> getUserTokens() {
		return userTokens;
	}

	public static void setUserTokens(Set<TokenEntity> userTokens) {
		Tokens.userTokens = userTokens;
	}
}
