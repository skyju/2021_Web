package ch11;

import java.util.*;

public class Q3 {

	public static void main(String[] args) {
		
		TreeSet<FootballPlayer> players = new TreeSet<FootballPlayer>();
		players.add(new FootballPlayer("손흥민", 7, "토트넘", 30));
		players.add(new FootballPlayer("디발라", 10, "유벤투스", 29));
		players.add(new FootballPlayer("케인", 10, "토트넘", 29));
		players.add(new FootballPlayer("손흥민", 7, "토트넘", 30));
		players.add(new FootballPlayer("어쩌고", 8, "토트넘", 24));
		players.add(new FootballPlayer("저쩌고", 12, "유벤투스", 28));
		players.add(new FootballPlayer("어쩌고", 2, "토트넘", 24));
		
		Iterator<FootballPlayer> itr = players.iterator();
		while(itr.hasNext()) {
			itr.next().showInfo();
		}
	}

}
