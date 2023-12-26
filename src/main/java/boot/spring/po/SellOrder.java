package boot.spring.po;

import java.math.BigDecimal;

public class SellOrder {
    public String oid;
    public String lid;
    public String buy_uid;
    public int Oquantity;
    public BigDecimal total;
    public String Otime;
    public String Status;
    public String Lnumber;

    public String product_name;
    public String picture;

    public String address;
    public String username;

    public SellOrder() {
    }

    public SellOrder(String oid, String lid, String buy_uid, int Oquantity, BigDecimal total, String Otime, String Status, String Lnumber, String product_name, String picture, String address) {
        this.oid = oid;
        this.lid = lid;
        this.buy_uid = buy_uid;
        this.Oquantity = Oquantity;
        this.total = total;
        this.Otime = Otime;
        this.Status = Status;
        this.Lnumber = Lnumber;
        this.product_name = product_name;
        this.picture = picture;
        this.address = address;
    }
}
