package projectTOlist;

public class CustomerContact extends Contact {
	private String custCompanyName;
	private String item;
	
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
		setJobGrade(jobGrade);
	}

	@Override
	public void showData() {
		System.out.println("연락처 정보를 출력합니다.");
        System.out.println( "=================" );
		System.out.println(" 1. 이름  : " + this.getName());
		System.out.println(" 2. 전화번호: " + this.getPhoneNum());
		System.out.println(" 3. 이메일: " + this.getEmail());
		System.out.println(" 4. 주소  : " + this.getAddress());
		System.out.println(" 5. 생년월일: " + this.getBirth());
		System.out.println(" 6. 그룹  : " + this.getGroup());
		System.out.println(" 7. 거래처명: " + this.getCustCompanyName());
		System.out.println(" 8. 거래품목: " + this.getItem());
		System.out.println(" 9. 직급  : " + this.getJobGrade());
        System.out.println( "=================" );
	}
}
