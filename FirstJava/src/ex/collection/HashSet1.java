package ex.collection;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class HashSet1 {

	public static void main(String[] args) {
		
		// HashSet 저장 공간 생성 : 
		// 인스턴스 저장, 
		// 중복 저장을 허용하지 않는다. 
		// 저장 순서를 저장하지 않는다.
		
		Set<SimpleNumber> hashSet = new HashSet<>();
		
		// 데이터 저장
		hashSet.add(new SimpleNumber(10));
		hashSet.add(new SimpleNumber(20));
		hashSet.add(new SimpleNumber(20));

		
		// 데이터의 일괄 처리
		//Iterator<String> itr = hashSet.iterator();
		Iterator<SimpleNumber> itr = hashSet.iterator();
		
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
		

	}

}

class SimpleNumber{
	
	int num;
	
	@Override
	public int hashCode() {
		return num%3; //0,1,2 > 3개의 그룹
	}

	@Override
	public boolean equals(Object obj) {
		
		boolean result = false; //기본값은 일단 틀린 것
		// obj는 null이 아니고 &&
		// obj는 형변환 될 수 있어야 함: SimpleNum
		if(obj != null && obj instanceof SimpleNumber) {
			SimpleNumber s = (SimpleNumber)obj;
			if(this.num == s.num) {
				result = true;
			}
		}
		return result;
	}

	SimpleNumber(int num){
		this.num = num;
	}
	
	public String toString() {
		return String.valueOf(num); //문자열로 변환
	}
	
}
