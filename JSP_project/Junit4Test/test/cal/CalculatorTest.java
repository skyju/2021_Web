package cal;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class CalculatorTest {
	
	// Calculator cal = new Calculator();
	Calculator cal;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("@BeforeClass");
		//테스트를 위한 전처리
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("@AfterClass");
	}

	@Before
	public void setUp() throws Exception {
		System.out.println("@Before");
		cal = new Calculator();
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("@After");
	}

	@Test
	public void testAdd() {
		System.out.println("testAdd()");
		assertEquals("add() 메서드 테스트", 12, cal.add(10, 2));
		//fail("Not yet implemented");
	}

	@Test
	public void testSubstract() {
		System.out.println("testSubstract()");
		assertEquals("substract() 메서드 테스트", 8, cal.substract(10, 2));
		//fail("Not yet implemented");
	}

	@Test
	public void testMultiply() {
		System.out.println("testMultiply()");
		assertEquals("multiply() 메서드 테스트", 20, cal.multiply(10, 2));
		//fail("Not yet implemented");
	}

	@Test
	public void testDivide() {
		System.out.println("testDivide()");
		assertEquals("divide() 메서드 테스트", 5, cal.divide(10, 2));
		//fail("Not yet implemented");
	}
	
	//예외 타입을 비교해서 테스트
	@Test(expected = RuntimeException.class)
	public void test1() {
		System.out.println("@test 실행 중 예외타입을 테스트");
		throw new RuntimeException();
	}
	
	@Test(expected = SQLException.class)
	public void test2() throws SQLException {
		System.out.println("@test 실행 중 예외타입을 테스트");
		throw new SQLException();
		// throw new ArithmeticExcepionn();
	}
	
	@Test(timeout =100)
	public void test3() {
		System.out.println("@test 실행 중 허용 시간 ms안에 실행이 완료되는 지 테스트");
		cal.add(100, 200);
		cal.substract(123, 23);
	}
	
	@Test
	public void test4() {
		// fail("테스트 미실행")
		assertTrue("메서드의 반환값이 boolean인 경우 사용", true);
		assertNull("메서드의 반환값이 null로 예상 되는 경우", null);
		assertNotNull("메서드의 반환값이 not null로 예상되는 경우", new Object());
		assertSame("같은 값일 경우", 1, 2);
		assertNotSame("같은 값이 아닐 경우", 1, 2);
	}

}
