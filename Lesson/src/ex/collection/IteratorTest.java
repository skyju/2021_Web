package ex.collection;

import java.util.*;

public class IteratorTest {
	
	public static void main(String[] args) {
		
		//ArrayList <String> list = new ArrayList<String>();
		List<String> list = new ArrayList<String>();
		
		//요소 저장: add(T t)
		list.add("First");
		list.add("Second");
		list.add("Third");
		list.add("First");
		
		//일반 for문
		for(int i = 0 ; i < list.size() ; i++) {
			System.out.println(list.get(i));
		}
		System.out.println("---------------");
		
		//for each문
		for(String s : list) {
			System.out.println(s);
		}
		System.out.println("---------------");
		
		//iterator
		Iterator<String> itr = list.iterator();
		while(itr.hasNext()){
			String s = itr.next();
			System.out.println(s);
		}
		
	}

}
