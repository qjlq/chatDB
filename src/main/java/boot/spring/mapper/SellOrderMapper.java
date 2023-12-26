package boot.spring.mapper;

import boot.spring.po.SellOrder;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface SellOrderMapper {

    List<SellOrder> getSellOrderByUid(String uid);
    void sendOrder(String oid);
    void receivedOrder(String oid);
}
