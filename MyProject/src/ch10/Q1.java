package ch10;

import java.util.*;

public class Q1 {
	
	String id;
	
	public static String getUserInput() {
		Scanner kb = new Scanner(System.in);
		String input = kb.nextLine();
		return input;
	}
	
	public Q1(String id) throws BadIdInputException {
		this.id = id;
		char[] idChar = id.toCharArray();
		for(int i = 0 ; i < id.length() ; i++) {
			if( id.length() == 0 || 
			 !((idChar[i] >= 'a' && idChar[i] <= 'z') ||
			   (idChar[i] >= 'A' && idChar[i] <= 'Z') ||
			   (idChar[i] >= '0' && idChar[i] <= '9'))) {
				throw new BadIdInputException("id는 숫자나 문자로 공백없이 입력해주세요.");
			}
		}
	}
	
	public static void main(String[] args) {
		try {
			System.out.println("id를 입력해주세요.");
			String id = getUserInput();
			Q1 user1 = new Q1(id);
			String id2 = getUserInput();
			Q1 user2 = new Q1(id2);
			
		} catch (BadIdInputException e) {
			System.out.println(e.getMessage());
		}
	}

}
