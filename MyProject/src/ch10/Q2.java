package ch10;

import java.util.*;

public class Q2 {
	
	public static int getUserInput() {
		Scanner kb = new Scanner(System.in);
		int input = kb.nextInt();
		return input;
	}
	
	public static void main(String[] args) {
		try {
			int birth = getUserInput();
		} catch (InputMismatchException e) {
			System.out.println("숫자가 아닙니다.");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
