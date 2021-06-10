package project;

public class CustomerContact extends Contact {
	private String CustCompanyName;
	private String item;
	private String jobGrade;
	public CustomerContact(String name, 
			String phoneNum, 
			String email, 
			String address, 
			String birth, 
			String group) {
		super(name, phoneNum, email, address, birth, group);

	}

}
