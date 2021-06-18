package jdbc;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCTest {
	
	static Connection con = null;
	static Statement stmt = null;

	public static void main(String[] args) {
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
			stmt.executeQuery("");
			
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
		}
	}

}
