package ch13;
import java.io.*;
import java.util.*;

public class Q2 {
	
	static String exit = "";
	
	public static void main(String[] args) {
		
		Scanner kb = new Scanner(System.in);
		System.out.println("[알림] 파일 복사 프로그램을 실행합니다.");
		
		while(exit != "exit") {
			System.out.println("[입력] 복사할 파일의 경로를 입력해주세요"
					+ "\n      (확장자 명까지 입력해주세요.): ");
			
			//원본 파일 객체 생성
			File originFile = new File(kb.nextLine());
			
			if(!originFile.exists()) {
				System.out.println("[알림] 입력 된 경로에 원본 파일이 준비되어 있지 않습니다."
						+ "\n      다시 입력해주세요.");
				continue;
			}
			
			System.out.println("[입력] 파일을 옮길 새로운 경로를 입력해주세요");
			
			//새로운 경로 설정
			File newDir = new File(kb.nextLine());
			
			if(!newDir.exists()) {
				System.out.println("[알림] 올바르지 않은 경로입니다."
						+ "\n      다시 입력해주세요.");
				continue;
			}
			
			copyFileThread ct = new copyFileThread(originFile, newDir);
			ct.start();
		}
	}

}

class copyFileThread extends Thread {
	
	File originFile;
	File newDir;
	
	public copyFileThread(File a, File b) {
		originFile = a;
		newDir = b;
	}
	@Override
	public void run() {
		try {
			BufferedInputStream filtterInput = new BufferedInputStream
					(new FileInputStream(originFile));
			BufferedOutputStream filtterOutput = new BufferedOutputStream(
					new FileOutputStream(new File(newDir, originFile.getName()+"")));

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
			
			Scanner kb = new Scanner(System.in);
			System.out.print("[알림] 종료하려면 exit을, "
					+ "\n      계속 진행하시려면 복사할 파일의 경로를 입력해주세요.");
			Q2.exit = kb.nextLine();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	} 
}
