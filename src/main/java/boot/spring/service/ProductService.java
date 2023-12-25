package boot.spring.service;

import java.util.List;

import boot.spring.po.Product;
public interface ProductService {
    //存商品信息
    void saveProduct(Product product);
    List<Product> getHistoryByUid(String Uid);
}