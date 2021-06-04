package ex.network;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class MyServerSocket {

	public static void main(String[] args) {
		try {
			ServerSocket ss = new ServerSocket(9999);
			System.out.println("서버 실행! ");
			Socket s = ss.accept(); //Socket에서 연결 요청이 올 때까지 대기
			
			if(s != null) {
				System.out.println("클라이언트의 접속 요청: Socket 생성");
			}
			
			DataInputStream din = new DataInputStream(s.getInputStream());
			String msg = din.readUTF();
			System.out.println(msg);
			
			ss.close();
			s.close();
			din.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
