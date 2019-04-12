package com.jsc.domain;

import java.util.Date;

public class UserHistory {

	private int id;
	private int userId;
	private String username;
	private String password;
	private String type;
	private String operator_User;
	private Date last_Modified_Time;
	public UserHistory() {
		super();
	}
	public UserHistory(int userId, String username, String password, String type, String operator_User,
			Date last_Modified_Time) {
		super();
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.type = type;
		this.operator_User = operator_User;
		this.last_Modified_Time = last_Modified_Time;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
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
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getOperator_User() {
		return operator_User;
	}
	public void setOperator_User(String operator_User) {
		this.operator_User = operator_User;
	}
	public Date getLast_Modified_Time() {
		return last_Modified_Time;
	}
	public void setLast_Modified_Time(Date last_Modified_Time) {
		this.last_Modified_Time = last_Modified_Time;
	}
	@Override
	public String toString() {
		return "UserHistory [id=" + id + ", userId=" + userId + ", username=" + username + ", password=" + password
				+ ", type=" + type + ", operator_User=" + operator_User + ", last_Modified_Time=" + last_Modified_Time
				+ "]";
	}
}
