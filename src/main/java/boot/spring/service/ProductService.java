package boot.spring.service;

import boot.spring.po.Order;
import boot.spring.po.Product;

import java.util.List;

public interface ProductService {
    List<Product> getHistoryByUid(String Uid);
}
