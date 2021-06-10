package project;

import java.util.Scanner;

public class Driver {
	public static void main(String[] args) {
		
		SmartPhone sp = new SmartPhone(10);
		
		Scanner kb = new Scanner(System.in);

		while (true) {
			printMenu();
			int menu = kb.nextInt();
			switch(menu) {
			case Menu.SAVE_INFO:
				sp.addInfo();
				break;
			case Menu.FIND_INFO:
				sp.findInfo();
				break;
			case Menu.UPDATE_INFO:
				sp.updateInfo();
				break;
			case Menu.REMOVE_INFO:
				sp.removeInfo();
				break;
			case Menu.SHOWUP_INFO:
				sp.showList();
				break;
			case Menu.EXIT:
				System.out.println("종료합니다.");
				System.exit(0);
			default: 
				System.err.println("잘못된 번호입니다.");
			}
		}//while
	}//main
	
	public static void printMenu() {
        System.out.println( "\n===== <메뉴> =====" );
        System.out.println( Menu.SAVE_INFO+". 연락처 저장" );
        System.out.println( Menu.FIND_INFO+". 연락처 검색" );
        System.out.println( Menu.UPDATE_INFO+". 연락처 수정" );
        System.out.println( Menu.REMOVE_INFO+". 연락처 삭제" );
        System.out.println( Menu.SHOWUP_INFO+". 연락처 전체 보기" );
        System.out.println( Menu.EXIT+". 종료" );
        System.out.println( "=================" );
        System.out.print( ">> 메뉴 : " );
	}
}