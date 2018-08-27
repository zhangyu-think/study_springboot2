package top.qifansfc.study_springboot.service;

import top.qifansfc.study_springboot.domain.User;

public interface UserService {
    User login(String name,String password);
    Integer updateUser(User user);
}
