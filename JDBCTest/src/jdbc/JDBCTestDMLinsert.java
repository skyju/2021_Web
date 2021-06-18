package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class JDBCTestDMLinsert {

	public static void main(String[] args) {
		
		//연결 객체: 연결 정보를 가진다.
		Connection con = null;
		//sql을 실행 할 메소드 제공
		Statement stmt = null;
		//excuteQuery() 반환타입 -> select의 결과(표)를 담는 객체
		ResultSet rs = null;
		//Statement를 상속하는 PreparedStatememt : 성능개선
		PreparedStatement pstmt = null;
		
		System.out.println("test start");
		try {
			// 1. 드라이버 로드 ,, build path설정 해놔야 함
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("드라이버 로드 성공!");
			
			// 2. 연결,, db실행중이어야 함
			String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "hr";
			String pw = "tiger";
			
			con = DriverManager.getConnection(jdbcUrl, user, pw);
			System.out.println("데이터베이스 연결 성공!");
			
			// transaction:
			// auto-commit이 default임, 설정하려면
			con.setAutoCommit(false);
			
			
			// 3. SQL처리
			// 사용자에게 정보를 받아 부서 데이터를 입력하는 프로그램을 만들어보자
			
			// (1). SQL 작성
			String sql = 
			"INSERT INTO DEPT01 VALUES (DEPT01_DEPTNO_SEQ.NEXTVAL, ?, ?)";
			
			// (2). PreparedStatement
			pstmt = con.prepareStatement(sql);
			
			Scanner scanner = new Scanner(System.in);
			System.out.println("부서 정보 입력을 시작합니다.");
			System.out.println("입력할 부서명을 입력해주세요.");
			String dname = scanner.nextLine();
			System.out.println("입력할 지역명을 입력해주세요.");
			String loc = scanner.nextLine();
			pstmt.setString(1, dname);
			pstmt.setString(2, loc);
				
			// (3). Result Set 객체로 데이터 받기
			int result = pstmt.executeUpdate();
			
			if(result > 0) {
				System.out.println("입력되었습니다.");
			} else {
				System.out.println("입력 실패했습니다.");
			}
			
			//트랜잭션 완료
			con.commit();
			System.out.println("커밋했습니다.");
			
			
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 클래스를 찾지 못함!");
			e.printStackTrace();
		} catch (SQLException e) {
			try {
				con.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			// 4. close
			try {
				if(con != null) {
					con.close();
				}
				if(stmt != null) {
					stmt.close();
				}
				if(pstmt != null) {
					pstmt.close();
				}
				if(rs != null) {
					rs.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
