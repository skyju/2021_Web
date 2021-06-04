package ex.network;

import java.net.MalformedURLException;
import java.net.URL;

public class URLTest {

	public static void main(String[] args) {
		String urlStr = "https://sports.news.naver.com/news.nhn?oid=421&aid=0005392894";
		
		try {
			URL url = new URL(urlStr); //기존 url, spec(보통 parameter)을 붙여서 만들기도함
			//data를 받아올 때, server에서 받아오는 값을 기본 url로 만들 때 위처럼 사용 (ex, 날씨 data 받기)
			System.out.println("Protocol: "+url.getProtocol());
			System.out.println("Host Name: "+url.getHost());
			System.out.println("Authority: " +url.getAuthority());
			System.out.println("Port Num: "+url.getPort());
			System.out.println("Defalt Port: "+url.getDefaultPort());
			System.out.println("Query: "+url.getQuery());
			System.out.println("Path: "+url.getPath()); // /까지 들어옴
			System.out.println("File: "+url.getFile()); // /까지 들어옴


			
			
			
		} catch (MalformedURLException e) {
			//url format에 맞지 않으면 예외가 발생함
			e.printStackTrace();
		}
		
	}

}
