package com.exadata.dto;

public class LoginTo {
	
	private int id;
	private long phone;
	public LoginTo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public LoginTo(int id, long phone) {
		super();
		this.id = id;
		this.phone = phone;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}

	
}
