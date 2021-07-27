package guest.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import guest.dao.MsgDao;
import guest.domain.Msg;
import guest.domain.MsgListView;
import guest.jdbc.ConnectionProvider;
import guest.jdbc.JdbcUtil;

public class MsgListService {
	
	//한 페이지에 표현할 msg 개수
	private final int msgCntPerPage = 3; // 또는 생성자 통해서 초기화 가능
	
	private MsgListService() {}
	private static MsgListService service = new MsgListService();
	public static MsgListService getInstance() {
		return service;
	}
	
	public MsgListView getMsgList(int pageNum) {
		MsgListView listView = null;
		
		Connection conn = null;
		MsgDao dao = null;
		List<Msg> msgList = null;
		
		try {
			conn = ConnectionProvider.getConnection();
			dao = MsgDao.getInstance();
			conn.setAutoCommit(false);
			
			// 전체 게시물의 개수
			int totalMsgCnt = dao.selectAllCount(conn);
			System.out.println("전체 게시물 개수:"+totalMsgCnt);
			
			int firstRow = (pageNum - 1) * msgCntPerPage;
			// 페이지에 표현할 메시지 객체들(List<Msg>)
			msgList = dao.selectMsgList(conn, firstRow, msgCntPerPage);
			System.out.println("msg List:"+msgList);
			
			listView = new MsgListView(
					msgList, totalMsgCnt, 
					msgCntPerPage, pageNum, 
					firstRow, firstRow+msgCntPerPage);
			conn.commit();
		} catch (SQLException e) {
			JdbcUtil.rollback(conn);
			e.printStackTrace();
		}
		return listView;
	}
}
