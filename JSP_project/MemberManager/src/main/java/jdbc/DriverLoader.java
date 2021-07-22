package jdbc;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

public class DriverLoader extends HttpServlet {
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		String param = config.getInitParameter("driver");
		
		try {
			if (param != null ) {
				Class.forName(param);
				System.out.println("드라이버 로드 성공!");
			} else {
				Class.forName("com.mysql.cj.jdbc.Driver");
				System.out.println("드라이버 로드 성공!");
			}
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로드 실패!");
		}

	}

}