package boot.spring.service;

import boot.spring.po.SellOrder;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Component
//@Async
public interface SellOrderService {
    List<SellOrder> getSellHistoryByUid(String uid);
    void sendOrderByoid(String oid);
    // @Async
    void receivedOrderByoid(String oid);
}
