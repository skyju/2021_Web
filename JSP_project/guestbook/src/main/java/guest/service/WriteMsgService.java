package guest.service;

import java.sql.Connection;
import java.sql.SQLException;

import guest.dao.MsgDao;
import guest.domain.Msg;
import guest.domain.MsgRequest;
import guest.jdbc.ConnectionProvider;
import guest.jdbc.JdbcUtil;

public class WriteMsgService { 
	
	private WriteMsgService() {}
	private static WriteMsgService service = new WriteMsgService();
	public static WriteMsgService getInstance() {
		return service;
	}
	
	public int writeMsg(MsgRequest requestMsg) { //insert
		int resultCnt = 0;
		
		Connection conn = null;
		MsgDao dao = null;
		
		try {
			conn = ConnectionProvider.getConnection();
			dao = MsgDao.getInstance();
			conn.setAutoCommit(false);
			// true- > 자동커밋 // Spring, Mybatis에서는 안씀

			// 사용자한테 필수 입력값만 입력받은 후, Msg객체로 변환하여 DB에 넣음
			Msg msg = requestMsg.toMsg();
			resultCnt = dao.writeMsg(conn, msg);
			
			conn.commit();
			
		} catch (SQLException e) {
			JdbcUtil.rollback(conn);
			e.printStackTrace();
		}
		return resultCnt;
	}
}
