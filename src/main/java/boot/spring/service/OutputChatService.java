package boot.spring.service;

import boot.spring.po.OutputChat;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
//import com.github.pagehelper.PageInfo;

import java.util.List;
@Service
@Component
public interface OutputChatService {
    List<OutputChat> findAllUser();
//    public PageInfo<OutputChat> PageUser(Integer pageNum, Integer pageSize);
}
