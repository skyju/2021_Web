package ch09;

public class Q2 {
	public static void main(String[] args) {
		System.out.println(time());
	}
	
	public static long time() {
		long start = System.currentTimeMillis();
		int i = 0;
		for(int j = 1 ; j <= 10000000 ; j++) {
			i = j+i;
		}
		long end = System.currentTimeMillis();
		return end - start;
	}
}
