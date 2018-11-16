package com.tefg.controller.manager;

import com.tefg.Utril.MD5Util;
import com.tefg.common.AjaxResult;
import com.tefg.common.Const;
import com.tefg.pojo.User;
import com.tefg.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
public class LoginController {
    @Autowired
    private LoginService loginService;
    @RequestMapping("/doLogin")
    public Object doLogin(String username, String password, HttpSession session){
        AjaxResult result= result = new AjaxResult();
        try {
            Map<String,Object> paramMap=new HashMap<String, Object>();
            paramMap.put("username",username);
            paramMap.put("password", MD5Util.MD5EncodeUtf8(password));
            User user=loginService.queryUserLogin(paramMap);
            session.setAttribute(Const.ManagerUser,user);
            result.setSuccess(true);
        } catch (Exception e) {
            result.setMessage("用户名或者密码不正确");
            result.setSuccess(false);
            e.printStackTrace();
        }
        return result;

    }
}
