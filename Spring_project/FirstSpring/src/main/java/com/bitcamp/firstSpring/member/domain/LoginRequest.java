package com.bitcamp.firstSpring.member.domain;

public class LoginRequest {
	private String id;
	private String pw;
	
	//기본 생성자 필수
	LoginRequest(){}
	
	LoginRequest(String id, String pw){
		this.id=id;
		this.pw=pw;
	}
	
	//getter & setter
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	
	//toString
	@Override
	public String toString() {
		return "LoginRequest [id=" + id + ", pw=" + pw + "]";
	}
}
