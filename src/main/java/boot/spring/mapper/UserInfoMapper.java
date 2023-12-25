package boot.spring.mapper;

import boot.spring.po.UserInfo;

public interface UserInfoMapper {
    /**
     * 获取用户信息
     */
    UserInfo getUserUid(String uid);
}
