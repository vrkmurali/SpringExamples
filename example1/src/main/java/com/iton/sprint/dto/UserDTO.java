package com.iton.sprint.dto;

public class UserDTO {

	private User user;
	private UserDetails userDetails;
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public UserDetails getUserDetails() {
		return userDetails;
	}
	public void setUserDetails(UserDetails userDetails) {
		this.userDetails = userDetails;
	}
	@Override
	public String toString() {
		return "UserDTO [user=" + user + ", userDetails=" + userDetails + "]";
	}
	
	
	
}
