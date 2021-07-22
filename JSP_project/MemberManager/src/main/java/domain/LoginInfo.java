package domain;

public class LoginInfo {
	private int idx;
	private String id;
	private String name;
	
	public LoginInfo(int idx, String id, String name) {
		super();
		this.idx = idx;
		this.id = id;
		this.name = name;
	}
	
	public int getIdx() {
		return idx;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "loginInfo [id=" + id + ", name=" + name + "]";
	}
}