package test3;

import java.util.*;

public class FriendInfoHandler {
	
	// 2021-05_31
	// 배열 > 컬렉션
	// private Friend[] friends;
	// private int numOfFriends;// 배열의 index, 정보 갯수, 카운트 될 것임
	// ArrayList가 기능을 다 해주기 때문에 count용 정수 필요없음
	
	ArrayList<Friend> friends;
	
	public FriendInfoHandler(int num) {
		friends = new ArrayList<Friend>(num);
	}
	
	private void addFriendInfo(Friend fren) {
		// 배열에 요소 추가 
		// friends[numOfFriends++] = fren;
		
		// 컬랙션 : List에 요소 추가
		friends.add(fren);
		System.out.println("정보가 저장되었습니다.");
		System.out.println("------------------");
	}
	
	// 사용자로부터 친구의 정보를 입력받아서 인스턴스 생성, 배열에 저장
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
	}
	
	public void showAllData() {
		System.out.println("------------------");
		System.out.println("친구의 정보를 출력합니다.");
		System.out.println("------------------");
		// 2021-05-31: 수정
		// 요소의 저장방식이 배열 > 컬렉션 : 반복문 수정
		if(friends.size() > 0) {
			for(int i = 0 ; i < friends.size() ; i++) {
				//friends[i].showInfo();
				friends.get(i).showInfo();
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
		if(!friends.isEmpty()) { // 비었으면 true가 나오므로 부정해줘야함
			for(int i = 0 ; i < friends.size() ; i++) {
				//friends[i].showBasicInfo();
				friends.get(i).showBasicInfo();
				System.out.println();
			}
		} else {
			System.out.println("입력된 정보가 없습니다.");
			System.out.println("------------------");
		}
	}
}
