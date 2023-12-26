package boot.spring.mapper;

import boot.spring.po.Product;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProductMapper {

    void setProduct(Product product);
    void deleteProduct(String pid);
    List<Product> getProductByUid(String uid);
}