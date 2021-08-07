package com.bitcamp.member.domain;

import org.springframework.web.multipart.MultipartFile;

public class Report {

	private String id;
	private String pw;
	private String name;
	private MultipartFile photo;

	public Report() {
	}

	public Report(String id, String pw, String name, MultipartFile photo) {
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.photo = photo;
	}

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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public MultipartFile getPhoto() {
		return photo;
	}

	public void setPhoto(MultipartFile report) {
		this.photo = report;
	}

	@Override
	public String toString() {
		return "Report [id=" + id + ", pw=" + pw + ", name=" + name + ", photo=" + photo + "]";
	}
	
	

}