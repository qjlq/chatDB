package boot.spring.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import boot.spring.mapper.LoginMapper;
import boot.spring.po.User;
import boot.spring.service.LoginService;

import javax.annotation.Resource;
import java.util.List;

//保证方法内多个数据库操作要么同时成功，要么同时失败
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, timeout = 5)
//将当前类自动注入到spring容器中
//@Service("loginservice")
@Service
@Component
public class LoginServiceImpl implements LoginService {
	//调用loginMapper接口，获取name变量数据
	@Resource
	LoginMapper loginmapper;

	//实现LoginService接口方法
	public User getUserByName(String name) {
		User s = loginmapper.getpwdbyname(name);
		if (s != null)
			return s;
		else
			return null;
	}

	@Override
	public void register(User user) {
		loginmapper.save(user);
	}

	@Override
	public User ManageLogin(String username, String password) {
		return loginmapper.ManageLogin(username, password);
	}

}
