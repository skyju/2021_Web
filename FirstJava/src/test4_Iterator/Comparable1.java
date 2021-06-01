package test4_Iterator;

import java.util.*;

class Person implements Comparable<Person> {
	
	String name;
	int age; 
	
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	public void showData() {
		System.out.printf("%s,%d\n",this.name, this.age);
	}
	
	@Override
	public int compareTo(Person o) {
//		if(this.age > o.age) {
//			return 1;
//		} else if (this.age < o.age) {
//			return -1;
//		} else {
//			return 0;	
//		}		
		return (this.age - o.age)*-1;
	}
	
}

public class Comparable1 {
	public static void main(String[] args) {
		TreeSet<Person> p = new TreeSet<Person>();
		p.add(new Person("Lee", 24));
		p.add(new Person("Hong", 29));
		p.add(new Person("Choi", 21));
		
		Iterator<Person> itr =  p.iterator();
		while(itr.hasNext()) {
			itr.next().showData();
		}
		
		
	}

}
