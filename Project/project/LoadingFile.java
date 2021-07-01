package project;

public class LoadingFile extends Thread {
	SmartPhone sp;

	LoadingFile(SmartPhone sp) {
		this.sp = sp;
	}

	public void run() {
		sp.loadingFile();
	}
}
