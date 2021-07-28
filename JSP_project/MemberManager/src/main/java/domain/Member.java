package domain;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import dao.MemberDao;

public class Member {
	
	private int idx;
	private String id;
	private String pw;
	private String name;
	private Timestamp date;
	private String photo;
	
	public Member() {}
	
	public Member(int idx, String id, String pw, String name, Timestamp date, String photo) {
		super();
		this.idx = idx;
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.date = date;
		this.photo = photo;
	}
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Timestamp getDate() {
		return date;
	}
	public void setDate(Timestamp date) {
		this.date = date;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	
	// java.sql.TimeStamp -> java.util.Date
	public Date getTime() {
		return new Date(getDate().getTime());
	}

	// Member -> LoginInfo(민감하지 않은 정보만 노출) 반환해주는 method 
	public LoginInfo toLoginInfo() {
		return new LoginInfo(this.idx, this.id, this.name, this.photo);
	}
	
	public List<Member> getMemberList() {
		Connection conn = null;
		try {
			conn = util.ConnectionProvider.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			util.CloseUtil.close(conn);
		}
		return MemberDao.getInstance().getMemberList(conn);
	}
}
