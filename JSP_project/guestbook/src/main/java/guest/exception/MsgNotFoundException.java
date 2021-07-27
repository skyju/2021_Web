package guest.exception;

public class MsgNotFoundException extends Exception {
	public MsgNotFoundException(String msg) {
		System.out.println(msg);
	}
}
