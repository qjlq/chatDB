package boot.spring.mapper;

import boot.spring.po.UserInfo;
import org.apache.ibatis.annotations.Mapper;

@Mapper

public interface UserInfoMapper {
    /**
     * 获取用户信息
     */
    UserInfo getUserUid(String uid);
}
