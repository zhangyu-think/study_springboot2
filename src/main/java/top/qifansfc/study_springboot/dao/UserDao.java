package top.qifansfc.study_springboot.dao;

import org.apache.ibatis.annotations.*;
import top.qifansfc.study_springboot.domain.User;

@Mapper
public interface UserDao {
    @Select("select * from user where name=#{0} and password=#{1}")
    User login(String name,String password);
    @Update("update user set password=#{password} where id=#{id}")
    Integer updateUser(User user);
}
