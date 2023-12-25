package boot.spring.service.impl;

import boot.spring.mapper.HistoryMessageMapper;
import boot.spring.po.HistoryMessage;
import boot.spring.service.HistoryMessageService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, timeout = 5)
//将当前类自动注入到spring容器中
@Service
public class HistoryMessageImpl implements HistoryMessageService {

    @Resource
    HistoryMessageMapper historyMessageMapper;

    @Override
    public List<HistoryMessage> getHistoryMessage() {
        List<HistoryMessage> history = historyMessageMapper.getHistoryMessage();
        return history;
    }
}
