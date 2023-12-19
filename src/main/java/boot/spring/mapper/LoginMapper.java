package boot.spring.mapper;

import org.apache.ibatis.annotations.Mapper;

import boot.spring.po.User;

@Mapper
public interface LoginMapper {
	User getpwdbyname(String name);

	User getnamebyid(long id);
}
