package ch07;

import java.util.Calendar;

public class Person {
	
	private String name;
	private String idNum;
	int thisYear = Calendar.getInstance().get(Calendar.YEAR);
	private int BirthYear;
	private int age;
	private boolean sex;
	
	public Person() {
	}
	
	public Person(String name, String idNum) {
		this.name = name;
		this.idNum = idNum;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIdNum() {
		return idNum;
	}

	public void setIdNum(String idNum) {
		this.idNum = idNum;
	}

	public int getBirthYear() {
		return BirthYear;
	}

	public void setBirthYear(int birthYear) {
		BirthYear = birthYear;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public boolean isSex() {
		return sex;
	}

	public void setSex(boolean sex) {
		this.sex = sex;
	}
	
	void ageCal() {
		char[] a = idNum.toCharArray();
		if(a[6] == '1' || a[6] == '2') {
			BirthYear = 1900+((a[0]-48)*10+(a[1]-48));
		} else if(a[6] == '3' || a[6] == '4') {
			BirthYear = 2000+((a[0]-48)*10+(a[1]-48));
		} else {
			System.out.println("올바르지 않은 주민등록번호입니다.");
		}
		setAge(thisYear - BirthYear + 1);
	}
	
	void checkSex() {
		char[] a = idNum.toCharArray();
		if(a[6] == '2' || a[6] == '4') {
			setSex(true);
		} else if(a[6] == '1' || a[6] == '3'){
			setSex(false);
		} 
	}
	
	void hello() {
		if(getName() != null && getAge() != 0)
		System.out.println("안녕하세요. 저는"+getName()+"입니다. "+
				getAge()+"살 입니다.");
	}
}
