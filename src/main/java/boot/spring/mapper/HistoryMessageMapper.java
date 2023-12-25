package boot.spring.mapper;

import boot.spring.po.HistoryMessage;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface HistoryMessageMapper {

    List<HistoryMessage> getHistoryMessage();

}
