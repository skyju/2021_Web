package dept.dao;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;

import java.sql.Connection;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import dept.domain.Dept;
import jdbc.util.ConnectionProvider;

public class DeptDaoTest {
	
	static Connection con;
	static DeptDao dao;
	Dept dept;


	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		con = ConnectionProvider.getConnection();
		dao = DeptDao.getInstance();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void tesGetDeptList() {
		List<Dept> list = dao.getDeptList(con);
		assertNotNull("List가 생성되었나 확인", list);
	}
	
	@Test
	public void tesSelectByDeptno() {
		dept = dao.selectByDeptno(con, 10);
		assertNotNull("dept가 선택되었나 확인", dept);
	}
	
	@Test
	public void testInsertDept() {
		int result = dao.insertDept(con, new Dept(60, "test", "부산"));
		assertSame("dept가 insert되었나 확인", result, 1);
	}
	
	@Test
	public void testDeleteDept() {
		int result = dao.deleteDept(con, 40);
		assertSame("dept가 delete되었나 확인", result, 1);
	}
	
	@Test
	public void testUpdateDept() {
		int result = dao.updateDept(con, new Dept(40, "test2", "서울"));
		assertSame("dept가 update되었나 확인", result, 1);
	}
	

}
