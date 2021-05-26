package ch05;

//1. Member 클래스에는 아래 요구사항에 맞는 변수와 메소드를 정의하고, 
//main()메소드 에 해당 메소드를 호출해서 결과를 확인해보세요. 
//단 인스턴스의 생성은 생성자를 이용해서 초기화하는 코드를 작성해 봅시다. 
// 생성자 > 
//① 아래의 데이터를 저장 (이름, 전화번호, 전공, 학년, email, 생일, 주소)
//② 위에서 정의한 정보를 출력하는 메소드 정의 (기능>메소드)
//③ 모든 정보를 저장하도록 하는 생성자와 생일과 주소는 저장하지 않을 수 있는 생성자 정의
// 생성자의 요구사항 > 생성자 오버로딩, 오버로딩 > 이름이 같은 메소드 정의
//④ main() 메소드에서 두 가지 생성자를 이용해서 인스턴스 생성하고 출력 메소드를 통해 저장된 데이터 출력


// 직렬화
// 변수의 기능 1) Data 메모리 저장
//		   2) 주소 기능

public class Member {
	
	String name;
	String phonNum;
	String major;
	int grade;
	String email;
	String birth;
	String address;
	
	Member(String name, String phonNum, String major, int grade, String email) {
		this(name, phonNum, major, grade, email, null, null);
	}
	
	Member(String name, String phonNum, String major, int grade, String email, String birth, String address) {
		this.name = name;
		this.phonNum = phonNum;
		this.major = major;
		this.grade = grade;
		this.email = email;
		this.birth = birth;
		this.address = address;
	}
	
	void printInfo() {
		System.out.println("이름: "+name);
		System.out.println("전화번호: "+phonNum);
		System.out.println("전공: "+major+"학과");
		System.out.println("학년: "+grade+"학년");
		System.out.println("생일: "+birth);
		System.out.println("주소: "+address+'\n');
	}
	
	public static void main(String[] args) {
		Member member1 = new Member("홍길동", "010-1234-4567", "조리", 4, "asd@asd.com");
		Member member2 = new Member("홍길금", "010-1234-7890", "경영", 3, "zxc@asd.com", "1998-07-06", "서울");
		member1.printInfo();
		member2.printInfo();
	}

}
