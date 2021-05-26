package ch07;

import java.util.*;

public class Driver {
	void printInput() {
		Scanner scanner = new Scanner(System.in);
		String inputString = scanner.nextLine();
	}
	public static void main(String[] args) {
		Female person1 = new Female("홍길순", "9809052745687");
		person1.ageCal();
		person1.checkSex();
		person1.hello();
	}

}
