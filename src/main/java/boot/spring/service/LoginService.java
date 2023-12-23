package boot.spring.service;

import boot.spring.po.User;

public interface LoginService {
	//通过po.User来获得name
	User getUserByName(String name);
	void register(User user);
	
}
