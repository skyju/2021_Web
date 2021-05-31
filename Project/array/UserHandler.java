package array;

import java.util.*;

public class UserHandler {
	
	private UserInfo[] user;
	private int numOfUser;
	
	public UserHandler(int num) {
		user = new UserInfo[num];
		numOfUser = 0;
	}
	
	private void addUserInfo(UserInfo users) {
		user[numOfUser++] = users;
	}
	
	public void addInfo() {
		String name, phoneNum;
		int birth;
		Scanner kb = new Scanner(System.in);
		System.out.print("이름을 입력하세요 : ");
		name = kb.nextLine();
		System.out.print("전화번호를 입력하세요 : ");
		phoneNum = kb.nextLine();
		System.out.print("생년월일 6글자를 입력하세요 : ");
		birth = Integer.parseInt(kb.nextLine());
		addUserInfo(new UserInfo(name, phoneNum, birth));
	}
	
	public void findInfo(String name) {
		if(numOfUser > 0 ) {
			for(int i = 0 ; i < numOfUser ; i ++) {
				if(name.equals(user[i].name)) {
					System.out.println(
							 "  이름  : "+user[i].name
							+"\n전화번호: "+user[i].phonNum
							+"\n생년월일: "+user[i].birth);
				}
			}
		} else {
			System.out.println("저장된 정보가 없습니다.");
		}
	}
	
	public void removeInfo(String name) {
		if(numOfUser > 0 ) {
			for(int i = 0 ; i < numOfUser ; i++) {
				if(name.equals(user[i].name)) {
					for(int j = 0 ; j < i ; j++) {
					user[j] = user[j+1];
					}
					System.out.println("해당하는 정보를 삭제했습니다.");
				}
			}
		} else {
			System.out.println("저장된 정보가 없습니다.");
		}
	}
}
