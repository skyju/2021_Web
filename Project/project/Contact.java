package project;

public class Contact {
	private String name;
	private String phoneNum;
	private String email;
	private String address;
	private String birth;
	private String group;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public String getGroup() {
		return group;
	}
	public void setGroup(String group) {
		this.group = group;
	}

	public Contact(String name, 
				   String phoneNum, 
				   String email, 
				   String address, 
				   String birth, 
				   String group) {
		this.name = name;
		this.phoneNum = phoneNum;
		this.email = email;
		this.address = address;
		this.birth = birth;
		this.group = group;
	}
	
	@Override
	public String toString() {
		return  " 연락처 \n[이름: " + this.getName()
				+ "\n 전화번호: " + this.getPhoneNum()
				+ "\n 이메일: " + this.getEmail()
				+ "\n 주소: " + this.getEmail()
				+ "\n 생년월일: " + this.getBirth()
				+ "\n 그룹: " + this.getGroup() + "]";
	}

}