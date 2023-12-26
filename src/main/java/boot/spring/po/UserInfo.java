package boot.spring.po;


import java.math.BigDecimal;

public class UserInfo {
    private String uid;
    private String username;
    private String sex;
    private String phone;
    private String create_time;
    private BigDecimal money;
    private String address;

    public UserInfo(String uid, String username, String sex, String phone, String create_time, BigDecimal money, String address) {
        this.uid = uid;
        this.username = username;
        this.sex = sex;
        this.phone = phone;
        this.create_time = create_time;
        this.money = money;
        this.address = address;
    }

    public UserInfo() {
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "uid='" + uid + '\'' +
                ", username='" + username + '\'' +
                ", sex='" + sex + '\'' +
                ", phone='" + phone + '\'' +
                ", create_time='" + create_time + '\'' +
                ", money=" + money +
                ", address='" + address + '\'' +
                '}';
    }
}
