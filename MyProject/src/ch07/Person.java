package ch07;

import java.util.Calendar;

public class Person {
	String name;
	String idNum;
	int thisYear;
	int BirthYear;
	int age;
	char[] a = idNum.toCharArray();
	
	void ageCal() {
		thisYear = Calendar.getInstance().get(Calendar.YEAR);
		BirthYear = 1900+(a[0]-48)*10+(a[1]-48);
		age = thisYear - BirthYear + 1;
	}
	
	void hello() {
		System.out.println("안녕하세요. 저는"+name+"입니다."+
				age+"살 입니다.");
	}
}
