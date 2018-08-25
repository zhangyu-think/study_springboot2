package top.qifansfc.study_springboot.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.qifansfc.study_springboot.dao.UserDao;
import top.qifansfc.study_springboot.domain.User;
import top.qifansfc.study_springboot.service.UserService;
import top.qifansfc.study_springboot.util.Result;

@Slf4j
@RestController
@RequestMapping("/User")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private UserDao userDao;
    @RequestMapping("GetUserById")
    public Result getUserById(Integer id) throws Exception{
        return userService.getUserById(id);
    }
    @RequestMapping("GetAllUser")
    public Result getAllUser() throws  Exception{
        log.debug("获取所有用户1");
        return userService.getAllUser();
    }
    @RequestMapping("InsertUser")
    public Result insertUser(String name, Integer age, String sex, String addtime) throws  Exception{
        User user=new User();
        user.setName(name);
        user.setAge(age);
        user.setSex(sex);
        user.setAddtime(addtime);
        return userService.insertUser(user);
    }
    @RequestMapping("UpdateUser")
    public Result updateUser(Integer id,String name, Integer age, String sex, String addtime) throws  Exception{
        User user=userDao.getUserById(id);
        user.setName(name);
        user.setAge(age);
        user.setSex(sex);
        user.setAddtime(addtime);
        return userService.updateUser(user);
    }
    @RequestMapping("DeleteUserById")
    public Result deleteUserById(Integer id) throws  Exception{
        return userService.deleteUserById(id);
    }

}
