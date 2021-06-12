package project;

public class CompanyContact extends Contact {
	
	private String companyName;
	private String deptName;
	
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

	public CompanyContact(String name, 
			String phoneNum, 
			String email, 
			String address, 
			String birth, 
			String group,
			String companyName,
			String deptName,
			String jobGrade) {
		super(name, phoneNum, email, address, birth, group);
		this.companyName = companyName;
		this.deptName = deptName; 
		setJobGrade(jobGrade);
	}

	@Override
	public void showData() {
		System.out.println("연락처 정보를 출력합니다.");
		System.out.println( "=================" );
		System.out.println("이름  : " + this.getName());
		System.out.println("전화번호: " + this.getPhoneNum());
		System.out.println("이메일: " + this.getPhoneNum());
		System.out.println("주소  : " + this.getAddress());
		System.out.println("생년월일: " + this.getBirth());
		System.out.println("그룹  : " + this.getGroup());
		System.out.println("소속회사: " + this.getCompanyName());
		System.out.println("부서명 : " + this.getDeptName());
		System.out.println("직급  : " + this.getJobGrade());
		System.out.println( "=================" );
	}

}
