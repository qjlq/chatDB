package boot.spring.mapper;

import org.apache.ibatis.annotations.Mapper;

import boot.spring.po.User;

@Mapper
public interface LoginMapper {
	//在数据库中获得姓名
	User getpwdbyname(String name);
}
