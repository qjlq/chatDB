package boot.spring.po;

public class User {
	private Long uid;
	private String username;
	private String password;

	public User() {
	}

	public User(Long uid, String username) {
		this.uid = uid;
		this.username = username;
	}

	public Long getUid() {
		return uid;
	}

	public void setUid(Long uid) {
		this.uid = uid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}