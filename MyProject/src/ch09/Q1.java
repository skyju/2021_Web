package ch09;

import ch07.*;

public class Q1 extends Person {
	
	public Q1(String name, String personNumber) {
		super(name, personNumber);
	}
	
	public void isEquals(Person person) {
		if(this.personNumber.equals(person.getPersonNumber())) {
			System.out.println("같은 사람입니다.");
		}
	}
	
	public static void main(String[] args) {
		System.out.println("================");
		Person person1 = new Q1("아무개", "8806081889566");
		person1.hello();
		System.out.println("================");
		Person person2 = new Q1("아무개", "8806081889566");
		person2.hello();
		
		person2.isEquals(person1);
		
	}
}
