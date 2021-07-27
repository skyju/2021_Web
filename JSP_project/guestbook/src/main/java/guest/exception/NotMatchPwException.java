package guest.exception;

public class NotMatchPwException extends Exception {
	public NotMatchPwException() {
		super("비밀번호가 맞지 않습니다.");
	}
}
