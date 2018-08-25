package top.qifansfc.study_springboot.dao;

import org.apache.ibatis.annotations.*;
import top.qifansfc.study_springboot.domain.User;
import java.util.List;

@Mapper
public interface UserDao {
    @Select("select * from user where id =#{id}")
    User getUserById(Integer id);
    @Select("select * from user")
    List<User> getAllUser();
    @Insert("insert into user(name,age,sex,addtime) values(#{name},#{age},#{sex},#{addtime})")
    Integer insertUser(User user);
    @Update("update user set name=#{name},age=#{age},sex=#{sex},addtime=#{addtime} where id=#{id}")
    Integer updateUser(User user);
    @Delete("delete from user where id=#{id}")
    Integer deleteUserById(Integer id);
}
