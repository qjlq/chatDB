package boot.spring.service;

import boot.spring.po.Product;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Component
//@Async
public interface LinkService {

    List<Product> getProductsByUid(String Uid);
}
