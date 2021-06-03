package ch13;

import java.util.*;

public class Q1 {
	
	public static boolean chk = false;
	
	public static void main(String[] args) {
		
		CountDownThread ct = new CountDownThread();
		gameThread gt = new gameThread();
		gt.start();
		ct.start();
	
	}
}

class gameThread extends Thread {
	
	int min=1;
	int max=100;
	Random random = new Random();
	int correct = random.nextInt(99)+1; // 1~100사이의 랜덤 숫자를 정답으로 생성
	
	@Override
	public void run() {
		Scanner kb = new Scanner(System.in);
		while(true) {
			try {
			System.out.println("정답은? : ");
			int answer = kb.nextInt();
				if(answer <= 0 || answer >= 100) {
					throw new InputMismatchException();
				} else if(answer == correct) {
					System.out.println("정답입니다! 프로그램을 종료합니다.");
					kb.close();
					System.exit(0);
				} else if (answer > correct) {
					System.out.println("정답보다 큰 숫자입니다.");
					continue;
				} else if (answer < correct) {
					System.out.println("정답보다 작은 숫자입니다.");
					continue;
				}
				Q1.chk = true;
			} catch (InputMismatchException e) {
				System.out.println("[경고] 정답은 1과 100 사이의 정수로만 입력해주세요.");
				System.exit(0);
			} 
		}
	}
}


class CountDownThread extends Thread {

	@Override
	public void run() {
		System.out.println("[1~100] 사이의 숫자를 입력해주세요.");
		System.out.println("**10초 안에 값을 입력해야 합니다.**");
		for(int i = 10; i > 0 ; i--) {
			if(Q1.chk) {
				System.exit(0);
			}
			System.out.println("              남은시간: "+ i+"초");
			try {
				CountDownThread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("입력시간이 지나 프로그램을 종료합니다.");
		System.exit(0);
	}
	
}