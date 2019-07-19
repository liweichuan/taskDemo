package com.jnshu.dao;


import com.jnshu.entity.Result;
import com.jnshu.entity.User;

/**这里用来实现用户注册和登录的功能
 * */
public interface UserDao {
    //注册的时候需要输入验证码，把这个码使用到阿里的短信接口，校对，这步放在业务层实现
    int register(User user);
    //登录  这里使用自己创建的result返回状态，登录名可以为用户名和邮箱
    Result checkLogin(String loginName, String password);
    //展示个人信息
    User findById(Long id);
}
