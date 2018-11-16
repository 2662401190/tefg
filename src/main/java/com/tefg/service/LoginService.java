package com.tefg.service;

import com.tefg.pojo.User;

import java.util.Map;

/**
 * @ClassName LoginService
 * @Description TODO
 * @Author Administrator
 * @Date 2018\11\16 001613:52
 * @Version 1.0
 **/
public interface LoginService {
    User queryUserLogin(Map<String,Object> paramMap);
}
