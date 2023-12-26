package boot.spring.service;
import boot.spring.po.SaveMessage;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import boot.spring.po.User;
@Service
@Component
@Async
public interface MessageService {
    //存聊天信息
    void saveMessage(SaveMessage message);
}
