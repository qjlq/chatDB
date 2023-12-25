package boot.spring.service;

import boot.spring.po.Order;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Component
public interface OrderService {
    //通过po.Order来获得网页上的内容
    List<Order> getHistoryByUid(String Uid);
}
