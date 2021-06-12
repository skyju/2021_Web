package homework.program1;

public class HighFriend extends Friend {
	
	String job;
	
	public HighFriend(String name, String phoneNumber, String address, String job) {
		super(name, phoneNumber, address);
		this.job = job;
	}
	
	public void showData() {
		super.showData();
		System.out.println("직   업: "+this.job);
	}
	
	public void showBasicInfo() {
		System.out.println("이   름: "+this.name);
		System.out.println("전화 번호: "+this.phoneNumber);
	}
	
}
