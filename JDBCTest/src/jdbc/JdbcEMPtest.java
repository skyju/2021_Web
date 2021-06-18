package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class JdbcEMPtest {
	
	public static void main(String[] args) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("드라이버 로드 성공");
			
			String url = "jdbc:oracle:thin@localhost:1521:xe";
			String user = "hr";
			String password = "tiger";
			con = DriverManager.getConnection(url, user, password);
			System.out.println("데이터 베이스 연결 성공");
			
			con.setAutoCommit(false);
			//===================================================
			Scanner kb = new Scanner(System.in);
			
			
			//(1) SQL작성
			String sql = "";
			
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
	}

}
