package boot.spring.service.impl;

import boot.spring.mapper.LoginMapper;
import boot.spring.po.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import boot.spring.mapper.OrderMapper;
import boot.spring.po.Order;
import boot.spring.service.OrderService;

import javax.annotation.Resource;
import java.util.List;

//保证方法内多个数据库操作要么同时成功，要么同时失败
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, timeout = 5)
//将当前类自动注入到spring容器中
@Service("orderservice")
public class OrderServicelmpl implements OrderService{
    //调用loginMapper接口，获取name变量数据
    @Resource
    OrderMapper orderMapper;

    //实现接口方法
    @Override
    public List<Order> getHistoryByUid(String uid) {
        List<Order> o = orderMapper.getOrderByUid(uid);
        return o;
    }

    @Override
    public void addOrder(Order order) {
        orderMapper.addOrder(order);
    }
}
