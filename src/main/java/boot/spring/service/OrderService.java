package boot.spring.service;

import boot.spring.po.Order;

import java.util.List;

public interface OrderService {
    //通过po.Order来获得网页上的内容
    List<Order> getHistoryByUid(String Uid);
}
