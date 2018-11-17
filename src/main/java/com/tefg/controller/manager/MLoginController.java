package com.tefg.controller.manager;

import com.tefg.Utril.MD5Util;
import com.tefg.common.AjaxResult;
import com.tefg.common.Const;
import com.tefg.pojo.User;
import com.tefg.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName LoginController
 * @Description TODO
 * @Author Administrator
 * @Date 2018\11\16 001613:39
 * @Version 1.0
 **/
@Controller
@RequestMapping("login")
public class MLoginController {
    @Autowired
    private LoginService loginService;


    @ResponseBody
    @RequestMapping("/doLogin")
    public Object doLogin(String username, String password, HttpSession session){
        AjaxResult result= result = new AjaxResult();
        try {
            Map<String,Object> paramMap=new HashMap<String, Object>();
            paramMap.put("username",username);
            paramMap.put("password", MD5Util.MD5EncodeUtf8(password));

            int checkUsername=loginService.checkUsername(username);
            if(checkUsername!=0){

                User user=loginService.queryUserLogin(paramMap);
                if(user.getRele()==Const.Role.ROLE_ADMIN){
                    session.setAttribute(Const.ManagerUser,user);
                    result.setSuccess(true);
                }else{
                    result.setMessage("非管理员");
                    result.setSuccess(false);
                }

            }else{
                result.setMessage("用户名不存在");
                result.setSuccess(false);
            }
        } catch (Exception e) {
            result.setMessage("用户名或者密码不正确");
            result.setSuccess(false);
            e.printStackTrace();
        }
        return result;
    }
}
