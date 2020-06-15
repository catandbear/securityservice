package com.fsd2020.security.data.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@NoArgsConstructor
@AllArgsConstructor
public class TokenEntity {

	private String uname;
	private String token;
	private long createTimestamp;
	public String getName() {
		return uname;
	}
	public void setName(String name) {
		this.uname = name;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public long getCreateTimestamp() {
		return createTimestamp;
	}
	public void setCreateTimestamp(long createTimestamp) {
		this.createTimestamp = createTimestamp;
	}
	
}
