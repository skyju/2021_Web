package array;

public class UserInfo {
	String name;
	String phonNum;
	int birth;
	
	UserInfo(String name, String phonNum, int birth) {
		this.name = name;
		this.phonNum = phonNum;
		this.birth = birth;
	}
	
	void removeInfo(String name) {
		if(name.equals(this.name)) {
			System.out.println("정보를 삭제합니다.");
			
		}
	}
}
