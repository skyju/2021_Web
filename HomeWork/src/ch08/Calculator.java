package ch08;

import java.util.*;

public class Calculator extends ACalculator {

	@Override
	public long add(long n1, long n2) {
		return n1+n2;
	}

	@Override
	public long substract(long n1, long n2) {
		return n1-n2;
	}

	@Override
	public long multiply(long n1, long n2) {
		return n1*n2;
	}

	@Override
	public double divide(double n1, double n2) {
		return n1/n2;
	}
	
	@Override
	public void showResult() {
		Scanner kb = new Scanner(System.in);
		System.out.println("첫 번째 수를 입력해주세요.");
		long Value1 = kb.nextInt();
		System.out.println("두 번째 수를 입력해주세요.");
		long Value2 = kb.nextInt();
		System.out.println("add result: "+add(Value1, Value2));
		System.out.println("substract result: "+substract(Value1, Value2));
		System.out.println("multiply result: "+multiply(Value1, Value2));
		System.out.println("divide result: "+divide(Value1, Value2));
	}
	
	public static void main(String[] args) {
		ICalculator cal1 = new Calculator();
		ACalculator cal2 = new Calculator();
		
		((Calculator) cal1).showResult();
	}

}
