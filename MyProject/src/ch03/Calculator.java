package ch03;
import java.util.InputMismatchException;
import java.util.Scanner;

//Calculator 클래스를 정의해봅시다.
//① 정수 두 개를 매개변수의 인자로 전달받아 더하기연산 후 반환하는 메소드를 정의
//② 정수 두 개를 매개변수의 인자로 전달받아 빼기연산 후 반환하는 메소드를 정의
//③ 정수 두 개를 매개변수의 인자로 전달받아 곱하기연산 후 반환하는 메소드를 정의
//④ 정수 두 개를 매개변수의 인자로 전달받아 나누기연산 후 반환하는 메소드를 정의
//⑤ 실수 반지름 하나를 매개변수의 인자로 전달받아 원의 둘레를 구해 반환하는 메소드를 반환하는 메소드를 정의
//⑥ 실수 반지름 하나를 매개변수의 인자로 전달받아 원의 넓이를 구해 반환하는 메소드를 반환하는 메소드를 정의
//원의 둘레 : 2 x π x r , 월의 넓이 : π x r x r
//⑦ main() 메소드를 정의하고 각각의 메소드를 호출해서 결과를 콘솔에 출력해봅시다.
//⑧ 콘솔에서 사용자에게 데이터를 받아 메소드를 호출할 때 사용자에게 받은 데이터를 
//메소드의 매개변수의 인자로 전달하는 코드를 main() 메소드에 추가해봅시다.

public class Calculator {
	
	public static String inputValue() {
		Scanner scanner = new Scanner(System.in);
		String input = scanner.nextLine();
		return input;
	}
	
	static long add(int x, int y) {
		return x+y;
	}
	
	static long substract(int x, int y) {
		return x-y;
	}
	
	static int multiply(int x, int y) {
		return x*y;
	}
	
	static double divide(int x, int y) {
		return x/y;
	}
	
	static double circumference(double x) {
		return  2*x*3.141;
	}
	
	static double areaOfCircle(double x) {
		return 3.141*x*x;
	}
	
	public static void main(String[] args) {
		
		try {
		System.out.println("연산할 두 값을 입력해주세요.");
		int a = Integer.parseInt(inputValue());
		int b = Integer.parseInt(inputValue());
		long c1 = add(a,b);
		long c2 = substract(a,b);
		int c3 = multiply(a,b);
		double c4 = divide(a,b);
		System.out.println("두 값을 더한 값은 "+c1+"입니다.");
		System.out.println("두 값을 뺀 값은 "+c2+"입니다.");
		System.out.println("두 값을 곱한 값은 "+c3+"입니다.");
		System.out.println("두 값을 나눈 값은 "+c4+"입니다.");
		
		System.out.println();
		System.out.println("원의 반지름을 입력해주세요.");
		double a5 = Double.parseDouble(inputValue());
		double b5 = circumference(a5);
		System.out.printf("원의 둘레는 %g 입니다.\n",b5);
		double c5 = areaOfCircle(a5);
		System.out.printf("원의 넓이는 %g 입니다.\n",c5);
		
		} catch(ArithmeticException e) {
			System.out.println("0으로는 나눌 수 없습니다.");
		} catch(InputMismatchException e) {
			System.out.println("계산할 수 없는 값입니다.");
		} catch(NumberFormatException e) {
			System.out.println("계산할 수 없는 값입니다.");
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
	}

}
