package ch11;

import java.util.*;

public class Q2 {

	public static void main(String[] args) {
		
		HashSet<FootballPlayer> fSet = new HashSet<FootballPlayer>();
		fSet.add(new FootballPlayer("손흥민", 7, "토트넘", 30));
		fSet.add(new FootballPlayer("디발라", 10, "유벤투스", 29));
		fSet.add(new FootballPlayer("케인", 10, "토트넘", 29));
		fSet.add(new FootballPlayer("손흥민", 7, "토트넘", 30));
		
		Iterator<FootballPlayer> itr = fSet.iterator();
		while(itr.hasNext()) {
			itr.next().showInfo();
		}
	}

}
