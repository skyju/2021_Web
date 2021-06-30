package project;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Driver {
	public static void main(String[] args) {
		
		SmartPhone sp = new SmartPhone();	
		Scanner kb = new Scanner(System.in);
	
		File newFolder = new File("C:"+File.separator+"Contact");
		if(!newFolder.exists()) {
			newFolder.mkdir();
			System.out.println("새 폴더를 생성했습니다.");
		}
		sp.loadingFile();
		
		while (true) {
			try {
				Show.printMenu();
				int menu = kb.nextInt();
				switch(menu) {
				case Menu.SAVE_INFO:
					sp.addInfo();
					break;
				case Menu.FIND_INFO:
					sp.findInfo();
					break;
				case Menu.UPDATE_INFO:
					sp.updateInfo();
					break;
				case Menu.REMOVE_INFO:
					sp.removeInfo();
					break;
				case Menu.SHOWUP_INFO:
					sp.showList();
					break;
				case Menu.REMOVE_ALL_INFO:
					sp.removeAllList();
					break;
				case Menu.SAVE_FILE:
					SavingFile sv = new SavingFile(sp);
					sv.start();
					break;
				case Menu.FILE_LOAD:
					LoadingFile ld = new LoadingFile(sp);
					ld.start();
					break;
				case Menu.EXIT:
					System.out.println("종료합니다.");
					System.exit(0);
				default: 
					System.out.println("잘못된 번호입니다.");
				}
			} catch(InputMismatchException e) {
				System.out.println("메뉴는 숫자로만 입력해주세요.");
				kb.nextLine(); 
			} catch (Exception e) {
				e.printStackTrace();
			}
		}//while
	}//main
}