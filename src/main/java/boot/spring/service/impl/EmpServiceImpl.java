package boot.spring.service.impl;

import boot.spring.mapper.EmpMapper;
import boot.spring.po.User;
import boot.spring.service.EmpService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class EmpServiceImpl implements EmpService {
    @Resource
    private EmpMapper empMapper;


    @Override
    public List<User> findAll() {
        return empMapper.findAll();
    }

    @Override
    public void add(User user) {
        empMapper.add(user);
    }

    @Override
    public User delete(String username) {
        return empMapper.delete(username);
    }

    @Override
    public User find(String username) {
        return empMapper.find(username);
    }

    @Override
    public void update(User user) {
        empMapper.update(user);
    }

    @Override
    public User seek(String username) {
        return empMapper.seek(username);
    }

    @Override
    public User search(String username) {
        return empMapper.search(username);
    }

    @Override
    public User Find(User user) {
        return empMapper.Find(user);
    }
}
