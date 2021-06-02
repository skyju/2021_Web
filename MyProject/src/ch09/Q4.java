package ch09;

import java.util.*;

public class Q4 {
	
	public static void main(String[] args) {
		Calendar today = Calendar.getInstance();
		Calendar birth = Calendar.getInstance();
		birth.set(1997, 1, 27);
		
		
		//방법1
		long difference = (today.getTimeInMillis()-birth.getTimeInMillis())
				/(1000L*60*60*24);
		System.out.println("태어난 후 지금까지"+difference+"일이 지났습니다.");
		
		
		//방법2
		int count = 0;
		while(!birth.after(today)) {
			count++;
			birth.add(Calendar.DATE, 1);
		}
		System.out.println("태어난 후 지금까지"+count+"일이 지났습니다.");
	}

}
