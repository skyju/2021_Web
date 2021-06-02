package ex.file;

import java.io.File;

public class FileMove {

	public static void main(String[] args) {
		
//		File myFile = new File("D:\\myjava", "origin.pdf");
		File myFile = new File("D:\\myjava\\origin.pdf");
		
		if(!myFile.exists()) {
			System.out.println("원본 파일이 준비되어 있지 않습니다.");
			System.out.println("프로그램을 종료합니다.");
			return;
		}
		
		File newDir = new File("D:\\yourjava");
		System.out.println("1. exist ?:"+newDir.exists());
		
		if(!newDir.exists()) {
			//폴더 생성
			newDir.mkdir();
			System.out.println("2. exist ?:"+newDir.exists());
		}

		//이동할 경로와 파일 이름
		File newFile = new File(newDir, myFile.getName());
		//파일 이동
		myFile.renameTo(newFile);
		
		if(newFile.exists()) {
			System.out.println("파일 이동에 성공하였습니다.");
		} else {
			System.out.println("파일 이동에 실패하였습니다.");
		}
		
	}

}
