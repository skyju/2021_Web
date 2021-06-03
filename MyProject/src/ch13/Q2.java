package ch13;
import java.io.*;
import java.util.*;

public class Q2 {
	
	static File originFile;
	static File newDir;
	
	public static void main(String[] args) {
		
		System.out.println("[알림] 파일 복사 프로그램을 실행합니다.");
		Scanner kb = new Scanner(System.in);
		
		System.out.println("[입력] 복사할 파일의 경로를 입력해주세요"
				+ "\n(확장자 명까지 입력): ");
		String originPath = kb.nextLine();
		
		//원본 파일 객체 생성
		originFile = new File(originPath);
		
		if(!originFile.exists()) {
			System.out.println("[알림] 입력 된 경로에 원본 파일이 준비되어 있지 않습니다.");
			System.out.println("      프로그램을 종료합니다.");
			return;
		}
		
		
		System.out.println("[입력] 파일을 옮길 새로운 경로를 입력해주세요"
				+ "\n(대상 폴더가 없을 시, 자동으로 생성됩니다.) ");
		String newPath = kb.nextLine();
	
		newDir = new File(newPath);
		if(!newDir.exists()) {
			newDir.mkdir();
			System.out.println("[알림] 대상 경로에 폴더가 존재하지 않아 새로운 폴더를 생성했습니다.");
		}
		
		copyFileThread ct = new copyFileThread();
		ct.start();
	}

}

class copyFileThread extends Thread {
	
	@Override
	public void run() {
		try {
			BufferedInputStream filtterInput = new BufferedInputStream
					(new FileInputStream(Q2.originFile));
			BufferedOutputStream filtterOutput = new BufferedOutputStream(
					new FileOutputStream(Q2.newDir));

			int copyByteSize = 0;
			int bData = -1;
			
			while(true) {
				bData = filtterInput.read();
				
				if(bData == -1) {
					break;
				}
	
				filtterOutput.write(bData);
				copyByteSize++;
			}
			
			filtterInput.close();
			filtterOutput.close();
			
			System.out.println("[알림] 복사완료!"
					+ "\n      복사된 바이트 사이즈 :"+copyByteSize+" byte");
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	} 
}
