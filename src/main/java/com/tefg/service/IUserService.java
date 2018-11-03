package com.tefg.service;

import com.tefg.common.ServerResponse;
import com.tefg.pojo.User;

/**
 * @author 贺威
 * @create 2018-10-31 18:01
 */
public interface IUserService {

    /**
     * 登录
     * @param userName
     * @param passWord
     * @return
     */
    ServerResponse<User> login(String userName, String passWord);

    /**
     * 注册
     * @param user
     * @return
     */
    ServerResponse<String> register(User user);

    /**
     * 校验 邮箱 用户名
     * @param var
     * @param types
     * @return
     */
    ServerResponse<String>  checkValid(String var, String types);


    /**
     * 找回密码
     * @param username
     * @return
     */
    ServerResponse<String> selectQuestion(String username);

    /**
     * 校验问题答案
     * @param username
     * @param question
     * @param Answer
     * @return
     */
    ServerResponse<String> checkAnswer(String username, String question, String Answer);

    /**
     * 忘记密码 重置密码
     * @param username
     * @param passwordNew
     * @param forgetToken
     * @return
     */
    ServerResponse<String> forgetResetPassword(String username, String passwordNew, String forgetToken);

    /**
     * 登录成功 之后的重置密码
     * @param user
     * @param passwordOld
     * @param passwordNew
     * @return
     */
    ServerResponse<String> resetPassword(User user, String passwordOld, String passwordNew);

    /**
     * 修改个人信息
     * @param user
     * @return
     */
    ServerResponse<User> updateInfomation(User user);

    /**
     * 查询个人信息
     * @param uid
     * @return
     */
    ServerResponse<User> getInformation(Integer uid);
}
