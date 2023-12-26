package boot.spring.service.impl;

import boot.spring.mapper.SellOrderMapper;
import boot.spring.po.SellOrder;
import boot.spring.service.SellOrderService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

//保证方法内多个数据库操作要么同时成功，要么同时失败
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, timeout = 5)
//将当前类自动注入到spring容器中
@Service("sellorderservice")
public class SellOrderServiceImpl implements SellOrderService{
    @Resource
    SellOrderMapper sellOrderMapper;

    @Override
    public List<SellOrder> getSellHistoryByUid(String uid) {
        List<SellOrder> sellOrders = sellOrderMapper.getSellOrderByUid(uid);
        return sellOrders;
    }
}
