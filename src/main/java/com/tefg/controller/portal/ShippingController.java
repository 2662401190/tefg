package com.tefg.controller.portal;

import com.github.pagehelper.PageInfo;
import com.tefg.common.Const;
import com.tefg.common.ResponseCode;
import com.tefg.common.ServerResponse;
import com.tefg.pojo.Shipping;
import com.tefg.pojo.User;
import com.tefg.service.IShippingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * @author 贺威
 * @create 2018-11-13 16:47
 */
@Controller
@RequestMapping(value = "/shipping/")
public class ShippingController {


    @Autowired
    private IShippingService iShippingService;

    @RequestMapping("add.do")
    @ResponseBody
    public ServerResponse add(HttpSession session, Shipping shipping){

        User user = (User) session.getAttribute(Const.CURRENT_USER);
        //用户未登录 强制登录
        if (user == null) {
            return   ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), ResponseCode.NEED_LOGIN.getDesc());
        }

        return iShippingService.add(user.getId(), shipping);

    }


    @RequestMapping("del.do")
    @ResponseBody
    public ServerResponse del(HttpSession session, Integer  shippingId){

        User user = (User) session.getAttribute(Const.CURRENT_USER);
        //用户未登录 强制登录
        if (user == null) {
            return   ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), ResponseCode.NEED_LOGIN.getDesc());
        }

        return iShippingService.del(user.getId(), shippingId);
    }
    @RequestMapping("update.do")
    @ResponseBody
    public ServerResponse update(HttpSession session, Shipping  shipping){

        User user = (User) session.getAttribute(Const.CURRENT_USER);
        //用户未登录 强制登录
        if (user == null) {
            return   ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), ResponseCode.NEED_LOGIN.getDesc());
        }

        return iShippingService.update(user.getId(),shipping );
    }

    /**
     * 查询详细地址
     * @param session
     * @param shippingId
     * @return
     */
    public ServerResponse<Shipping> select(HttpSession session,Integer shippingId){
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        //用户未登录 强制登录
        if (user == null) {
            return   ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), ResponseCode.NEED_LOGIN.getDesc());
        }

        return iShippingService.select(user.getId(), shippingId);
    }

    @RequestMapping("list.do")
    @ResponseBody
    public ServerResponse<PageInfo> List(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                         @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                         HttpSession session) {
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        //用户未登录 强制登录
        if (user == null) {
            return   ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), ResponseCode.NEED_LOGIN.getDesc());
        }

        return iShippingService.List(pageNum, pageSize, user.getId());
    }




}
