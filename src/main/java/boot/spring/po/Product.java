package boot.spring.po;

import java.math.BigDecimal;

public class Product {
    public String pid;
    public String product_name;
    public String description;
    public String picture;
//    public int quantity_num;
//    public BigDecimal price_decimal;
//    public String quantity;
//    public String price;
    public int quantity;
    public BigDecimal price;

    public Product() {
    }

    public Product(String pid, String product_name, String description, String picture, String quantity, String price) {
        this.pid = pid;
        this.product_name = product_name;
        this.description = description;
        this.picture = picture;
//        this.quantity = quantity;
//        this.price = price;
//        this.quantity_num = Integer.parseInt(quantity);
//        this.price_decimal = new BigDecimal(price);
        this.quantity = Integer.parseInt(quantity);
        this.price = new BigDecimal(price);
    }
}
