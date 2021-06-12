package project;

import java.util.*;

public class Driver {
	public static void main(String[] args) {
		
		SmartPhone sp = new SmartPhone(10);	
		Scanner kb = new Scanner(System.in);
	
		while (true) {
			try {
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
					System.out.println("잘못된 번호입니다.");
				}
			} catch(InputMismatchException e) {
				System.out.println("메뉴는 숫자로만 입력해주세요.");
				kb.nextLine(); 
				//버퍼 비우기 ??
				// nextInt는 공백을 못받기 때문에 \r을 받을 때까지 입력받음
				// 그러나 엔터는 \r\n이기 때문에, 버퍼에 \n이 남아있음.
				// 버퍼가 비어야 새로 입력받을 수 있기 때문에
				// \n을 입력받아 처리할 수 있는 nextLine으로 버퍼 비움	
			}
		}//while
	}//main
	
	public static void printMenu() {
		System.out.println();
        System.out.println( "=================" );
        System.out.println( "<연락처 관리 프로그램>" );
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