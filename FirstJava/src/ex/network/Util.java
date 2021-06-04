package ex.network;

import java.io.FilterInputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Util {
	
	// 메서드만 사용할거니까 <-> 내생각은 매개변수로 넣는거면 생성자를 일일히 만들어야하지만, 그러지말고
	// static으로 만들면 메서드만 간단히 오버라이딩 & 오버로딩 하면 됨 
	public static void close(ServerSocket ss) {
		if(ss != null) {
			try {
				ss.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void close(Socket s) {
		if(s != null) {
			try {
				s.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	//DataInputStream 은 filtterStream의 상속관계, inputStream인터페이스의 상속관계가 아님
	//filter랑 기본 스트림은 상속구조가 다르기 때문에 -> 자세한 것은 API 찾아볼 것
	public static void close(FilterInputStream fin) {
		if(fin != null) {
			try {
				fin.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void close(FilterOutputStream fout) {
		if(fout != null) {
			try {
				fout.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
