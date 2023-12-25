package boot.spring.service;

import boot.spring.po.OutputChat;
//import com.github.pagehelper.PageInfo;

import java.util.List;

public interface OutputChatService {
    List<OutputChat> findAllUser();
//    public PageInfo<OutputChat> PageUser(Integer pageNum, Integer pageSize);
}
