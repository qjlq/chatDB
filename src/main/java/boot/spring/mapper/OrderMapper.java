package boot.spring.mapper;

import boot.spring.po.Order;

import org.apache.ibatis.annotations.Mapper;
import java.util.List;
@Mapper

public interface OrderMapper {
    //在数据库中获得订单
    List<Order> getOrderByUid(String uid);
    void addOrder(Order order);
}
