package com.jnshu.serviceimpl;

import com.jnshu.dao.UserDao;
import com.jnshu.entity.Result;
import com.jnshu.entity.User;
import com.jnshu.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private static final Logger logger= LogManager.getLogger(UserServiceImpl.class);
    @Autowired
    UserDao userDao;

    @Autowired
    Result result;

    //这是返回的result的message
    String message;
    //注册，注册会生成一个token
    @Override
    public Long register(User user) {
        //先确定用户名不为空
        if (user.getUsername()!=null&&user.getUsername()!=""){
            if (user.getPassword()!=null&&user.getPassword()!=""){
//                if (user.getMessage())
            }else {
                //进入这层说明你的用户名输入没有问题，但是密码为空
                return Long.valueOf(1);
            }
        }else{
            //进入else说明你的用户名注册时输入为空
            return Long.valueOf(0);
        }


      return null;
    }

    @Override
    public boolean logout(User user) {
        return false;
    }

    @Override
    public boolean changePassWord(User user) {
        return false;
    }

    @Override
    public Result checkLogin(String loginName, String passWord) {
        return null;
    }

    @Override
    public User findById(Long id) {
        return null;
    }
}
