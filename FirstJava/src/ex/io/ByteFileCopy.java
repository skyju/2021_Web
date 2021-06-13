package ex.io;

//ctrl shift o 
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class ByteFileCopy {

	public static void main(String[] args) {
		try {
			//1. 파일을 바이너리 데이터로 읽어올 스트림 생성: FileInputStream
			InputStream input = new FileInputStream("origin.pdf");
			//2. 파일을 쓰기 위한 스트림 생성: FileOutputStream
			OutputStream output= new FileOutputStream("copy.pdf");
			
			// 카피한 데이터의 크기
			int copyByte = 0;
			int bData = -1;
			
			while(true) {
				bData = input.read();
				
				// 탈출의 조건 : 파일의 모든 데이터를 읽은 경우
				if(bData == -1) {
					break;
				}
				
				// 출력: 파일에 데이터를 쓴다
				output.write(bData);
				copyByte++;
			}
			// 스트림 닫기
			input.close();
			output.close();
			
			System.out.println("복사완료!! 복사된 바이트 사이즈 :"+copyByte+"byte");
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) { //얘가 더 상위타입
			e.printStackTrace();
		} 
	}

}
