package array;

import java.util.Scanner;

class UserInfo {
	String name;
	String phonNum;
	int birth;
	
	UserInfo(String name, String phonNum, int birth) {
		this.name = name;
		this.phonNum = phonNum;
		this.birth = birth;
	}
	
	void findInfo(String name) {
		if(name.equals(this.name)) {
			System.out.println(
					 "  이름  : "+this.name
					+"\n전화번호: "+this.phonNum
					+"\n생년월일: "+this.birth);
		}
	}
}

public class Sample01 {
	
	public static String getUserInput() {
		Scanner kb = new Scanner(System.in);
		String input = kb.nextLine();
		return input;
	}
	
	public static void main(String[] args) {
		
		UserInfo[] userinfo = new UserInfo[100];
		for(int i = 0 ; i < 100 ; i ++) {
			printMenu();
			int menu = Integer.parseInt(getUserInput());
			switch(menu) {
			case 1:
				System.out.print("이름을 입력하세요 : ");
				String name = getUserInput();
				System.out.print("전화번호를 입력하세요 : ");
				String phoneNum = getUserInput();
				System.out.print("생년월일 6글자를 입력하세요 : ");
				int birth = Integer.parseInt(getUserInput());
				userinfo[i] = new UserInfo(name, phoneNum, birth);
				break;
			case 2:
				System.out.print("정보를 출력할 이름을 입력하세요: ");
				String name2 = getUserInput();
				try {
					for(int j = 0 ; j <= i ; j ++) {
						userinfo[j].findInfo(name2);
					}
				} catch(NullPointerException e) {
					System.out.print("");
				}
				continue;
			case 3:
				System.out.println("삭제할 데이터의 계정주 이름을 입력하세요: ");
				String name3 = getUserInput();
				try {
					for(int k = 0 ; k <= i ; k ++) {
						if(name3.equals(userinfo[k].name)) {
							for(int l = k ; l <= i ; l ++) {
								userinfo[k] = userinfo[k+1];
							}
						}
					}
				} catch(NullPointerException e) {
					System.out.print("");
				}
				continue;
			}
		}
	}
	public static void printMenu() {
        System.out.println( "\n===== <메뉴> =====" );
        System.out.println( " 1. 정보 저장" );
        System.out.println( " 2. 정보 출력" );
        System.out.println( " 3. 정보 삭제" );
        System.out.println( " 4. 종료" );
        System.out.println( "===================" );
        System.out.print( ">> 메뉴 : " );
	}

}
