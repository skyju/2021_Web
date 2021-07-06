package project;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		int[] elements = new int[9];
		for(int i = 0 ; i < 9 ; i++) {
			elements[i] = kb.nextInt();	
		}
		int chk = 0;
		int max = elements[0];
		for (int i = 0; i < elements.length; i++) {
			if (elements[i] >= max) {
				max = elements[i];
				chk = i+1;
			}
		}
		System.out.println(max);
		System.out.println(chk);
	}
}
