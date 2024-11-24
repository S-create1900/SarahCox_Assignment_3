package com.coderscampusA3;

public class UserPOJO {
	private String username;
	private String password;
	private String name;

	private int unsuccessfulLoginAttempts;

	public UserPOJO(String username, String password, String name) {
		// TODO Auto-generated constructor stub
	}

	// getters and setters for the above instance variables.
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getUnsuccessfulLoginAttempts() {
		return unsuccessfulLoginAttempts;
	}

	public void setUnsuccessfulLoginAttempts(int unsuccessfulLoginAttempts) {
		this.unsuccessfulLoginAttempts = unsuccessfulLoginAttempts;
	}

}
