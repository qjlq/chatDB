package boot.spring.po;

import java.math.BigDecimal;

public class Product {
    public String pid;
    public String product_name;
    public String description;
    public String picture;
    public int quantity;
    public BigDecimal price;

    public Product() {
    }

    public Product(String pid, String product_name, String description, String picture, int quantity, BigDecimal price) {
        this.pid = pid;
        this.product_name = product_name;
        this.description = description;
        this.picture = picture;
        this.quantity = quantity;
        this.price = price;
    }
}
