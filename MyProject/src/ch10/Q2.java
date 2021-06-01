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
			System.out.println("태어난 년도를 입력해주세요.");
			int birth = getUserInput();
			if(birth < 1900 || birth > 2021) {
				throw new BadIdInputException("잘못된 년도입니다.");
			}
		} catch (InputMismatchException e) {
			System.out.println("숫자가 아닙니다.");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
