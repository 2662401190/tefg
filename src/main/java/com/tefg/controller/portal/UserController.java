package com.tefg.controller.portal;

import com.tefg.common.Const;
import com.tefg.common.ResponseCode;
import com.tefg.common.ServerResponse;
import com.tefg.pojo.User;
import com.tefg.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

/**
 * @author 贺威
 * @create 2018-10-31 17:47
 */
@Controller
@RequestMapping("/user/")
public class UserController {


    @Autowired
    private IUserService iUserService;

    /**
     * 用户登录
     * @param userName
     * @param passWord
     * @param session
     * @return
     */
    @RequestMapping(value = "login.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<User> login(@RequestParam String userName, @RequestParam String passWord, HttpSession session) {

        System.out.println("进入登录");
        ServerResponse<User> response=iUserService.login(userName, passWord);

        if (response.isSuccess()){
            session.setAttribute(Const.CURRENT_USER,response.getData());
        }

        return response;
    }

    /**
     * todo 退出登录
     * @param session
     * @return
     */
    @RequestMapping(value = "logout.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<String> logout(HttpSession session){
        session.removeAttribute(Const.CURRENT_USER);
        return ServerResponse.createBySuccess();
    }

    /**
     * todo 注册
     * @param user
     * @return
     */
    @RequestMapping(value = "register.do")
    @ResponseBody
    public ServerResponse<String> register(User user) {
        return  iUserService.register(user);
    }

    /**
     * 判断  邮箱和用户名是否存在
     * @param var
     * @param types
     * @return
     */
    @RequestMapping(value = "check_Valid.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<String>  checkValid(String  var,String types){

        return iUserService.checkValid(var,types );
    }

    /**
     * 获取 用户登录信息
     * @param session
     * @return
     */
    @RequestMapping(value = "get_user_info.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<User>  getUserInfo(HttpSession session){
        User user= (User) session.getAttribute(Const.CURRENT_USER);
        if(user!=null){
            return ServerResponse.createBySuccess(user);
        }

        return  ServerResponse.createBySuccessMessage("用户未登录，无法获取信息");
    }

    /**
     * 获取 问题
     */
    @RequestMapping(value = "forget_get_question.do")
    @ResponseBody
    public  ServerResponse<String> forgetGetQuestion(String username){

        return  iUserService.selectQuestion(username);
    }

    /**
     * 校验问题答案
     */
    @RequestMapping(value = "forget_check_answer.do")
    @ResponseBody
    public ServerResponse<String> forgetCheckAnswer(String username,String question ,String answer){
        return iUserService.checkAnswer(username,question,answer);
    }

    /**
     * 重置密码
     */
    @RequestMapping(value = "forget_rest_password.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<String> forgetRestPassWord(String username,String passwordNew,String forgetToken){
        return iUserService.forgetResetPassword(username, passwordNew, forgetToken);
    }


    /**
     * 登录成功的重置密码
     */
    @RequestMapping(value = "rest_password.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<String>  resetPassword(HttpSession session,String passwordOld,String passwordNew){

        User user= (User) session.getAttribute(Const.CURRENT_USER);
        if (user==null){
            return  ServerResponse.createByErrorMessage("用户未登录");
        }
        return iUserService.resetPassword(user, passwordOld, passwordNew);

    }

    /**
     * 更新个人信息
     */
    @RequestMapping(value = "update_information.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<User>  update_information(HttpSession session,User user){

        User currentUser= (User) session.getAttribute(Const.CURRENT_USER);
        if(currentUser==null){
            return ServerResponse.createByErrorMessage("用户未登录");
        }
        user.setId(currentUser.getId());
        user.setUsername(currentUser.getUsername());
        ServerResponse<User> response=iUserService.updateInfomation(user);

        if (response.isSuccess()) {
            session.setAttribute(Const.CURRENT_USER, response.getData());
        }
        return response;
    }

    /**
     * 获取个人信息
     * @param session
     * @return
     */
    @RequestMapping(value = "get_information.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<User> get_information(HttpSession session) {
        User currentUser= (User) session.getAttribute(Const.CURRENT_USER);
        if(currentUser==null){
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), "未登录需要强制登录status=10");
        }
        return iUserService.getInformation(currentUser.getId());
    }

}
