package cal;

public class Calculator {
	public int add(int x, int y) {
		return x+y;
	}
	
	public int substract(int x, int y) {
		return x-y;
	}
	
	public int multiply(int x, int y) {
		return x*y;
	}
	
	public int divide(int x, int y) {
		return x/y;
	}
	
//	public static void main(String[] args) {
//		Calculator cal = new Calculator();
//		
//		//덧셈 테스트
//		System.out.println(cal.add(10, 2)); //12
//		
//		//뺄셈 테스트
//		System.out.println(cal.substract(10, 2)); //8
//		
//		//곱셈 테스트
//		System.out.println(cal.multiply(10, 2)); //20
//		
//		//나눗셈 테스트
//		System.out.println(cal.divide(10, 2)); //5
//	}
}
