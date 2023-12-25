package boot.spring.service.impl;

import boot.spring.mapper.LinkMapper;
import boot.spring.po.Product;
import boot.spring.service.LinkService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, timeout = 5)
//将当前类自动注入到spring容器中
@Service
public class LinkServiceImpl implements LinkService {

    @Resource
    LinkMapper linkMapper;

    public List<Product> getProductsByUid(String uid) {
        List<Product> o = linkMapper.getProductByUid(uid);
        return o;
    }

}
