package dept;

import java.util.Scanner;

public class DeptMain {

	public static void main(String[] args) {
		
		DeptManager manager = new DeptManager(DeptDao.getInstance());
		
		try {
			// 1. 드라이버 로드
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			Scanner kb = new Scanner(System.in);
			System.out.println("1. 전체 부서 정보 출력");
			System.out.println("2. 새로운 부서 정보 입력");
			System.out.println("3. 기존 부서 정보 수정");
			System.out.println("4. 기존 부서 정보 삭제");
			String menu = kb.nextLine();
			
			switch(Integer.parseInt(menu)) {
			case 1: 
				manager.deptList();
				break;
			case 2:
				manager.deptInsert();
				break;
			case 3:
				manager.deptUpdate();
				break;
			case 4:
				manager.deptDelete();
				break;
			default:
				System.out.println("잘못된 입력입니다.");
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	} //main

}
