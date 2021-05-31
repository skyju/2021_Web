package test3;

public class UnivFriend extends Friend {
	
	String major;
	
	public UnivFriend(String name, String phoneNumber, String address, String major) {
		super(name, phoneNumber, address);
		this.major = major;
	}

	@Override
	public void showData() {
		super.showData();
		System.out.println("전   공: "+this.major);
	}

	@Override
	public void showBasicInfo() {
		System.out.println("이   름: "+this.name);
		System.out.println("전화 번호: "+this.phoneNumber);
		System.out.println("전   공: "+this.major);
	}


}
