package ch09;

import java.util.*;

public class Q3 {
	
	public static boolean checkName(String str) {
		boolean result = true;
		for(int i = 0 ; i < str.length(); i++) {
			char ch = str.charAt(i);
			if(!(ch >= 'a' && ch <= 'z' || ch >= 'A' && ch <= 'Z')) {
				result = false;
				break;
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		
		Scanner kb = new Scanner(System.in);
		System.out.println("영문 이름을 입력해주세요.");
		String name = kb.nextLine();
		
		if(name != null && !name.trim().isEmpty()) {
			if(checkName(name)) {
				System.out.println("입력하신 이름은: "+name);
			} else {
				System.out.println("이름에 표현 불가능한 문자가 포함되어 있습니다.");
			}
		} else {
			System.out.println("공백입니다.");
		}
	}
}
