package com.jnshu.dao;


import com.jnshu.entity.Result;
import com.jnshu.entity.User;

import java.util.List;

/**这里用来实现用户注册和登录的功能
 * */
public interface UserDao {
    //注册的时候需要输入验证码，把这个码使用到阿里的短信接口，校对，这步放在业务层实现
    //在Dao层就写为新增
    Long addUser(User user);
    //修改信息
    boolean updateUser(User user);
    //删除个人账号（注销）,这里需要登录之后，验证验证码才能注销，但还是根据ID删除
    boolean deleteUser(Long id);
    //登录 就是一个比对用户信息的过程，比对成功就登录成功，比对失败就是登录失败
    User findUserByName(String username);
    //展示个人信息
    User findById(Long id);
    //查找所有
    List<User> findAll();
}
