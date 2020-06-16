package com.fsd2020.security.data;

public class User {

	private int id;
    private String user_name;
    private String password;
    private String confirmed;
    
    
	public String getConfirmed() {
		return confirmed;
	}
	public void setConfirmed(String confirmed) {
		this.confirmed = confirmed;
	}
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
	
	@Override
	public String toString() {
		return "User [id=" + id + ", user_name=" + user_name + ", password=" + password + ", confirmed=" + confirmed
				+ "]";
	}
	
	public User(int id, String user_name, String password, String confirmed) {
		super();
		this.id = id;
		this.user_name = user_name;
		this.password = password;
		this.confirmed = confirmed;
	}
	public User() {
	}
    
    
}
