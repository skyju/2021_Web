package project;

import java.util.Scanner;

public class Driver {
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		System.out.println("이름을 입력해주세요: ");
		String name1 = kb.nextLine();
		System.out.println("전화번호를 입력해주세요: ");
		String phoneN1 = kb.nextLine();
		System.out.println("이메일을 입력해주세요: ");
		String email1 = kb.nextLine();
		System.out.println("주소를 입력해주세요: ");
		String address1 = kb.nextLine();
		System.out.println("생년월일을 입력해주세요: ");
		String birth1 = kb.nextLine();
		System.out.println("그룹을 입력해주세요: ");
		String group = kb.nextLine();
		Contact c = new Contact(name1, phoneN1, email1, address1, 
				birth1, group);
		
		System.out.println(c);
	}
}
