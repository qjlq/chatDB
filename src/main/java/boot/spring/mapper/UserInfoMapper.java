package boot.spring.mapper;

import org.apache.ibatis.annotations.Mapper;

import boot.spring.po.UserInfo;
@Mapper
public interface UserInfoMapper {
    /**
     * 获取用户信息
     */
    UserInfo getUserUid(String uid);
}
