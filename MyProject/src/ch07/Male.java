package ch07;

public class Male extends Person {
	
	private String hobby;
	public String getHobby() {
		return hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
	
	public Male() {}// 빈생성자	
	public Male(String name, String idNum, String hobby) {
		super(name, idNum);
		ageCal();
		checkSex();
		this.hobby = hobby;
	}
	public Male(String name, String idNum) {
		super(name, idNum);
		ageCal();
		checkSex();
	}
	
	void hello() {
		super.hello();
		if(!isSex()) {
			System.out.println("성별은 남성입니다.");
		}
		if(hobby != null) {
			System.out.println("취미는 "+getHobby()+"입니다.");
		}
	}
}
