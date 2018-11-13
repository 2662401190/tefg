package com.tefg.controller.backend;

import com.tefg.common.Const;
import com.tefg.common.ServerResponse;
import com.tefg.pojo.User;
import com.tefg.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * @author 贺威
 * @create 2018-11-02 18:12
 */
@Controller
@RequestMapping("/manage/user/")
public class UserManageContorller {

    @Autowired
    private IUserService iUserService;


    /**
     * 后台登录
     * @param username
     * @param password
     * @param session
     * @return
     */
    @RequestMapping(value = "login.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<User>  Login(@RequestParam(value = "username") String username,@RequestParam(value = "password") String password, HttpSession session){
        ServerResponse<User> response=iUserService.login(username, password);

        System.out.println("..............."+response.toString());
        if(response.isSuccess()){
            User user=response.getData();
            //说明登录是管理员
            if (user.getRele()==Const.Role.ROLE_ADMIN){
                session.setAttribute(Const.CURRENT_USER, user);
                return response;
            }else {
                return ServerResponse.createByErrorMessage("不是管理员,无法登录");
            }
        }

        return response;
    }
}
