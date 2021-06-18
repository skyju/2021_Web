package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCTest {

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
			
			//3. java.sql.Statement, java.sql.PreparedStatement, 
			// java.sql.ResultSet, 
			// executeQuery, executeUpdate

			stmt = con.createStatement();
			
			int dno = 10;
			String type = "deptno";
			
			String sqlSelect = "select * from dept where deptno ="+dno+" order by "+type;
			rs = stmt.executeQuery(sqlSelect);
			
			// rs.next() -> 다음 튜플(행)이 있다 없다 판단해줌
			while(rs.next()) {
				int deptno = rs.getInt("deptno");
				String dname = rs.getString("dname");
				String loc = rs.getNString("loc");
				System.out.println(deptno+"\t"+dname+"\t"+loc);			
			}
			
			
			System.out.println("PreparedStatement 사용");
			System.out.println("====================");
			/////////////////////////////////
			// PreparedStatement > SQL 먼저 등록
			String sqlSelect2 = "select * from dept where deptno = ?";
			pstmt = con.prepareStatement(sqlSelect2);
			
			// 매개변수처럼 ? 를 이용해서 나중에 변수를 바인딩
			pstmt.setInt(1, 10);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int deptno = rs.getInt("deptno");
				String dname = rs.getString("dname");
				String loc = rs.getNString("loc");
				System.out.println(deptno+"\t"+dname+"\t"+loc);			
			}
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 클래스를 찾지 못함!");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("데이터베이스 연결 실패!");
			e.printStackTrace();
		} finally {
			// 4. close
			if(con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}	
			}
			if(stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(rs != null) {
				try {
					rs.close();
				} catch(SQLException e) {
					e.printStackTrace();
				}
			}
			if(pstmt != null) {
				try {
					pstmt.close();
				} catch(SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
