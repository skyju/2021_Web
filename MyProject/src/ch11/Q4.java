package ch11;

import java.util.*;
import java.util.Map.*;

public class Q4 {

	public static void main(String[] args) {
		
		HashMap<Integer, FootballPlayer> players = new HashMap<>();
		players.put(7, new FootballPlayer("손흥민", 7, "토트넘", 30));
		players.put(10, new FootballPlayer("디발라", 10, "유벤투스", 29));
		players.put(10, new FootballPlayer("케인", 10, "토트넘", 29));
		players.put(7, new FootballPlayer("손흥민", 7, "토트넘", 30));
		players.put(8, new FootballPlayer("어쩌고", 8, "토트넘", 24));
		players.put(12, new FootballPlayer("저쩌고", 12, "유벤투스", 28));
		players.put(2 , new FootballPlayer("어쩌고", 2, "토트넘", 24));
		
		//<방법1>
		//Entry: key & value 쌍을 이용하여 enhanced for loop
		for(Entry<Integer, FootballPlayer> entry : players.entrySet()) {
			//entry중, 객체인 value만 가져오며, 객체 메서드 실행
			entry.getValue().showInfo();
		}
		
	
		System.out.println("-------------------");
		//<방법2>
		// Map은 Collection을 implements하는 class가 아니기 때문에
		// iterator를 사용하려면 Set으로 번저 변환 해야 함.
		Set<Integer> set  = players.keySet();
		//.keySet 이용
		
		Iterator<Integer> itr = set.iterator();
		while(itr.hasNext()) {
			System.out.println(players.get(itr.next()));
		}
		
	}
}
