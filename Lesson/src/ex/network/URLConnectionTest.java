package ex.network;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class URLConnectionTest {
	public static void main(String[] args) {
		
		try {
			URL url = new URL("https://www.google.com"); 
			// 도메인으로 들어오면 www.google.com/index.html로 가도록 되어있음 
			// 즉 자원을 찾아가도록 되어 있다.
			
			// URLConnection : url.openConnection();
			URLConnection urlc = url.openConnection();
			// 파일과 연결이 되었다 > 스트림이 만들어졋다 > IOException 발생
			
			InputStream in = urlc.getInputStream();
			int i; 
			while(true) {
				i = in.read();
				if(i == -1) {
					break;
				}
				System.out.print((char)i);
			}
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
