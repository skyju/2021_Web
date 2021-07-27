package guest.exception;

public class MsgNotFoundException extends Exception {
	public MsgNotFoundException(int mid) {
		super(mid+"번 게시물은 존재하지 않습니다.");
	}
}
