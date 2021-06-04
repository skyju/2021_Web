package ex.network;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class MyClientSocket {
	public static void main(String[] args) {
		//Socket Server의 IP, Port Number를 통해 , 연결 신청 :Socket 객체를 생성
		try {
			Socket s = new Socket("localhost", 9999);
			// 예외가 발생하면, 서버가 없거나, 포트명이 틀렸거나 등등..
			
			if(s != null) {
				System.out.println("server 접속 완료");
			}
			
			DataOutputStream dout = new DataOutputStream(s.getOutputStream());
			dout.writeUTF("Hi!, from Client");
			System.out.println("msg 전송 완료");
			dout.flush();
			dout.close();
			s.close();
	
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
}
