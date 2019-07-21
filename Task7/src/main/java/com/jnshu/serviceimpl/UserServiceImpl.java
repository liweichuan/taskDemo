package com.jnshu.serviceimpl;

import com.jnshu.entity.Result;
import com.jnshu.entity.User;
import com.jnshu.service.UserService;

public class UserServiceImpl implements UserService {
    @Override
    public Long register(User user) {
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
}
