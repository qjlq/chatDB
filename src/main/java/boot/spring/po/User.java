package boot.spring.po;

import java.math.BigDecimal;

//该文件就是定义变量名字和方法
public class User {
	private String uid;
	private String username;
	private String password;
	private String sex;
	private String phone;
	private int is_admin=0;
	private int is_delete=0;
	private String create_time;

	private BigDecimal money;
	private String address;

	public User() {
	}

	public User(String uid, String username) {
		this.uid = uid;
		this.username = username;
	}

	public User(String uid, String username, String password, String sex, String phone, int is_admin, int is_delete, String create_time, BigDecimal money, String address) {
		this.uid = uid;
		this.username = username;
		this.password = password;
		this.sex = sex;
		this.phone = phone;
		this.is_admin = is_admin;
		this.is_delete = is_delete;
		this.create_time = create_time;
		this.money = money;
		this.address = address;
	}

	public BigDecimal getMoney() {
		return money;
	}

	public void setMoney(BigDecimal money) {
		this.money = money;
	}

	public String getUid() {
		return uid;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public String getSex() {
		return sex;
	}

	public String getPhone() {
		return phone;
	}

	public int getIs_admin() {
		return is_admin;
	}

	public int getIs_delete() {
		return is_delete;
	}

	public String getCreate_time() {
		return create_time;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void setIs_admin(int is_admin) {
		this.is_admin = is_admin;
	}

	public void setIs_delete(int is_delete) {
		this.is_delete = is_delete;
	}

	public void setCreate_time(String create_time) {
		this.create_time = create_time;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "User{" +
				"uid='" + uid + '\'' +
				", username='" + username + '\'' +
				", password='" + password + '\'' +
				", sex='" + sex + '\'' +
				", phone='" + phone + '\'' +
				", is_admin=" + is_admin +
				", is_delete=" + is_delete +
				", create_time='" + create_time + '\'' +
				", money=" + money +
				", address='" + address + '\'' +
				'}';
	}
}