package boot.spring.service;

import boot.spring.po.User;

public interface LoginService {
	
	User getUserByName(String name);
	
}
