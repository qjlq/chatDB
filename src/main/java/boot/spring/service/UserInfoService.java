package boot.spring.service;

import boot.spring.po.UserInfo;

public interface UserInfoService {
    UserInfo getHistoryUserUid(String uid);
}
