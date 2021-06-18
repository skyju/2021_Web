package dept;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DeptDao {
	// 싱글톤 패턴: 여러개의 인스턴스를 생성하지 못하도록 하는  디자인 패턴
	// 외부 클래스 또는 인스턴스에서 해당 클래스로 인스턴스를 생성하지 못하도록 처리
	
	// 어떻게?:
	
	//1. 외부에서 클래스를 생성하지 못하도록, 생성자를 막고
	private DeptDao() {}
	//2. 클래스 내부에서 인스턴스를 만들고 (자기자신) 
	private static DeptDao dao = new DeptDao(); //클래스 내부라 private 생성자 호출 가능
	//3. 메소드를 통해서 반환하도록 처리
	public static DeptDao getInstance() {
		return dao;
	}
	
	// 1. DEPT 테이블을 전체 조회하는 메서드
	// 반환 타입은 List<Dept>
	// 매개변수  - Connection 객체 : Statement 객체 만들기 위해
	ArrayList<Dept> getDeptList(Connection con) {
		
		ArrayList<Dept> list = new ArrayList<Dept>();
		
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			stmt = con.createStatement();
			String sql = "select * from dept order by deptno";
			rs = stmt.executeQuery(sql);
			//데이터를 dept객체로 생성 > list에 저장
			while(rs.next()){
				list.add(new Dept(rs.getInt(1), rs.getString(2), rs.getString(3)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(stmt != null) {
					stmt.close();
				} 
				if (rs != null) {
					rs.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}

	// 2. DEPT 테이블에 데이터를 저장하는 메서드
	// 반영 횟수 반환
	// 사용자로부터 데이터 받기 > Dept 객체
	int insertDept(Connection con, Dept dept){
		int result = 0;
		PreparedStatement pstmt = null;
		
		try {
			// 전달 받은 Dept 객체의 데이터로 DEPT 테이블에 저장-> 결과 값을 반환
			String insertSql = "INSERT INTO DEPT VALUES (DEPT01_DEPTNO_SEQ.NEXTVAL, ?, ?)";
			pstmt = con.prepareStatement(insertSql);
			pstmt.setString(1, dept.getDname());
			pstmt.setString(2, dept.getLoc());
				
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return result;
	}

	// 3. DEPT 테이블의 데이터를 수정하는 메서드
	// 수정된 행의 개수 반환
	// 사용자로부터 데이터 받기 > Dept 객체
	int updateDept(Connection con, Dept dept) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		try {
			String updateSql = "UPDATE DEPT SET DNAME = ?, LOC = ? "
					+ "WHERE DEPTNO = ?";
			pstmt = con.prepareStatement(updateSql);
			pstmt.setString(1, dept.getDname());
			pstmt.setString(2, dept.getLoc());
			pstmt.setInt(3, dept.getDeptno());
				
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return result;
	}
	
	// 4. DEPT 테이블의 데이터를 삭제하는 메서드
	// 삭제된 행의 개수 반환
	// 사용자로부터 deptno를 받아서 처리
	int deleteDept(Connection con, int deptno) {
		int result = 0;
		PreparedStatement pstmt = null;

		try {
			String deleteSql = "DELETE FROM DEPT WHERE DEPTNO = ?";
			pstmt = con.prepareStatement(deleteSql);
			pstmt.setInt(1, deptno);
			result = pstmt.executeUpdate();

		} catch (SQLException e) { // 보통 예외 던지지 않고, 여기서 처리함
			e.printStackTrace();
		} finally {
			if(pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return result;
	}
}
