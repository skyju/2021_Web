package guest.jdbc;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

public class JdbcDriverLoad extends HttpServlet{

	@Override
	public void init(ServletConfig config) throws ServletException {
		String jdbcDriver = config.getInitParameter("jdbcDriver");
		
		try {
			jdbcDriver = jdbcDriver == null? "com.mysql.cj.jdbc.Driver": jdbcDriver;
			Class.forName(jdbcDriver);
			System.out.println("MySQL load...");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException(e); //연결이 안되면 실행이 안되도록
		}
	}
}
