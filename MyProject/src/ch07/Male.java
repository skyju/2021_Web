package ch07;

public class Male extends Person {
	
	public Male() {
	}
	
	public Male(String name, String idNum) {
		setName(name);
		setIdNum(idNum);
		ageCal();
		checkSex();
		hello();
	}
	
	void hello() {
		System.out.println(
				"안녕하세요. 저는"+getName()+"입니다.\n"+
				getAge()+"살 입니다.");
		if(!isSex()) {
			System.out.println("성별은 남성입니다.");
		}
	}
}
