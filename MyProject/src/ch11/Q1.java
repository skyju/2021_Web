package ch11;

import java.util.*;

public class Q1 {

	public static void main(String[] args) {
		
		ArrayList<FootballPlayer> fList = new ArrayList<FootballPlayer>();
		fList.add(new FootballPlayer("손흥민", 7, "토트넘", 30));
		fList.add(new FootballPlayer("디발라", 10, "유벤투스", 29));
		fList.add(new FootballPlayer("케인", 10, "토트넘", 29));
		fList.add(new FootballPlayer("손흥민", 7, "토트넘", 30));
		
		Iterator<FootballPlayer> itr = fList.iterator();
		while(itr.hasNext()) {
			itr.next().showInfo();
		}
	}

}
