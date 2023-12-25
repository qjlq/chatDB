package boot.spring.mapper;

import boot.spring.po.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface EmpMapper {
    List<User> findAll();
    void add(User user);
    User delete(String username);
    User find(String username);
    void update(User user);
    User seek(String username);
    User search(String username);
    User Find(User user);
}
