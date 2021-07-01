package project;

public class SavingFile extends Thread {
	SmartPhone sp;

	SavingFile(SmartPhone sp) {
		this.sp = sp;
	}
	public void run() {
		sp.savingFile();
	}	
}
