package boot.spring.po;

import java.math.BigDecimal;

public class Product {
    public String pid;
    public String product_name;
    public String description;
    public String picture;
    public int Pquantity;
    public BigDecimal total;
    public int quantity;
    public BigDecimal price;
    public String lid;
    public String uid;
    public Product() {
    }

    public Product(String pid, String product_name, String description, String picture, String quantity, String price, String lid,String uid) {
        this.pid = pid;
        this.product_name = product_name;
        this.description = description;
        this.picture = picture;
        this.quantity = Integer.parseInt(quantity);
        this.price = new BigDecimal(price);
        this.Pquantity = Pquantity;
        this.total = total;
        this.lid = lid;
        this.uid = uid;
    }
    public void setlid(String lid) {
		this.lid = lid;
	}
}
