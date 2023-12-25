package boot.spring.service;

import boot.spring.po.UserInfo;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Component
public interface UserInfoService {
    UserInfo getHistoryUserUid(String uid);
}
