package com.jnshu.service;

import com.jnshu.entity.Result;
import com.jnshu.entity.User;

public interface UserService {
    //注册
    Long register(User user);
    //注销
    boolean logout(User user);

    //修改用户密码
    boolean changePassWord(User user);

    //登录 就是一个比对用户信息的过程，比对成功就登录成功，比对失败就是登录失败
    //支持用户名，邮箱，手机号登录
    Result checkLogin(String loginName, String passWord);
}
