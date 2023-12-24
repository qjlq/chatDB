package boot.spring.mapper;

import boot.spring.po.SaveMessage;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MessageMapper {
    //存聊天信息
    void setMessage(SaveMessage message);
}
