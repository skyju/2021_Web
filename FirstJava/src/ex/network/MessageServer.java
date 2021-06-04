package ex.network;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class MessageServer {

	public static void main(String[] args) {
		
		ServerSocket ss = null;
		Socket s = null;
		DataInputStream din = null;
		DataOutputStream dout = null;
				
		try {
			ss = new ServerSocket(8888);
			
			System.out.println("서버 실행");
			System.out.println("=================");
			
			s = ss.accept(); //만약 여기서 예외 발생하면, 아래 인스턴스 생성X, 여전히 null
							//그럼 close할 때 null을 어떻게 close?
			System.out.println("client 접속");
			System.out.println("=================");
			
			din = new DataInputStream(s.getInputStream());
			dout = new DataOutputStream(s.getOutputStream());
			
			Scanner kb = new Scanner(System.in);
			String acceptMsg = null; //받는 메세지
			String PushMsg = ""; //보내는 메세지
			
			while(!PushMsg.equals("exit")) {
				System.out.print("Server Msg :");
				PushMsg = kb.nextLine();
				dout.writeUTF(PushMsg);
				
				acceptMsg = din.readUTF();
				System.out.println("Client Msg :"+acceptMsg);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally { 
			Util.close(din);
			Util.close(dout);
			Util.close(ss);
			Util.close(s);
			
			//클래스로 따로 생성하면 static으로 만든다음 close 오버라이딩, 오버로딩해서 사용
			//아래는 모두 같은 exception이기 때문에 try안에 다 묶어도 되지만, 각각 exception이 다를 수 있음
			//그러나 보통 class로 따로 만들어 둔다음 사용한다.. (Util Class에 구현)
			
			//나중에 DB에 연결할 때도 close를 사용해야하는데, 나중에 framework 내에서 알아서 구현해 줌
			/*
			if(din != null) {
				try {
					din.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(dout != null) {
				try {
					dout.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(ss != null) {
				try {
					ss.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(s != null) {
				try {
					s.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			*/
		}
	}
}
