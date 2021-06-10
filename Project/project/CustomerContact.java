package project;

public class CustomerContact extends Contact {
	private String custCompanyName;
	private String item;
	private String jobGrade;
	
	public String getCustCompanyName() {
		return custCompanyName;
	}

	public void setCustCompanyName(String custCompanyName) {
		this.custCompanyName = custCompanyName;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public String getJobGrade() {
		return jobGrade;
	}

	public void setJobGrade(String jobGrade) {
		this.jobGrade = jobGrade;
	}

	public CustomerContact(String name, 
			String phoneNum, 
			String email, 
			String address, 
			String birth, 
			String group,
			String cutCompanyName,
			String item,
			String jobGrade) {
		super(name, phoneNum, email, address, birth, group);
		this.custCompanyName = cutCompanyName;
		this.item = item; 
		this.jobGrade = jobGrade;
	}
	
	@Override
	public String toString() {
		return  " 연락처 \n[이름: " + this.getName()
				+ "\n 전화번호: " + this.getPhoneNum()
				+ "\n 이메일: " + this.getEmail()
				+ "\n 주소: " + this.getEmail()
				+ "\n 생년월일: " + this.getBirth()
				+ "\n 그룹: " + this.getGroup()
				+ "\n 거래처명: " + this.getCustCompanyName()
				+ "\n 거래품목: " + this.getItem()
				+ "\n 직급: " + this.getJobGrade() + "]";
	}
}
