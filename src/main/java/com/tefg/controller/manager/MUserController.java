package com.tefg.controller.manager;

import com.github.pagehelper.StringUtil;
import com.sun.org.apache.regexp.internal.RE;
import com.tefg.common.AjaxResult;
import com.tefg.common.Page;
import com.tefg.service.IUserService;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName UserController
 * @Description TODO
 * @Author Administrator
 * @Date 2018\11\16 001613:37
 * @Version 1.0
 **/
@Controller
@RequestMapping("user")
public class MUserController {
    @Autowired
    private IUserService userService;

    @ResponseBody
    @RequestMapping("/index")
    public Object index(@RequestParam(value = "pageno", defaultValue = "1", required = false) Integer pageno,
                        @RequestParam(value = "pagesize", defaultValue = "10", required = false) Integer pagesize,
                        String queryTest) {
        AjaxResult result=new AjaxResult();
        try {
            Map parammap=new HashMap();
            parammap.put("pageno",pageno);
            parammap.put("pagesize",pagesize);
            if(StringUtil.isNotEmpty(queryTest)){
                parammap.put("queryTest",queryTest);
                if(queryTest.contains("%")){
                    queryTest=queryTest.replaceAll("%","\\\\%");
                }
                parammap.put("queryTest",queryTest);
            }
            Page page=userService.queryPage(parammap);

            result.setPage(page);
            result.setSuccess(true);
        }catch (Exception e){
            e.printStackTrace();
            result.setSuccess(false);
            result.setMessage("查询数据失败");
        }
        return result;
    }
}
