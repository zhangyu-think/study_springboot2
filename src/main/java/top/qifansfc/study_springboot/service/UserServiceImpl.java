package top.qifansfc.study_springboot.service;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.qifansfc.study_springboot.domain.User;
import top.qifansfc.study_springboot.dao.UserDao;
import java.util.List;

@Service
@MapperScan("top.qifansfc.study_springboot.dao")
public class UserServiceImpl implements UserService{
    @Autowired
    private UserDao userDao;

    @Override
    public User login(String name, String password) {
        return userDao.login(name,password);
    }

    @Override
    public Integer updateUser(User user) {
        return userDao.updateUser(user);
    }


}
