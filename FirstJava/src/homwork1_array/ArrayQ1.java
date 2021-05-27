package homwork1_array;

import java.util.*;

public class ArrayQ1 {
	
	public static String getUserInput() {
		Scanner scanner = new Scanner(System.in);
		String input = scanner.nextLine();
		return input;
	}
	
	public static int minValue(int[] arr) {
		int min = arr[0];
		for(int i = 0 ; i < arr.length ; i ++) {
			if(min > arr[i]) {
				min = arr[i];
			}
		}
		return min;
	}
	
	public static int maxValue(int[] arr) {
		int max = arr[0];
		for(int i = 0 ; i < arr.length ; i ++) {
			if(max < arr[i]) {
				max = arr[i];
			}
		}
		return max;
	}
	
	public static void main(String[] args) {
		
		System.out.println("정수를 입력해주세요.");
		int[] arr = new int[5];
		arr[0] = Integer.parseInt(getUserInput());
		arr[1] = Integer.parseInt(getUserInput());
		arr[2] = Integer.parseInt(getUserInput());
		arr[3] = Integer.parseInt(getUserInput());
		arr[4] = Integer.parseInt(getUserInput());
		
		int min = minValue(arr);
		int max = maxValue(arr);
		
		System.out.println("최소값은"+min+","+"최대값은"+max);
		
	}

}
