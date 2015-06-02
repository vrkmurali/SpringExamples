package com.iton.sprint.dto;

public class UserDetails {
	
	private String userAge;
	private String className;
	private String vilalge;
	public String getUserAge() {
		return userAge;
	}
	public void setUserAge(String userAge) {
		this.userAge = userAge;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public String getVilalge() {
		return vilalge;
	}
	public void setVilalge(String vilalge) {
		this.vilalge = vilalge;
	}
	@Override
	public String toString() {
		return "UserDetails [userAge=" + userAge + ", className=" + className
				+ ", vilalge=" + vilalge + "]";
	}
	
	

}
