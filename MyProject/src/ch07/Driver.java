package ch07;

import java.util.*;

public class Driver {
	void printInput() {
		Scanner scanner = new Scanner(System.in);
		String inputString = scanner.nextLine();
	}
	public static void main(String[] args) {
		Female person1 = new Female("홍길순", "9209052745687", "여행");
		person1.hello();
		System.out.println("================");
		Male person2 = new Male("홍길동", "0305023789564", "사진찍기");
		person2.hello();
		System.out.println("================");
		Person person3 = new Person("아무개", "8806081889566");
		person3.hello();
	}

}
