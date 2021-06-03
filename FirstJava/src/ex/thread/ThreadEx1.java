package ex.thread;

import javax.swing.*;

public class ThreadEx1 {
	
	public static boolean chk = false;
	
	public static void main(String[] args) {
		
		CountDownThread ct = new CountDownThread();
		InputThread it = new InputThread();
		it.start();
		ct.start();
		
		
	}

}
class InputThread extends Thread {
	public void run() {
		System.out.println("10초 안에 값을 입력해야 합니다.");
		
		//Swing 컴퍼런트
		String name = JOptionPane.showInputDialog("이름을 입력해주세요.");
		ThreadEx1.chk = true;
		System.out.println("안녕하세요. "+name+"님.");
	}
}


class CountDownThread extends Thread {

	@Override
	public void run() {
		for(int i = 10; i > 0 ; i--) {
			if(ThreadEx1.chk) {
				return;
			}
			System.out.println(i);
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
