package ch12;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Scanner;

public class Memo implements Serializable {
	
	public static void main(String[] args) {
		
		Calendar date = Calendar.getInstance();
		String today = "[작성 날짜]:" +date.get(Calendar.MONTH)+"월  "+date.get(Calendar.DATE)+"일";
		String header;
		String content;
			
		File newFile = new File("D:"+File.separator+"memo");
		
		if(!newFile.exists()) {
			newFile.mkdir();
			System.out.println("폴더를 생성했습니다.");
		}
		
		try {
			Scanner kb = new Scanner(System.in);
			System.out.println("메모장 쓰기 시작");
			String exit = "";
			while(!exit.equals("exit")) {
				System.out.print("제목을 입력해주세요: ");
				header = kb.nextLine();
				System.out.print("내용을 입력해주세요: ");
				content = kb.nextLine();
				BufferedWriter out = new BufferedWriter(new FileWriter(newFile+File.separator+header+".txt"));
				out.write(today+"\n제목: "+header+'\n'+"내용: "+content);
				out.close();
				System.out.println("나가고 싶으시면 exit을, 계속 입력하고 싶으시면 아무키나 입력해주세요.");
				exit = kb.nextLine();
			}
			System.out.println("쓰기 완료");
			
			System.out.println("읽고 싶은 파일의 제목을 입력해주세요.");
			header = kb.nextLine();
			BufferedReader in = new BufferedReader(new FileReader(newFile+File.separator+header+".txt"));
			
			String str = null;
			while(true) {
				str = in.readLine();
				if(str == null) {
					break;
				}
				System.out.println(str);
			}
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	
}
