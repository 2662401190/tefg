package com.tefg.service.Imp;

import com.tefg.Utril.MD5Util;
import com.tefg.common.Const;
import com.tefg.common.Page;
import com.tefg.common.ServerResponse;
import com.tefg.common.TokenCache;
import com.tefg.dao.UserMapper;
import com.tefg.pojo.User;
import com.tefg.service.IUserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * @author 贺威
 * @create 2018-10-31 18:05
 */
@Service("iUserService")
public class UserSericeImp implements IUserService {

    @Autowired
    public UserMapper userMapper;

    /**
     * 登录
     * @param userName
     * @param passWord
     * @return
     */
    @Override
    public ServerResponse<User> login(String userName, String passWord) {
        // 判断用户存不存在

        int resultConut=userMapper.checkUsername(userName);
        if(resultConut==0){
            return  ServerResponse.createByErrorMessage("用户名不存在");
        }
        //  todo 密码 登录MD5

        String  md5password=MD5Util.MD5EncodeUtf8(passWord);
        User user = userMapper.selectLogin(userName, md5password);
        if (user==null){
            return  ServerResponse.createByErrorMessage("密码错误");
        }
        user.setPassword(StringUtils.EMPTY);
        return ServerResponse.createBySuccess("登录成功", user);
    }


    /**
     * 注册
     * @param user
     * @return
     */
    @Override
    public ServerResponse<String> register(User user){
        // 判断用户是否存在
        ServerResponse response= this.checkValid(user.getUsername(), Const.USWENAME);
        if (!response.isSuccess()){
            return response;
        }
        //  判断邮箱是否存在
        ServerResponse email=this.checkValid(user.getEmail(),Const.EMAIL );
        if(!email.isSuccess()){
            return email;
        }

        user.setRele(Const.Role.ROLE_CUSTOMER);
        // MD5加密
        user.setPassword(MD5Util.MD5EncodeUtf8(user.getPassword()));

        int  resultConut=userMapper.insert(user);
        if (resultConut==0){
            return  ServerResponse.createByErrorMessage("注册失败");
        }
        return  ServerResponse.createBySuccessMessage("注册成功");
    }


    /**
     * 校验 邮箱   用户名
     * @param var
     * @param types
     * @return
     */
    @Override
    public ServerResponse<String>  checkValid(String var, String types){

        if(StringUtils.isNotBlank(types)){
            if (Const.USWENAME.equals(types)){
                // 判断用户存不存在
                int resultConut=userMapper.checkUsername(var);
                if(resultConut>0){
                    return  ServerResponse.createByErrorMessage("用户名以存在");
                }

            }
            if (Const.EMAIL.equals(types)){
                //  判断邮箱
                int   resultConut=userMapper.checkEmail(var);
                if(resultConut>0){
                    return  ServerResponse.createByErrorMessage("email已存在");
                }
            }
        }else {
            return  ServerResponse.createByErrorMessage("参数错误");
        }

        return ServerResponse.createBySuccessMessage("校验成功");
    }

    /**
     * 获取问题
     * @param username
     * @return
     */
    @Override
    public  ServerResponse<String> selectQuestion(String username){

        ServerResponse serverResponse = this.checkValid(username, Const.USWENAME);
        if (serverResponse.isSuccess()){
            //用户不存在
            return ServerResponse.createByErrorMessage("用户不存在");
        }

                //问题
        String question=userMapper.selectQuestionByUsername(username);
        if(StringUtils.isNotBlank(question)){

            return ServerResponse.createBySuccess(question);
        }
        return ServerResponse.createByErrorMessage("找回密码的问题为空");
    }


    /**
     * 校验问题答案
     * @param username
     * @param question
     * @param Answer
     * @return
     */
    @Override
    public ServerResponse<String> checkAnswer(String username,String question,String Answer){
        int resultCount=userMapper.checkAnswer(username, question, Answer);
        //说明问题及答案是正确，还是当前用户的
        if(resultCount>0){
            String forgetToken= UUID.randomUUID().toString();
            TokenCache.setKey(TokenCache.TOKEN_PREFIX+username, forgetToken);
            return ServerResponse.createBySuccess(forgetToken);
        }

        return ServerResponse.createByErrorMessage("问题的答案错误");
    }

    /**
     * 忘记密码 重置密码
     * @return
     */
    @Override
    public ServerResponse<String> forgetResetPassword(String username, String passwordNew, String forgetToken){

        //如果如果传过来的参数是空的
        if(StringUtils.isBlank(forgetToken)){
            ServerResponse.createBySuccessMessage("参数错误，Token需要传递");
        }

        ServerResponse serverResponse=this.checkValid(username, Const.USWENAME);

        if (serverResponse.isSuccess()){
             ServerResponse.createByErrorMessage("用户不存在");
        }

        String toKen=TokenCache.TOKEN_PREFIX+username;
        if (StringUtils.isBlank(toKen)){
            return  ServerResponse.createByErrorMessage("token无效或者过期");
        }
        if (StringUtils.equals(forgetToken, toKen)){
            String md5Password=MD5Util.MD5EncodeUtf8(passwordNew);
            int rowCount=userMapper.updatePasswordNew(username, md5Password);
            if(rowCount>0) {
                return ServerResponse.createBySuccessMessage("修改成功");
            }
        }else {
            return ServerResponse.createByErrorMessage("token 错误请重新获取重置密码的token");
        }

        return  ServerResponse.createBySuccessMessage("修改密码失败");

    }

    /**
     * 登陆成功中的重置密码
     */
    @Override
    public ServerResponse<String> resetPassword(User user, String passwordOld, String passwordNew) {
        //防止横向越权，要校验一下这个用户的旧密码，一定要指定当前用户，因为我们会查询一个count（*）,如果不指定id,那么结果就是true
        int resultCount=userMapper.checkPassword(MD5Util.MD5EncodeUtf8(passwordOld),user.getId() );

        if(resultCount==0){
            return ServerResponse.createByErrorMessage("旧密码错误");
        }
        user.setPassword(MD5Util.MD5EncodeUtf8(passwordNew));
        int updateCount=userMapper.updateByPrimaryKeySelective(user);

        if (updateCount > 0) {
            return ServerResponse.createBySuccessMessage("密码更新成功");
        }
        return ServerResponse.createByErrorMessage("密码更新失败");

    }

    /**
     * 更新个人信息
     * @param user
     * @return
     */
    @Override
    public ServerResponse<User> updateInfomation(User user){
        //username 是不能更新的
        // Email ： 检验新的Email 是不是已存在，并且存在的Email相同的话，不能是我们当前这个用户的
        int resultCount=userMapper.checkEmailByUserId(user.getEmail(), user.getId());
        if (resultCount>0){
            return  ServerResponse.createByErrorMessage("Email已存在,请更换Email重试");
        }
        User updateUser=new User();
        updateUser.setId(user.getId());
        updateUser.setEmail(user.getEmail());
        updateUser.setPhone(user.getPhone());
        updateUser.setQuestion(user.getQuestion());
        updateUser.setAnswer(user.getAnswer());

        int updateCount=userMapper.updateByPrimaryKeySelective(updateUser);
        if (updateCount > 0) {
            return ServerResponse.createBySuccess("更新个人信息成功",updateUser);
        }
        return ServerResponse.createByErrorMessage("更新个人信息失败");
    }

    /**
     *查询个人信息
     * @return
     */
    @Override
    public ServerResponse<User> getInformation(Integer uid){
        User user=userMapper.selectByPrimaryKey(uid);
        if (user == null) {
            return ServerResponse.createByErrorMessage("找不到该用户");
        }
        user.setPassword(StringUtils.EMPTY);

        return ServerResponse.createBySuccess(user);
    }



    //  后台

    /**
     * 判断是否是管理员
     * @param user
     * @return
     */
    @Override
    public  ServerResponse checkAdminRole(User user){
        if (user != null && user.getRele().intValue() == Const.Role.ROLE_ADMIN) {
            return  ServerResponse.createBySuccess();
        }
        return ServerResponse.createByError();
    }

    /**
     * 用户分页
     * @param parammap
     * @return
     */
    @Override
    public Page queryPage(Map parammap) {
        Page page=new Page((Integer) parammap.get("pageno"),(Integer) parammap.get("pagesize"));
        Integer startIndex=page.getstartIndex();
        parammap.put("startIndex",startIndex);
        List datas=userMapper.queryPageList(parammap);
        page.setDatas(datas);
        Integer count=userMapper.queryCount(parammap);
        page.setTotalsize(count);
        return page;
    }


}
