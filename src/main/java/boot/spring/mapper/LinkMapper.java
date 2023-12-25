package boot.spring.mapper;

import boot.spring.po.Product;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface LinkMapper {
    
    List<Product> getProductByUid(String uid);
}
