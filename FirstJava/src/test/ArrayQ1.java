package test;

import java.util.Scanner;

public class ArrayQ1 {
	
	public static String getUserInput() {
		Scanner scanner = new Scanner(System.in);
		String input = scanner.nextLine();
		return input;
	}
	
	public static int minValue(int[] arr) {
		for(int j = 0 ; j < arr.length ; j ++) {
			for(int i = 0 ; i < arr.length-1 ; i ++) {
				int temp = 0;
				if(arr[i] > arr[i+1]) {
					temp = arr[i];
					arr[i] = arr[i+1];
					arr[i+1] = temp;
				}		
			}
		}
		return arr[0];
	}
	
	public static int maxValue(int[] arr) {
		boolean sorted = false;
		while(!sorted) {
			sorted = true;
			for(int i = 0 ; i < arr.length-1 ; i ++) {
				int temp = 0;
				if(arr[i] < arr[i+1]) {
					temp = arr[i];
					arr[i] = arr[i+1];
					arr[i+1] = temp;
					sorted =false;
				}		
			}
		}
		return arr[0];
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
