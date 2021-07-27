package guest.domain;

import java.util.List;

public class MsgListView {

	private List<Msg> msgList; // 게시물 Msg 객체 3개 담을 list
	private int msgTotalCnt; // 전체 Msg의 개수
	private int msgCntPerPage; // 페이지당 수용 Msg 개수
	private int currentPageNum; // 현재 페이지 번호
	
	private int totalPageNum; // 총 페이지 개수
	//= msgTotalCnt / msgCntPerPage -> 단, 전체 msg개수가 홀수일 경우 +1 해야함 (짤릴 수 있으므로)

	private int startRow; // 시작 위치
	private int endRow; // 마지막 위치

	public MsgListView(List<Msg> msgList, int msgTotalCnt, 
			int msgCntPerPage, int currentPageNum, 
			int startRow, int endRow) {
		
		this.msgList = msgList;
		this.msgTotalCnt = msgTotalCnt;
		this.msgCntPerPage = msgCntPerPage;
		//총 페이지 개수는 method통해 계산해서 넣을 것임
		calpageTotalNum();
		this.currentPageNum = currentPageNum;
		this.startRow = startRow;
		this.endRow = endRow;
	}

	public void calpageTotalNum() {
		if (this.msgTotalCnt == 0) {
			this.totalPageNum = 0;
		} else {
			this.totalPageNum = this.msgTotalCnt / this.msgCntPerPage;
			if (this.msgTotalCnt % this.msgCntPerPage > 0) {
				this.totalPageNum += 1;
			}
		}
	}

	public List<Msg> getMsgList() {
		return msgList;
	}
	public int getMsgTotalCnt() {
		return msgTotalCnt;
	}
	public int getMsgCntPerPage() {
		return msgCntPerPage;
	}
	public int getTotalPageNum() {
		return totalPageNum;
	}
	public int getCurrentPageNum() {
		return currentPageNum;
	}
	public int getStartRow() {
		return startRow;
	}
	public int getEndRow() {
		return endRow;
	}
}
