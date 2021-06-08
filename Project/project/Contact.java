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
		return "Contact \n[name=" + name 
				+ "\n phoneNum=" + phoneNum 
				+ "\n email=" + email 
				+ "\n address=" + address
				+ "\n birth=" + birth 
				+ "\n group=" + group + "]";
	}
	
	
}
