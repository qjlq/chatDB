package boot.spring.service.impl;

import boot.spring.mapper.LoginMapper;
import boot.spring.mapper.MessageMapper;
import boot.spring.po.SaveMessage;
import boot.spring.service.MessageService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, timeout = 5)
//将当前类自动注入到spring容器中
@Service
@Component
public class MessageServiceImpl implements MessageService {
    @Resource
    MessageMapper messageMapper;


    @Override
    public void saveMessage(SaveMessage message) {
        messageMapper.setMessage(message);
    }
}
