package boot.spring.service;

import boot.spring.po.Product;

import java.util.List;

public interface LinkService {

    List<Product> getProductsByUid(String Uid);
}
