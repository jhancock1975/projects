package com.fau.fautodo;

public class User {

	public int 			userId;
	public String		username;
	public String		userPassword;
	public String		userEmail;
	
	public User() {
		
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public int getUserId() {
		return userId;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getUserPassword() {
		return userPassword;
	}
	
	public void setUserPassword(String password) {
		this.userPassword = password;
	}
	
	public void setUserEmail(String email) {
		this.userEmail = email;
	}
	
	public String getUserEmail() {
		return userEmail;
	}

}
