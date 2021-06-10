package project;

public class CompanyContact extends Contact {
	
	private String companyName;
	private String deptName;
	private String gobGrade;

	
	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getGobGrade() {
		return gobGrade;
	}

	public void setGobGrade(String gobGrade) {
		this.gobGrade = gobGrade;
	}

	public CompanyContact(String name, 
			String phoneNum, 
			String email, 
			String address, 
			String birth, 
			String group,
			String companyName,
			String deptName,
			String gobGrade) {
		super(name, phoneNum, email, address, birth, group);
		this.companyName = companyName;
		this.deptName = deptName; 
		this.gobGrade = gobGrade;
	}

	@Override
	public String toString() {
		return  " 연락처 \n[이름: " + this.getName()
				+ "\n 전화번호: " + this.getPhoneNum()
				+ "\n 이메일: " + this.getEmail()
				+ "\n 주소: " + this.getEmail()
				+ "\n 생년월일: " + this.getBirth()
				+ "\n 그룹: " + this.getGroup()
				+ "\n 소속회사: " + this.getCompanyName()
				+ "\n 부서명: " + this.getDeptName()
				+ "\n 직급: " + this.getGobGrade() + "]";
	}

}
