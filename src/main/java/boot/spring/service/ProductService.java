package boot.spring.service;

import boot.spring.po.Order;
import boot.spring.po.Product;

import java.util.List;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Component
//@Async("taskExecutor")
//@Async
public interface ProductService {
    //存商品信息
    void saveProduct(Product product);
    void deleteProduct(String pid);
    List<Product> getHistoryByUid(String Uid);
    void updateQuantity(Product product);
    Product getProductByPid(String pid);
}
