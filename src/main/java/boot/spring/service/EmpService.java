package boot.spring.service;


import boot.spring.po.User;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Component
public interface EmpService {
    List<User> findAll();
    void add(User user);
    User delete(String username);
    User find(String username);
    void update(User user);
    User seek(String username);
    User search(String username);
    User Find(User user);
}
