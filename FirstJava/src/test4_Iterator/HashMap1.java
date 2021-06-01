package test4_Iterator;

import java.util.*;

public class HashMap1 {
	public static void main(String[] args) {
		// Map : ket-value 형식으로 저장
		// Key : 저장한 데이터를 식별하기 위한 값, 중복X
		// Value : 저장하고자 하는 데이터
		
		
		HashMap<Integer, String> hMap = new HashMap<>();
		hMap.put(new Integer(3), "나삼번");
		hMap.put(5, "윤오번");
		hMap.put(8, "박팔번");
		
		
		System.out.println("8번 학생:"+hMap.get(new Integer(8)));
		
		System.out.println("5번 학생:"+hMap.get(5));
		
		System.out.println("3번 학생:"+hMap.get(3));
	
		hMap.remove(5); //5번 전학감
		
		System.out.println("5번 학생:"+hMap.get(5));
		
		
		
	}
}
