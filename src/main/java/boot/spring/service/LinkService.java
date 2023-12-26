package boot.spring.service;

import boot.spring.po.Product;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Component
public interface LinkService {

    List<Product> getProductsByUid(String Uid);
}
