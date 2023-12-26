package boot.spring.service.impl;

import boot.spring.mapper.LoginMapper;
import boot.spring.po.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import boot.spring.mapper.ProductMapper;
import boot.spring.po.Product;
import boot.spring.service.ProductService;

import javax.annotation.Resource;
import java.util.List;

//保证方法内多个数据库操作要么同时成功，要么同时失败
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, timeout = 5)
//将当前类自动注入到spring容器中
@Service
@Component
public class ProductServicelmpl implements ProductService{
        //调用loginMapper接口，获取name变量数据
        @Resource
        ProductMapper productMapper;
    
        //实现接口方法
        @Override
        public List<Product> getHistoryByUid(String uid) {
            List<Product> o = productMapper.getProductByUid(uid);
            return o;
        }

        @Override
        public void saveProduct(Product product) {
            productMapper.setProduct(product);
        }

        @Override
        public void deleteProduct(String pid) {
            productMapper.deleteProduct(pid);
        }

        @Override
        public void updateQuantity(Product product) {
            productMapper.updateQuantity(product);
        }

        @Override
        public Product getProductByPid(String pid) {
            Product product = productMapper.getProductByPid(pid);
            return product;
        }
}


