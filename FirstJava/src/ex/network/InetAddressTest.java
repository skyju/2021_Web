package ex.network;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressTest {
	public static void main(String[] args) {
		
		String urlStr = "www.bitcamp.co.kr";
		
		try {
			InetAddress ip = InetAddress.getByName(urlStr);
			
			// 보안 때문에 약속된 주소를 쓰기 때문에, 잘 사용하지 않지만
			
			// 1) IP를 알고 있을 때, 도메인을 알고 싶다면
			System.out.println("호스트 이름: "+ip.getHostName());
			
			// 2) 도메인을 알고 있을 때, IP를 알고 싶다면
			System.out.println("IP address: "+ip.getHostAddress());
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}
}
