package dept;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class DeptManager {

	private DeptDao dao;
	private Scanner kb;
	
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String user = "hr";
	private String password = "tiger";
	
	public DeptManager(DeptDao dao) {
		this.dao = dao;
		kb = new Scanner(System.in);
	}

	Connection connecting() {
		Connection con = null;
		try {
			con = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
	
	// 전체 리스트 출력 메소드
	// DAO에서 데이터 리스트를 받고 출력 처리
	void deptList() {
		Connection con = connecting();
		
		List<Dept> list = dao.getDeptList(con);
		
		System.out.println("부서 정보 리스트");
		System.out.println("-------------------------------");
		System.out.println("부서번호 \t 부서이름\t 부서위치");
		System.out.println("-------------------------------");
		
		for(Dept dept: list) {
			System.out.printf("%d \t %s \t %s \n",
					dept.getDeptno(),dept.getDname(),dept.getLoc());
		}
		System.out.println("-------------------------------");
	}
	
	// 데이터 입력
	// 사용자에게 scanner 클래스로 입력받아 > dao insertDept 메소드로 저장
	void deptInsert() {
		Connection con = connecting();
		
		System.out.println("부서 정보 입력을 시작합니다.");
		System.out.println("부서이름 부서위치 순으로 입력해주세요.");
		System.out.println("예) dev seoul");
		
		String datas = kb.nextLine();
		String[] data = datas.split(" ");
		Dept dept = new Dept(0, data[0], data[1]);
		
		int result = dao.insertDept(con, dept);
		if(result > 0) {
			System.out.println(result+"개의 행이 입력되었습니다.");
		} else {
			System.out.println("입력 실패했습니다.");
		}
	}

	// 데이터 수정
	void deptUpdate() {
		Connection con = connecting();
		
		System.out.println("부서 수정을 시작합니다.");
		System.out.println("수정하고자하는 부서번호와 새로운  부서이름, 새로운 부서위치 순으로 입력해주세요.");
		System.out.println("예) 50 dev seoul");
		
		String datas = kb.nextLine();
		String[] data = datas.split(" ");
		Dept dept = new Dept(Integer.parseInt(data[0]), data[1], data[2]);
		
		int result = dao.updateDept(con, dept);
		if(result > 0) {
			System.out.println(result+"개의 행을 업데이트 했습니다.");
		} else {
			System.out.println("수정 실패했습니다.");
		}
	}
	
	// 데이터 삭제
	void deptDelete() {
		Connection con = connecting();
		
		System.out.println("부서 삭제를 시작합니다.");
		System.out.println("삭제하고자하는 부서의 부서번호를 입력해주세요.");
		
		String data = kb.nextLine();		
		
		int result = dao.deleteDept(con, Integer.parseInt(data));
		if(result > 0) {
			System.out.println(result+"개의 행을 삭제 했습니다.");
		} else {
			System.out.println("삭제 실패했습니다.");
		}

	}
}
