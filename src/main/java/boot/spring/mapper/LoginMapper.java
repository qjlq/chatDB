package boot.spring.mapper;

import org.apache.ibatis.annotations.Mapper;

import boot.spring.po.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface LoginMapper {
	//在数据库中获得姓名

	void save(User user);
	User getpwdbyname(String name);

	User ManageLogin(@Param("username") String name, @Param("password") String password);

	User getUserByUid(String uid);
	User getUserByPid(String pid);
}
