package boot.spring.mapper;

import boot.spring.po.Product;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProductMapper {

    void setProduct(Product product);
}
