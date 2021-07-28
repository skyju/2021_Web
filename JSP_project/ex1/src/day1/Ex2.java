package day1;

public class Ex2 {

	public static void main(String[] args) {
		
		// 변수
		// 숫자형, 문자형, 논리형
		
		// 숫자형 : double, float: 소수점이 있는거 - 실수 / int: 없는거 - 정수 
		double dou = 1.7d;
		float f = 2.4f;
		
		int number1 = 123;
		int number2 = 1;
		
		
		//System.out.println(dou);
		// 문자형 : char: 한글자 - 윤, 민 / String: 여러글자 - 윤지바보, 민주민주바보바보
		String s1 = "123";
		String s2 = "1";

		String s3 = 1+"";
		
		System.out.println(s1+"+"+s2);
		
		char mjc = 'a';
		
		// 논리형 : 참 true / 거짓 false 
		// boolean 변수이름 = 참/거짓;
		// 1. 5>4  -> true
		// 2. 4>5 -> false
		// 3. 1 == 1 -> true
		// 4. 1 != 1 -> false
		
		// 비교연산자
		// >, <, ==, <=, >=, !=
		// ! 부정연산자
		
		boolean check = !(1 != 1);
		boolean check2 = true;
		boolean check3 = false;
		
		// 넥슨 아이디 회원가입
		String id = "minju최강전사";
		String pw = "1234";
		// 로그인 
		String id2 = "minju최강전사";
		String pw2 = "4321";
		
		boolean check4 = id.equals(id2);
		boolean check5 = pw.equals(pw2);
		
		// 로그인하려면 아이디, 비밀번호 두개가 꼭 동시에 다 맞아야 하잖아
		// 수학: and : && / or  : ||
		boolean check6 = id.equals(id2) && pw.equals(pw2);
		
		System.out.println(check);
		System.out.println(check2);
		System.out.println(check4);
		System.out.println(check6);
		
		// 좌항 = 우항 ; : 우항에 있는거를 좌항에 대입
		// 수학= : == 같다는 비교연산지
		
	}
}
