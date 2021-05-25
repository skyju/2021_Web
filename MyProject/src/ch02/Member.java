package ch02;

public class Member {
	
	//인스턴스 변수
	int num;

	public static void main(String[] args) {
		
		// 변수 선언
		// 데이터 타입 식별 이름
		// 데이터 타입 > 내가 다루어야 하는 데이터의 특징에 의하여 결정
		// 기본형 8가지 타입 > 정수형, 실수형, 논리형, 문자
		
		//① String 타입의 이름을 저장할 수 있는 변수 name을 정의해봅시다.
		String name = "손흥민";
		
		//② int 타입의 나이를 저장할 수 있는 변수 age를 정의해봅시다.
		int age = 27;
		
		//③ double 타입의 키를 저장할 수 있는 변수 height를 정의해봅시다. 
		double height = 185.3;
		float weight = 45.8f;
		//연산을 할 때 Type을 일치시켜야 함
		int num2 = 1+2; // int + int 
		//byte - short - int  작아질 때는 왜곡 가능성, 명시적 형변환
		
		//④ boolean 타입의 JAVA책의 보유 여부를 저장할 수 있는 변수 hasBook를 정의해봅시다.
		boolean hasBook = false;
		
		//⑤ 이름과 나이, 키, 책의 보유 여부를 출력해봅시다.
		System.out.println("이름은 "+name+"입니다.");
		System.out.println("나이는 "+age+"살 입니다.");
		//String + int + String > (String + String ) + String > String + String
		System.out.println("키는 "+height+"cm 입니다.");
		//String + double + String > (String + String) + String > String + String
		//String + anyType > String + String
		
		//System.out.println("책 보유 여부:"+hasBook);//String + boolean
		if(hasBook) {
			System.out.println("책 있어요.");
		} else {
			System.out.println("책 없어요.");
		}
		

	}

}
