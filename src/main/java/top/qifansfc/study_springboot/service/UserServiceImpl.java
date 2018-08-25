package top.qifansfc.study_springboot.service;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.qifansfc.study_springboot.domain.User;
import top.qifansfc.study_springboot.dao.UserDao;
import top.qifansfc.study_springboot.exception.UserException;
import top.qifansfc.study_springboot.util.Result;
import top.qifansfc.study_springboot.util.ReturnResult;

import java.util.List;

@Service
@MapperScan("top.qifansfc.study_springboot.dao")
public class UserServiceImpl implements UserService{
    @Autowired
    private UserDao userDao;
    @Override
    public Result getUserById(Integer id) throws Exception{
        Result result;
        if (id==null){
            throw new UserException(-2,"未指定参数id或参数id为空");
        }
        User user=userDao.getUserById(id);
        if (user==null){
            throw new UserException(-3,"没有此用户");
        }
        result=ReturnResult.success(user);
        return result;
    }

    @Override
    public Result getAllUser() throws Exception {
        Result result;
        List<User> users=userDao.getAllUser();
        if (users.isEmpty()){
            throw new UserException(-2,"没有用户");
        }
        result=ReturnResult.success(users);
        return result;
    }

    @Override
    public Result insertUser(User user) throws Exception {
        Result result;
        if (userDao.insertUser(user)>0){
            result=ReturnResult.success("添加"+user.toString()+"成功");
        }else{
            result=ReturnResult.failed(-1,"添加"+user.toString()+"失败");
        }
        return result;
    }

    @Override
    public Result updateUser(User user) throws Exception {
        Result result;
        if (userDao.updateUser(user)>0){
            result=ReturnResult.success("更新"+user.toString()+"成功");
        }else{
            result=ReturnResult.failed(-1,"更新"+user.toString()+"失败");
        }
        return result;
    }

    @Override
    public Result deleteUserById(Integer id) throws Exception {
        Result result;
        User user=userDao.getUserById(id);
        if (userDao.deleteUserById(id)>0){
            result=ReturnResult.success("删除"+user.toString()+"成功");
        }else{
            result=ReturnResult.failed(-1,"删除"+user.toString()+"失败");
        }
        return result;
    }
}
