package ch05;

public class MemberMain {
	
	public static void main(String[] args) {
		Member member1 = new Member("홍길동", "010-1234-4567", "조리", 4, "asd@asd.com");
		Member member2 = new Member("홍길금", "010-1234-7890", "경영", 3, "zxc@asd.com", "1998-07-06", "서울");
		member1.printInfo();
		member2.printInfo();
	}
}
