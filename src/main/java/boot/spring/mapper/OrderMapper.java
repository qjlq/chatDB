package boot.spring.mapper;

import boot.spring.po.User;

public interface OrderMapper {
    //在数据库中获得姓名
    User getpwdbyname(String name);

    User getnamebyid(long id);
}
