package boot.spring.service.impl;

import boot.spring.mapper.ProductMapper;
import boot.spring.po.Product;
import boot.spring.service.ProductService;
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
public class ProductServiceImpl implements ProductService {
    @Resource
    ProductMapper productMapper;


    @Override
    public void saveProduct(Product product) {
        productMapper.setProduct(product);
    }
}
