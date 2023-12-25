package boot.spring.service;

import boot.spring.po.Order;
import boot.spring.po.Product;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Component
public interface ProductService {
    //存商品信息
    void saveProduct(Product product);
    List<Product> getHistoryByUid(String Uid);

}
