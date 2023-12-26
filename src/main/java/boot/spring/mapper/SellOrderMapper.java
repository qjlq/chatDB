package boot.spring.mapper;

import boot.spring.po.SellOrder;

import java.util.List;

public interface SellOrderMapper {

    List<SellOrder> getSellOrderByUid(String uid);
    void sendOrder(String oid);
    void receivedOrder(String oid);
}
