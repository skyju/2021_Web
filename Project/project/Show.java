package project;

public class Show {
	public static void printMenu() {
		System.out.println();
        System.out.println( "=================" );
        System.out.println( "<연락처 관리 프로그램>" );
        System.out.println( Menu.SAVE_INFO+". 연락처 저장" );
        System.out.println( Menu.FIND_INFO+". 연락처 검색" );
        System.out.println( Menu.UPDATE_INFO+". 연락처 수정" );
        System.out.println( Menu.REMOVE_INFO+". 연락처 삭제" );
        System.out.println( Menu.SHOWUP_INFO+". 연락처 전체 보기" );
        System.out.println( Menu.REMOVE_ALL_INFO+". 연락처 전체 삭제");
        System.out.println( Menu.SAVE_FILE+". 파일 저장");
        System.out.println( Menu.FILE_LOAD+". 파일 로드");
        System.out.println( Menu.EXIT+". 종료" );
        System.out.println( "=================" );
        System.out.print( ">> 메뉴 : " );
	}
}

