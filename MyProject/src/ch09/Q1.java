package ch09;

import ch07.*;

public class Q1 extends Person {
	
	public Q1(String name, String personNumber) {
		super(name, personNumber);
	}

	@Override
	public boolean equals(Object obj) {
		if(obj != null && obj instanceof Person) {
			if(this.personNumber.equals(((Person) obj).getPersonNumber())) {
				System.out.println("전에 저장한 사람과 같은 사람입니다.");
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	public static void main(String[] args) {
		System.out.println("================");
		Person person1 = new Q1("아무개", "8806081889566");
		person1.hello();
		System.out.println("================");
		Person person2 = new Q1("아무개", "8806081889566");
		person2.hello();
		
		person2.equals(person1);
		
	}
}
