package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCTestEmp {

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
			// 1. 드라이버 로드
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("드라이버 로드 성공!");
			
			// 2. 연결
			String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "hr";
			String pw = "tiger";
			
			con = DriverManager.getConnection(jdbcUrl, user, pw);
			System.out.println("데이터베이스 연결 성공!");
			
			// 3. SQL처리
			// 사원 번호, 사원 이름, 직급, 연봉, 부서이름, 부서위치
			
			// (1). Statement
				stmt = con.createStatement();
				
			// (2). SQL 작성
				String sql = "select empno, ename, job, sal, dname, loc from emp, dept "
						+ "where emp.deptno = dept.deptno";
				
			// (3). Result Set 객체로 데이터 받기
				rs = stmt.executeQuery(sql);
				
			// (4). 출력
				while(rs.next()) {
					System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"
				+rs.getString(3)+"\t"+rs.getInt(4)+"\t"+rs.getString(5)+"\t"+rs.getString(6));
				}
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 클래스를 찾지 못함!");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("데이터베이스 연결 실패!");
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
