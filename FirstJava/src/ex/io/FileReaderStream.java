package ex.io;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class FileReaderStream {
	public static void main(String[] args) {
		//문자 단위로 읽어올 스트림 생성
		//Reader -> FileReader
		
		try {
			System.out.println("읽기 시작");
			Reader in = new FileReader("hyper.txt");
			
			char[] cbuf = new char[10];
			int readLen = 0;
			
			readLen = in.read(cbuf, 0, cbuf.length);
			
//			for(int i = 0 ; i < readLen ; i++) {
//				System.err.println(cbuf[i]);
//			}
			System.out.println(new String(cbuf)); //toString()
			
			in.close();
			System.out.println("읽기 완료");
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
