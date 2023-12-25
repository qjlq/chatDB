package boot.spring.service.impl;

import boot.spring.mapper.OutputChatMapper;
import boot.spring.po.OutputChat;
import boot.spring.service.OutputChatService;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, timeout = 5)
@Service
public class OutputChatImpl implements OutputChatService {
    @Resource
    OutputChatMapper outputChatMapper;

    @Override
    public List<OutputChat> findAllUser() {
        return outputChatMapper.findAllUser();
    }
//    @Override
//    public PageInfo<OutputChat> PageUser(Integer pageNum, Integer pageSize) {
//        PageHelper.startPage(pageNum, pageSize);
//        List<OutputChat> users= chatMapper.findAll();
//        PageInfo<OutputChat> pageInfo = new PageInfo<>(users);
//        return pageInfo;
//    }
}


