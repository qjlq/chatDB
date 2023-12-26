package boot.spring.service;

import boot.spring.po.HistoryMessage;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Component
public interface HistoryMessageService {

    List<HistoryMessage> getHistoryMessage();
}
