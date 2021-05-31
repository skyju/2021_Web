package test3;

import java.util.*;

public class MyFriendInfoBook {

	public static void main(String[] args) {
		FriendInfoHandler handler = new FriendInfoHandler(10);
		
		while(true) {
			System.out.println("*** 메뉴 선택 ***");
			System.out.println(Menu.HIGH_FRI + ". 고교 정보 저장");
			System.out.println(Menu.UNIV_FRI + ". 대학 친구 저장");
			System.out.println(Menu.SHOW_ALL + ". 전체 정보 출력");
			System.out.println(Menu.SHOW_BASIC + ". 기본 정보 출력");
			System.out.println(Menu.EXIT + ". 프로그램 종료");
			System.out.println("**************");
			System.out.print("번호 선택>> ");
			
			Scanner scanner = new Scanner(System.in);
			int choice = Integer.parseInt(scanner.nextLine());
			
			switch (choice) {
			case Menu.HIGH_FRI: case Menu.UNIV_FRI: 
				handler.addFriend(choice);
				break;
			case Menu.SHOW_ALL:
				handler.showAllData();
				break;
			case Menu.SHOW_BASIC:
				handler.showAllSimpleData();
				break;
			case Menu.EXIT:
				System.out.println("프로그램을 종료합니다.");
				System.exit(0);
			default:
				System.out.println("잘못 입력하셨습니다.");
			}//switch
		}//while
	}//main
}

interface Menu {
	int HIGH_FRI = 1; //public static final 생략가능
	int UNIV_FRI = 2;
	int SHOW_ALL = 3;
	int SHOW_BASIC = 4;
	int EXIT = 5;
}
