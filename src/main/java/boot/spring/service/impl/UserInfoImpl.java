package boot.spring.service.impl;


import boot.spring.mapper.UserInfoMapper;
import boot.spring.po.User;
import boot.spring.po.UserInfo;
import boot.spring.service.UserInfoService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, timeout = 5)
@Service("userinfoservice")
public class UserInfoImpl implements UserInfoService {

    @Resource
    UserInfoMapper userInfoMapper;

    @Override
    public UserInfo getHistoryUserUid(String uid) {
        UserInfo u = userInfoMapper.getUserUid(uid);
        return u;
    }
}
