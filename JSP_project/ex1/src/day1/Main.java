package day1;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		int A = kb.nextInt();
		int B = kb.nextInt();
		int C = kb.nextInt();
		
		int result = A*B*C;
		int[] arr = new int[10];
		
		// arr[0]에는 0의 개수가 들어가도록 
		
		while(result>0) {
			arr[result%10]++;
			result/=10;
		}
		
		for(int i = 0 ; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
		
		System.out.println();
		
		int result2 = A*B*C;
		
		String resultStr = String.valueOf(result2);
		for (int i = 0; i < 10; i++) {
			int count = 0;
			for (int j = 0; j < resultStr.length(); j++) {
				if (resultStr.charAt(j)-'0' == i) {
					count++;
				}
			}
			System.out.println(count);
		}
	}

}
