package guest.domain;

import java.sql.Timestamp;

public class Msg {
	private int msgid;
	private String guestname;
	private String password;
	private String msg;
	private Timestamp regdate;
	
	public Msg() {}
	
	public Msg(String guestname, String password, String msg) {
		this.guestname = guestname;
		this.password = password;
		this.msg = msg;
	}
	
	public Msg(int msgid, String guestname, String password, String msg, Timestamp regdate) {
		this.msgid = msgid;
		this.guestname = guestname;
		this.password = password;
		this.msg = msg;
		this.regdate = regdate;
	}

	public int getMsgid() {
		return msgid;
	}
	public void setMsgid(int msgid) {
		this.msgid = msgid;
	}
	public String getGuestname() {
		return guestname;
	}
	public void setGuestname(String guestname) {
		this.guestname = guestname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Timestamp getRegdate() {
		return regdate;
	}
	public void setRegdate(Timestamp regdate) {
		this.regdate = regdate;
	}
	
	public Msg toMsg() {
		return new Msg(guestname, password, msg);
	}

	@Override
	public String toString() {
		return "Msg [msgid=" + msgid + ", guestname=" + guestname + ", password=" + password + ", msg=" + msg
				+ ", regdate=" + regdate + "]";
	}
	
}
