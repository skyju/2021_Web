package ch10;

import java.util.*;

public class Q1 {
	
	String id;
	
	public String getUserInput() {
		Scanner kb = new Scanner(System.in);
		String input = kb.nextLine();
		return input;
	}
	
	public Q1(String id) throws BadIdInputException {
		this.id = id;
		if(id.equals("")) {
			throw new BadIdInputException("아이디를 입력받지 못했습니다.");
		} else {
			System.out.println("id: "+id+"가 성공적으로 생성되었습니다.");
		}
	}
	
	public static void main(String[] args) {
		try {
			Q1 user1 = new Q1("gksk1");
			Q1 user2 = new Q1("");
		} catch (BadIdInputException e) {
			System.out.println(e.getMessage());
		}
	}

}
