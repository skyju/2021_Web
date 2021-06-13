package ch13;

import java.util.*;
import javax.swing.JOptionPane;

public class Q1copy {
	
	public static boolean chk = false;
	public static boolean inputchk = false;
	
	public static void main(String[] args) {
		
		gameThread2 gt = new gameThread2();
		gt.start();
	}
}

class gameThread2 extends Thread {
	
	Random random = new Random();
	int correct = random.nextInt(99)+1; // 1~100사이의 랜덤 숫자를 정답으로 생성
	
	
	//맞췄다는 chk말고 입력여부 chk 변수를 만들어서
	//맞춰도 끝내고, 입력해도 thread가 종료할 수 있도록 
	
	@Override
	public void run() {
		Scanner kb = new Scanner(System.in);
		while(true) {
			try {
				Q1copy.inputchk = false;
				CountDownThread2 ct = new CountDownThread2();
				ct.start();
				int answer = Integer.parseInt(JOptionPane.showInputDialog("정답을 입력해주세요."));
				Q1copy.inputchk = true;
					if(answer <= 0 || answer >= 100) {
						throw new NumberFormatException();
					} else if(answer == correct) {
						System.out.println("정답입니다! 프로그램을 종료합니다.");
						System.exit(0);
					} else if (answer > correct) {
						System.out.println("정답보다 큰 숫자입니다.");
						continue;
					} else if (answer < correct) {
						System.out.println("정답보다 작은 숫자입니다.");
						continue;
					}
				Q1copy.chk = true;
			} catch (NumberFormatException e) {
				System.out.println("[경고] 정답은 1과 100 사이의 정수로만 입력해주세요.");
				System.exit(0);
			}
		}//while
	}//main
}

class CountDownThread2 extends Thread {
	
	@Override
	public void run() {
		System.out.println("[1~100] 사이의 숫자를 입력해주세요.");
		System.out.println("**10초 안에 값을 입력해야 합니다.**");
		for(int i = 10; i > 0 ; i--) {
			if(Q1copy.chk || Q1copy.inputchk) {
				return;
			}
			System.out.println("남은시간: "+ i+"초");
			try {
				CountDownThread2.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("입력시간이 지나 프로그램을 종료합니다.");
		System.exit(0);
	}
}