package ex.collection;

import java.util.*;

public class TreeSet1 {

	public static void main(String[] args) {

		//TreeSet: TreeAlgorithm 이용하여 저장
		// 정렬(오름차순, 내림차순), 기준은 프로그래머 정의 가능
		
		TreeSet<Integer> treeSet = new TreeSet<Integer>();
		
		//데이터 저장
		treeSet.add(1);
		treeSet.add(5);
		treeSet.add(4);
		treeSet.add(2);
		treeSet.add(1);
		treeSet.add(3);
		
		
		Iterator<Integer> itr = treeSet.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
		
		
	}

}
