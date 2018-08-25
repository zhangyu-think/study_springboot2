package top.qifansfc.study_springboot.service;

import top.qifansfc.study_springboot.domain.User;
import top.qifansfc.study_springboot.util.Result;

public interface UserService {
    Result getUserById(Integer id) throws Exception;
    Result getAllUser() throws Exception;
    Result insertUser(User user) throws Exception;
    Result updateUser(User user) throws Exception;
    Result deleteUserById(Integer id) throws Exception;
}
