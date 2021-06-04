package ex.network;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class MessageClient {

	public static void main(String[] args) {
		
		Socket s = null;
		DataInputStream din = null;
		DataOutputStream dout = null;
		Scanner kb = new Scanner(System.in);
		
		try {
			s = new Socket("localhost", 8888);
			din = new DataInputStream(s.getInputStream());
			dout = new DataOutputStream(s.getOutputStream());
			
			String acceptMsg = null; // 
			String PushMsg = ""; // 
			
			while(!PushMsg.equals("exit")) {
				System.out.println("Server의 말을 기다리는 중 ...");
				acceptMsg = din.readUTF();
				System.out.println("Server Msg: "+acceptMsg);
				
				System.out.print("Client Msg :");
				PushMsg = kb.nextLine();
				dout.writeUTF(PushMsg);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			Util.close(s);
		}
	}

}
