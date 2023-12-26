package boot.spring.mapper;

import boot.spring.po.OutputChat;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface OutputChatMapper {
    List<OutputChat> findAllUser();
}
