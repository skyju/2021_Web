package ex.thread;

public class ShowThread extends Thread implements Runnable {

	String threadName;
	public ShowThread(String name) {
		threadName = name;
	}
	
	public void run() {
		for(int i = 0 ; i < 100 ; i ++) {
			System.out.println(threadName);
			try {
				sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
