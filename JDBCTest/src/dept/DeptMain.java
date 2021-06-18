package dept;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class DeptMain {

	public static void main(String[] args) {
		
		Connection con = null;
		Scanner kb = new Scanner(System.in);
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("드라이버 로드 성공");
			
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "hr";
			String password = "tiger";
			con = DriverManager.getConnection(url, user, password);
			System.out.println("데이터 베이스 연결 성공");			
			DeptDao dao = DeptDao.getInstance();
			
			System.out.println("1. 전체 부서 정보 출력");
			System.out.println("2. 새로운 부서 정보 입력");
			System.out.println("3. 기존 부서 정보 수정");
			System.out.println("4. 기존 부서 정보 삭제");
			String menu = kb.nextLine();
			
			switch(Integer.parseInt(menu)) {
			case 1: // select 
				ArrayList<Dept> list = dao.getDeptList(con);
				for(Dept dept : list) {
					System.out.println(dept);
				}
				break;
			case 2: // insert
				System.out.println("부서 입력을 시작합니다.");
				System.out.println("부서번호 부서이름 부서위치 순으로 입력해주세요.");
				System.out.println("예) 50 dev seoul");
				String deptData = kb.nextLine();
				String[] deptDatas = deptData.split(" ");
				
				Dept dept = new Dept(Integer.parseInt(deptDatas[0]), 
						deptDatas[1], deptDatas[2]);
				
				int result1 = dao.insertDept(con, dept);
				if(result1 > 0) {
					System.out.println(result1+"개의 행이 입력되었습니다.");
				} else {
					System.out.println("입력 실패했습니다.");
				}
				break;
			case 3: // update
				System.out.println("부서 수정을 시작합니다.");
				System.out.println("수정하고자하는 부서번호와 새로운  부서이름, 새로운 부서위치 순으로 입력해주세요.");
				System.out.println("예) 50 dev seoul");
				String deptData2 = kb.nextLine();
				String[] deptDatas2 = deptData2.split(" ");
				
				Dept dept2 = new Dept(Integer.parseInt(deptDatas2[0]), 
						deptDatas2[1], deptDatas2[2]);
				
				int result2 = dao.updateDept(con, dept2);
				if(result2 > 0) {
					System.out.println(result2+"개의 행을 업데이트 했습니다.");
				} else {
					System.out.println("수정 실패했습니다.");
				}
				break;
			case 4: // delete
				System.out.println("부서 삭제를 시작합니다.");
				System.out.println("삭제하고자하는 부서의 부서번호를 입력해주세요.");
				String deptData3 = kb.nextLine();		
				int result3 = dao.deleteDept(con, Integer.parseInt(deptData3));
				if(result3 > 0) {
					System.out.println(result3+"개의 행을 삭제 했습니다.");
				} else {
					System.out.println("삭제 실패했습니다.");
				}
				break;
			default:
				System.out.println("잘못된 입력입니다.");
			} //switch
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassCastException e) {
			e.printStackTrace();
		}
	} //main

}
