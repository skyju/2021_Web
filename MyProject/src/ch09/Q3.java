package ch09;

import java.util.*;

public class Q3 {
	
	public static String getUserInput() {
		Scanner kb = new Scanner(System.in);
		String inputString = kb.nextLine();
		return inputString;
	}
	
	public static void isEmpty(String str) {
		if(str.equals("")) {
			System.out.println("공백입니다.");
		} else if(!str.equals(null)) {
			System.out.println("이름이 입력되었습니다.");
		}
	}
	
	public static void main(String[] args) {
		System.out.println("이름을 입력해주세요.");
		String name = getUserInput();
		isEmpty(name);
	}
}
