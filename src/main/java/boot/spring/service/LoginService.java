package boot.spring.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import boot.spring.po.User;
@Service
@Component
public interface LoginService {
	//通过po.User来获得name
	User getUserByName(String name);
	void register(User user);
	
}
