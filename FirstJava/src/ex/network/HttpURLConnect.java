package ex.network;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class HttpURLConnect {

	public static void main(String[] args) {
		String urlStr = "https://sports.news.naver.com/news.nhn?oid=343&aid=0000105513";
		
		try {
			URL url = new URL(urlStr);
			
			//HttpURLConnection: url.openConnection(); 이용 
			HttpURLConnection hcon = (HttpURLConnection)(url.openConnection());
			
			for(int i = 1 ; i <= 8 ; i++) { //key 8까지만
				System.out.print(hcon.getHeaderFieldKey(i));
				System.out.println(" : "+hcon.getHeaderField(i));
			}
			hcon.disconnect();
			
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	
	}

}
