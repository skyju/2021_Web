package test3;

public class HighFriend extends Friend {
	
	String job;
	
	public HighFriend(String name, String phoneNumber, String address, String job) {
		super(name, phoneNumber, address);
		this.job = job;
	}
	
	@Override
	public void showInfo() {
		super.showInfo();
		System.out.println("직   업: "+this.job);
	}
	
	@Override
	public void showBasicInfo() {
		System.out.println("이   름: "+this.name);
		System.out.println("전화 번호: "+this.phoneNumber);
	}
	
}
