package com.tefg.dao;

import com.tefg.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    /**
     * 检查用户是否存在
      */
    int checkUsername(String username);

    /**
     * todo 检查email
     * @param email
     * @return
     */
    int checkEmail(String email);

    /**
     * 登录
     */
    User selectLogin(@Param("userName") String userName, @Param("passWord") String passWord);


    /**
     * 获取问题
     * @param username
     * @return
     */
    String selectQuestionByUsername(String username);

    /**
     * 检查问题答案
     * @param username
     * @param question
     * @param answer
     * @return
     */
    int checkAnswer(@Param("username") String username, @Param("question") String question,@Param("answer") String answer);

    /**
     * 更新密码
     * @param username
     * @param passwordNew
     * @return
     */
    int  updatePasswordNew(@Param("name") String username,@Param("pwd") String passwordNew);

    /**
     *  检查密码跟用户是否一致
     * @param password
     * @param userId
     * @return
     */
    int  checkPassword(@Param("pwd") String password,@Param("id") Integer userId);

    /**
     *
     * @param email
     * @param userId
     * @return
     */
     int checkEmailByUserId(@Param("email") String email,@Param("id") Integer userId);

    /**
     * 用户登录
     * @param paramMap
     * @return
     */
    User queryUserLogin(Map<String, Object> paramMap);

    /**
     *查询用户分页
     * @param parammap
     * @return
     */
    List queryPageList(Map parammap);

    /**
     * 查询用户总记录
     * @param parammap
     * @return
     */
    Integer queryCount(Map parammap);
}