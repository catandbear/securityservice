package com.fsd2020.security.data;

public class User {

	private int id;
    private String user_name;
    private String password;
    private String user_type;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUser_type() {
		return user_type;
	}
	public void setUser_type(String user_type) {
		this.user_type = user_type;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", user_name=" + user_name + ", password=" + password + ", user_type=" + user_type
				+ "]";
	}
	public User(int id, String user_name, String password, String user_type) {
		this.id = id;
		this.user_name = user_name;
		this.password = password;
		this.user_type = user_type;
	}
	public User() {
	}
    
    
}
