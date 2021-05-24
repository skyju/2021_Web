package MyProject;

public class Member {
	
	public Member() {
		System.out.println(getClass().getName());
	}
	public static void main(String[] args) {
		Member member = new Member();
	}

}
