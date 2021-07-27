package guest.service;

import java.sql.Connection;
import java.sql.SQLException;

import guest.dao.MsgDao;
import guest.domain.Msg;
import guest.exception.MsgNotFoundException;
import guest.exception.NotMatchPwException;
import guest.jdbc.ConnectionProvider;
import guest.jdbc.JdbcUtil;

public class DeleteMsgService {

	private DeleteMsgService() {
	}

	private static DeleteMsgService service = new DeleteMsgService();

	public static DeleteMsgService getInstance() {
		return service;
	}

	public int deleteMessage(int mid, String pw) throws SQLException, MsgNotFoundException, NotMatchPwException {

		int resultCnt = 0;

		Connection conn = null;
		MsgDao dao = null;
		Msg msg = null;

		try {
			conn = ConnectionProvider.getConnection();
			dao = MsgDao.getInstance();
			conn.setAutoCommit(false);

			msg = dao.selectMsgByMid(conn, mid);
			if (msg == null) {
				throw new MsgNotFoundException(mid);
			} else {
				if (msg.getPassword().equals(pw)) {
					resultCnt = dao.deleteMsg(conn, msg);
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
