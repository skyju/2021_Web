package guest.service;

import java.sql.Connection;
import java.sql.SQLException;

import guest.dao.MsgDao;
import guest.domain.Msg;
import guest.exception.MsgNotFoundException;
import guest.exception.NotMatchPwException;
import guest.jdbc.ConnectionProvider;
import guest.jdbc.JdbcUtil;

public class EditMsgService {

	private EditMsgService() {}
	private static EditMsgService service = new EditMsgService();
	public static EditMsgService getInstance() {
		return service;
	}
	
	public int updateMessage(int mid, String pw, String guestname, String msg) throws SQLException, MsgNotFoundException, NotMatchPwException {

		int resultCnt = 0;

		Connection conn = null;
		MsgDao dao = null;
		Msg msgs = null;

		try {
			conn = ConnectionProvider.getConnection();
			dao = MsgDao.getInstance();
			conn.setAutoCommit(false);

			msgs = dao.selectMsgByMid(conn, mid);
			if (msgs == null) {
				throw new MsgNotFoundException(mid);
			} else {
				if (msgs.getPassword().equals(pw)) {
					msgs.setGuestname(guestname);
					msgs.setMsg(msg);
					resultCnt = dao.updateMsg(conn, msgs);
					conn.commit();
				} else {
					throw new NotMatchPwException();
				}
			}
		} catch (SQLException e) {
			JdbcUtil.rollback(conn);
			e.printStackTrace();
			throw e;
		} catch (MsgNotFoundException e) {
			JdbcUtil.rollback(conn);
			e.printStackTrace();
			throw e;
		} catch (NotMatchPwException e) {
			JdbcUtil.rollback(conn);
			e.printStackTrace();
			throw e;
		} finally {
			JdbcUtil.close(conn);
		}
		return resultCnt;
	}
}
