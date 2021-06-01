package ch11;

import java.util.*;
import java.util.Map.*;

public class Q4 {

	public static void main(String[] args) {
		
		HashMap<Integer, FootballPlayer> fMap = new HashMap<>();

		fMap.put(7, new FootballPlayer("손흥민", 7, "토트넘", 30));
		fMap.put(10, new FootballPlayer("디발라", 10, "유벤투스", 29));
		fMap.put(10, new FootballPlayer("케인", 10, "토트넘", 29));
		fMap.put(7, new FootballPlayer("손흥민", 7, "토트넘", 30));
		fMap.put(8, new FootballPlayer("어쩌고", 8, "토트넘", 24));
		fMap.put(12, new FootballPlayer("저쩌고", 12, "유벤투스", 28));
		fMap.put(2 , new FootballPlayer("어쩌고", 2, "토트넘", 24));
		
		//Entry: key & value 쌍을 이용하여 enhanced for loop
		for(Entry<Integer, FootballPlayer> entry : fMap.entrySet()) {
			//entry중, 객체인 value만 가져오며, 객체 메서드 실행
			entry.getValue().showInfo();
		}
	}
}
