package array;

import java.util.Scanner;

public class Driver {
	
	public static void main(String[] args) {
		
		UserHandler handler = new UserHandler(100);
		
		while (true) {
			printMenu();
			int menu = Integer.parseInt(getUserInput());
			switch(menu) {
			case Menu.SAVE_INFO:
				handler.addInfo();
				break;
			case Menu.SHOW_INFO:
				System.out.print("정보를 출력할 이름을 입력하세요: ");
				String name = getUserInput();
				handler.findInfo(name);
				break;
			case Menu.REMOVE_INFO:
				System.out.println("삭제할 데이터의 계정주 이름을 입력하세요: ");
				String name1 = getUserInput();
				handler.removeInfo(name1);
				break;
			case Menu.EXIT:
				System.out.println("종료합니다.");
				System.exit(0);
			}
		}
	}
	
	public static String getUserInput() {
		Scanner kb = new Scanner(System.in);
		String input = kb.nextLine();
		return input;
	}
	
	public static void printMenu() {
        System.out.println( "\n===== <메뉴> =====" );
        System.out.println( Menu.SAVE_INFO+" . 정보 저장" );
        System.out.println( Menu.SHOW_INFO+" . 정보 출력" );
        System.out.println( Menu.REMOVE_INFO+" . 정보 삭제" );
        System.out.println( Menu.EXIT+" . 종료" );
        System.out.println( "===================" );
        System.out.print( ">> 메뉴 : " );
	}
	
	interface Menu {
		int SAVE_INFO = 1;
		int SHOW_INFO = 2;
		int REMOVE_INFO = 3;
		int EXIT = 4;
	}
}
