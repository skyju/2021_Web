package array;

import java.util.Scanner;

public class Driver {
	
	public static void main(String[] args) {
		
		UserHandler handler = new UserHandler(100);
		
		Scanner kb = new Scanner(System.in);

		while (true) {
			printMenu();
			int menu = kb.nextInt();
			switch(menu) {
			case Menu.SAVE_INFO:
				handler.addInfo();
				break;
			case Menu.SHOW_INFO:
				handler.findInfo();
				break;
			case Menu.REMOVE_INFO:
				handler.removeInfo();
				break;
			case Menu.EXIT:
				System.out.println("종료합니다.");
				System.exit(0);
			default: 
				System.err.println("잘못된 번호입니다.");
			}
		}
	}
	
	public static void printMenu() {
        System.out.println( "\n===== <메뉴> =====" );
        System.out.println( Menu.SAVE_INFO+". 정보 저장" );
        System.out.println( Menu.SHOW_INFO+". 정보 출력" );
        System.out.println( Menu.REMOVE_INFO+". 정보 삭제" );
        System.out.println( Menu.EXIT+". 종료" );
        System.out.println( "=================" );
        System.out.print( ">> 메뉴 : " );
	}
}

interface Menu {
	int SAVE_INFO = 1;
	int SHOW_INFO = 2;
	int REMOVE_INFO = 3;
	int EXIT = 4;
}
