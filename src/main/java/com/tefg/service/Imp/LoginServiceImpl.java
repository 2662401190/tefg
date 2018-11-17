package com.tefg.service.Imp;

import com.tefg.dao.UserMapper;
import com.tefg.exception.LoginFailException;
import com.tefg.pojo.User;
import com.tefg.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @ClassName LoginServiceImpl
 * @Description TODO
 * @Author Administrator
 * @Date 2018\11\16 001615:34
 * @Version 1.0
 **/
@Service
public class LoginServiceImpl implements LoginService{

    @Autowired
    private UserMapper userMapper;
    //登录验证
    @Override
    public User queryUserLogin(Map<String, Object> paramMap) {
        User user=userMapper.queryUserLogin(paramMap);
        if(user==null){
            throw new LoginFailException("用户账号或密码不正确!");
        }
        return user;
    }

    //判断用户是否注册
    @Override
    public int checkUsername(String username) {
        return userMapper.checkUsername(username);
    }
}
