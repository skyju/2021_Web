package test2;

import java.util.*;

public class FriendInfoHandler { // 데이터(객체)를 배열로 저장하고, 관리하는 기능
	
	private Friend[] myFriends;
	private int numOfFriends; // 배열의 index, 정보 갯수, 카운트 될 것임
	
	public FriendInfoHandler(int num) { //num은 배열의 사이즈 > 인스턴스 생성
		myFriends = new Friend[num];
		numOfFriends = 0; //? 0에서 시작해야 add할 때마다 카운트가 올라가지
	}
	
	private void addFriendInfo(Friend fren) {
		myFriends[numOfFriends++] = fren;
	}
	
	//사용자로부터 친구의 정보를 입력받아서 인스턴스 생성, 배열에 저장
	public void addFriend(int choice) {// 1 고교 2 대학
		String name, phoneNum, address, job, major;
		Scanner scanner = new Scanner(System.in);
		System.out.println("정보를 입력해주세요.");
		System.out.print("이   름: ");
		name = scanner.nextLine();
		System.out.print("전화 번호: ");
		phoneNum = scanner.nextLine();
		System.out.print("주   소: ");
		address = scanner.nextLine();
		
		if(choice == 1) {
			System.out.print("직   업: ");
			job = scanner.nextLine();
			addFriendInfo(new HighFriend(name, phoneNum, address, job));
		} else {
			System.out.print("전   공: ");
			major = scanner.nextLine();
			addFriendInfo(new UnivFriend(name, phoneNum, address, major));
		}
		System.out.println("입력 완료!\n");
		
	}
	
	public void showAllData() {
		System.out.println("------------------");
		System.out.println("친구의 정보를 출력합니다.");
		System.out.println("------------------");
		if(numOfFriends > 0) {
			for(int i = 0 ; i < numOfFriends ; i++) {
				myFriends[i].showData();
				System.out.println("------------------");
			}
		} else {
			System.out.println("입력된 정보가 없습니다.");
			System.out.println("------------------");
		}
	}
	
	public void showAllSimpleData() {
		System.out.println("------------------");
		System.out.println("친구의 기본 정보를 출력합니다.");
		System.out.println("------------------");
		if(numOfFriends > 0) {
			for(int i = 0 ; i < numOfFriends ; i++) {
				myFriends[i].showBasicInfo();
				System.out.println();
			}
		} else {
			System.out.println("입력된 정보가 없습니다.");
			System.out.println("------------------");
		}
	}
}
