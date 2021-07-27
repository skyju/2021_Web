package guest.domain;

import java.util.List;

public class MsgListView {

	private List<Msg> msgList; // 게시물 Msg 객체 3개 담을 list

	private int msgTotalCnt; // 전체 Msg의 개수
	private int numsPerPage; // 페이지당 수용 Msg 개수
	private int totalPageNum; // 총 페이지 개수

	private int currentPageNum; // 현재 페이지 번호
	private int startRow; // DB 게시물 시작 위치
	private int endRow; // 마지막 위치

	public MsgListView(List<Msg> msgList, int msgTotalCnt, 
			int numsPerPage, int currentPageNum, 
			int startRow, int endRow) {
		this.msgList = msgList;
		this.msgTotalCnt = msgTotalCnt;
		this.numsPerPage = numsPerPage;
		this.currentPageNum = currentPageNum;
		this.startRow = startRow;
		this.endRow = endRow;
		calpageTotalNum();
	}

	public void calpageTotalNum() {
		if(this.msgTotalCnt == 0) {
			this.currentPageNum = 0;
		} else {
			
		this.totalPageNum = this.msgTotalCnt/this.numsPerPage;
			if(this.msgTotalCnt % this.numsPerPage>0) {
				this.totalPageNum+=1;
			}
		}
	}

	public List<Msg> getMsgList() {
		return msgList;
	}

	public int getMsgTotalCnt() {
		return msgTotalCnt;
	}

	public int getNumsPerPage() {
		return numsPerPage;
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

	@Override
	public String toString() {
		return "MsgListView [msgList=" + msgList + ", msgTotalCnt=" + msgTotalCnt + ", numsPerPage=" + numsPerPage
				+ ", totalPageNum=" + totalPageNum + ", currentPageNum=" + currentPageNum + ", startRow=" + startRow
				+ ", endRow=" + endRow + "]";
	}		
	
	
}
