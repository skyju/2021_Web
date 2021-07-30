package test;

import java.util.HashMap;

public class Test {

	public static void main(String[] args) {
		HashMap<String, Integer> map = new HashMap();
		
		map.put("", 123);
		map.put(null, 123);
		
		String nullString = null;
		String emptyString = "";
		
		boolean chk = nullString.equals(emptyString);
		
		System.out.println(chk);
	}

}
