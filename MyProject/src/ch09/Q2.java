package ch09;

public class Q2 {
	public static void main(String[] args) {
		
		long start = System.currentTimeMillis();
		long sTime = System.nanoTime();
		System.out.println(sTime);
		
		long sum = 0;
		for(int j = 1 ; j <= 10000000 ; j++) {
			sum += j;
		}
		long end = System.currentTimeMillis();
		
		System.out.println("1~100,000,000 까지의 합은 "+sum+" 입니다.");
		System.out.println("1~100,000,000 까지의 합을 처리한 시간은 "+(end-start)+" ms 입니다.");
	}
}
