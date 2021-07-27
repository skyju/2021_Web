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
	
	public MsgListView getMsgList(int currentPageNum) {
		// MsgListView 객체를 생성하는 데 필요한 것
		
		// 1. List<Msg> msgList : dao : selectMsgList(conn, 시작위치, 페이지당 수용할 msg개수) : limit
		// 2. msgTotalCnt : 전체 msg개수 : dao : selectAllCount(conn)
		
		// 3. msgCntPerPage : 페이지당 수용할 msg개수: 위에 final로 선언
		// 4. currentPageNum : 현재 페이지 : 매개변수로 받음 (list.jsp에서 1로 설정)
		
		// 5. DB SELECT 시작위치 : (현재페이지 -1) * 페이지당 수용할 msg개수
		// 6. DB SELECT 끝위치 : 시작위치 + 페이지당 수용할 msg 개수
		int firstRow = (currentPageNum - 1) * msgCntPerPage;
		int lastRow = firstRow + msgCntPerPage;
		
		Connection conn = null;
		MsgDao dao = null;
		MsgListView listView = null;
		List<Msg> msgList = null;
		
		try {
			conn = ConnectionProvider.getConnection();
			dao = MsgDao.getInstance();
			conn.setAutoCommit(false);
			
			// SELECT: List<Msg>
			// SELECT: 전체 msg개수
			msgList = dao.selectMsgList(conn, firstRow, msgCntPerPage);
			int msgTotalCnt = dao.selectAllCount(conn);
			
			// MsgListView객체 생성
			listView = new MsgListView(
					msgList, msgTotalCnt, 
					msgCntPerPage, currentPageNum, 
					firstRow, lastRow);
			
			conn.commit();
			
		} catch (SQLException e) {
			JdbcUtil.rollback(conn);
			e.printStackTrace();
		}
		return listView;
	}
}
