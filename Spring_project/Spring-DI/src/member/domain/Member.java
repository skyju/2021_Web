package member.domain;

import java.util.Date;

public class Member {
	private int id;
	private String email;
	private String password;
	private String name;
	private Date regDate;
	
	public Member(int id, String email, String password, String name, Date regDate) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
		this.name = name;
		this.regDate = regDate;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public String getName() {
		return name;
	}

	public Date getRegDate() {
		return regDate;
	}
	
	// 비밀번호 변경 메소드
	public void changePw(String oldPw, String newPw) throws Exception {
		if(this.password.equals(oldPw)) {
			this.password=newPw;
		} else {
			throw new Exception("It is not matching your own password!");
		}
	}
}
