package homework.program2;

public abstract class Friend implements ShowData{
	
	//이름, 전화번호, 주소 ... 기본 상속
	String name;
	String phoneNumber;
	String address;
	
	public Friend(String name, String phoneNumber, String address) {
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.address = address;
	}
	
	public void showInfo() {
		System.out.println("이   름: "+this.name);
		System.out.println("전화 번호: "+this.phoneNumber);
		System.out.println("주   소: "+this.address);
	}
//	public abstract void showBasicInfo();
}
