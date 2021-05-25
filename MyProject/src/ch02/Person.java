package ch02;

//Person 클래스를 만들어 보고, 아래의 회원 정보를 저장하는 변수들을 선언해봅시다. 
//변수이름을 작성하는 규칙에 맞게 직접 변수 이름을 정의해 보세요. 
public class Person {
	// 클래스의 구성 > 인스턴스 변수, 메서드
	
	//① 회원이름을 저장하는 변수
	String name; // 초기화를 생략 가능
	
	
	//② 회원 전화번호 ( 000-0000-0000 )를 저장하는 변수 (하이픈'-': 문자 > 문자열)
	String memberPhonNum = "000-0000-0000";
	
	
	//③ 회원 주민등록번호 ( 000000-0000000 또는 0000000000000 )를 저장하는 변수
	String idNum1 = "700000-0000000";
	long idNum2 = 7000000000000L;

	//인스턴스 변수들의 데이터를 출력하는 메서드
	void showData() {
		System.out.println("회원 이름: "+this.name);
		System.out.println("회원 전화번호: "+this.memberPhonNum);
		System.out.println("회원 주민등록번호: "+this.idNum1);
	}
	
	public static void main(String[] args) {
		//Person 인스턴스 생성
		Person person = new Person();
	}
	
}
