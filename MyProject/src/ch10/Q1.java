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
		if(id.equals("")) {
			throw new BadIdInputException("아이디를 입력받지 못했습니다.");
		} else {
			System.out.println("id: "+id+"가 성공적으로 생성되었습니다.");
		}
	}
	
	public static void main(String[] args) {
		try {
			String id = getUserInput();
			Q1 user1 = new Q1(id);
			String id2 = getUserInput();
			Q1 user2 = new Q1(id2);
		} catch (BadIdInputException e) {
			System.out.println(e.getMessage());
		}
	}

}
