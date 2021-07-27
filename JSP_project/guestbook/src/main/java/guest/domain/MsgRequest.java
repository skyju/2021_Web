package guest.domain;

public class MsgRequest {
	private String guestname;
	private String password;
	private String msg;
	
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

	// 필수 입력값 3가지만 가지고 Msg 객체로 만들기
	public Msg toMsg() {
		return new Msg(guestname, password, msg);
	}

}
