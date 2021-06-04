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

public class Q1 implements Serializable {
	
	public static void main(String[] args) {
		
		Calendar date = Calendar.getInstance();
		String year = date.get(Calendar.YEAR)+"년 ";
		String month = date.get(Calendar.MONTH)+"월  ";
		String day = date.get(Calendar.DATE)+"일";
		String todayString = "[작성 날짜] "+year+month+day;
		String header;
		String content;
		Scanner kb = new Scanner(System.in);
			
		File newFile = new File("D:"+File.separator+"memo");
		
		if(!newFile.exists()) {
			newFile.mkdir();
			System.out.println("폴더를 생성했습니다.");
		}
		
		try {
			System.out.println("메모장 쓰기 시작");
			String exit = "";
			while(!exit.equals("exit")) {
				System.out.print("제목을 입력해주세요: ");
				header = kb.nextLine();
				System.out.print("내용을 입력해주세요: ");
				content = kb.nextLine();
				BufferedWriter out = new BufferedWriter
						(new FileWriter(newFile+File.separator+header+".txt"));
				out.write(todayString+"\n제목: "+header+'\n'+"내용: "+content);
				out.close();
				System.out.println("나가고 싶으시면 exit을, 계속 메모를 쓰고 싶으시면 아무키나 입력해주세요.");
				exit = kb.nextLine();
			}
			System.out.println("쓰기 완료");
			
			System.out.println("메모장 읽기 시작");
			String exit2 = "";
			while(!exit2.equals("exit")) {
				System.out.println("파일의 제목을 입력해주세요.");
				header = kb.nextLine();
				
				BufferedReader in = new BufferedReader
						(new FileReader(newFile+File.separator+header+".txt"));
				
				String str = null;
				while(true) {
					str = in.readLine();
					if(str == null) {
						break;
					}
					System.out.println(str);
				}
				in.close();
				System.out.println("나가고 싶으시면 exit을, 계속 메모를 읽고 싶으시면 아무키나 입력해주세요.");
				exit2 = kb.nextLine();
			}
			System.out.println("메모장 읽기 완료");
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	
}
