package com.tefg.controller.portal;

import com.tefg.common.Const;
import com.tefg.common.ResponseCode;
import com.tefg.common.ServerResponse;
import com.tefg.pojo.User;
import com.tefg.service.IcartService;
import com.tefg.vo.cartVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * @author 贺威
 * @create 2018-11-12 14:04
 */
@Controller
@RequestMapping(value = "/cart/")
public class cartCorotller {


    @Autowired
    private IcartService icartService;

    public cartCorotller() {
        super();
    }

    /**
     * 增加商品到购物车
     * @param session
     * @param count
     * @param productId
     * @return
     */
    @RequestMapping(value = "add.do")
    @ResponseBody
    public ServerResponse<cartVO> add(HttpSession session, Integer count, Integer productId){

        if (productId == null || count == null) {
            return ServerResponse.createByErrorCodeMessage(ResponseCode.ILLEGAL_ARGUMENT.getCode(), ResponseCode.ILLEGAL_ARGUMENT.getDesc());
        }

        User user = (User) session.getAttribute(Const.CURRENT_USER);
        //用户未登录 强制登录
        if (user == null) {
          return   ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), ResponseCode.NEED_LOGIN.getDesc());
        }
        return  icartService.add(user.getId(), productId, count);
    }

    @RequestMapping(value = "update.do")
    @ResponseBody
    public ServerResponse<cartVO> update(HttpSession session, Integer count, Integer productId){

        User user = (User) session.getAttribute(Const.CURRENT_USER);
        //用户未登录 强制登录
        if (user == null) {
            return   ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), ResponseCode.NEED_LOGIN.getDesc());
        }
        return  icartService.update(user.getId(), productId, count);
    }


    /**
     * 删除商品
     * @param session
     * @param productIds
     * @return
     */
    @RequestMapping(value = "delete_product.do")
    @ResponseBody
    public ServerResponse<cartVO> deleteProduct(HttpSession session, String productIds){

        User user = (User) session.getAttribute(Const.CURRENT_USER);
        //用户未登录 强制登录
        if (user == null) {
            return   ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), ResponseCode.NEED_LOGIN.getDesc());
        }
        return icartService.delectProduct(user.getId(), productIds);
    }

    /**
     *
     * @param session
     * @return
     */
    @RequestMapping(value = "list.do")
    @ResponseBody
    public ServerResponse<cartVO> list(HttpSession session){

        User user = (User) session.getAttribute(Const.CURRENT_USER);
        //用户未登录 强制登录
        if (user == null) {
            return   ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), ResponseCode.NEED_LOGIN.getDesc());
        }
        return icartService.list(user.getId());

    }
    /**
     *获取购物车中 产品的数量
     * @param session
     * @return
     */
    @RequestMapping(value = "get_cart_product_count.do")
    @ResponseBody
    public ServerResponse<Integer> getCartProductCount(HttpSession session){

        User user = (User) session.getAttribute(Const.CURRENT_USER);

        if (user == null) {
            return   ServerResponse.createBySuccess(0);
        }
        return icartService.getCartProductCount(user.getId());

    }


    // todo 一下可通过 js实现

    /**
     * 全选
     * @param session
     * @return
     */
    @RequestMapping(value = "sel ect_all.do")
    @ResponseBody
    public ServerResponse<cartVO> selectAll(HttpSession session){

        User user = (User) session.getAttribute(Const.CURRENT_USER);
        //用户未登录 强制登录
        if (user == null) {
            return   ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), ResponseCode.NEED_LOGIN.getDesc());
        }
        return icartService.selectOrUnSelect(user.getId(),null, Const.Cart.CHECKED) ;
    }


    /**
     * 全不选
     * @param session
     * @return
     */
    @RequestMapping(value = "un_select_all.do")
    @ResponseBody
    public ServerResponse<cartVO> unSelectAll(HttpSession session){

        User user = (User) session.getAttribute(Const.CURRENT_USER);
        //用户未登录 强制登录
        if (user == null) {
            return   ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), ResponseCode.NEED_LOGIN.getDesc());
        }
        return icartService.selectOrUnSelect(user.getId(),null, Const.Cart.UN_CHENCKED) ;
    }


    /**
     * 单选
     * @param session
     * @return
     */
    @RequestMapping(value = "select.do")
    @ResponseBody
    public ServerResponse<cartVO> select(HttpSession session,Integer productId){

        User user = (User) session.getAttribute(Const.CURRENT_USER);
        //用户未登录 强制登录
        if (user == null) {
            return   ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), ResponseCode.NEED_LOGIN.getDesc());
        }
        return icartService.selectOrUnSelect(user.getId(),productId, Const.Cart.CHECKED) ;
    }


    /**
     * 单不选
     * @param session
     * @return
     */
    @RequestMapping(value = "un_select.do")
    @ResponseBody
    public ServerResponse<cartVO> unSelect(HttpSession session,Integer productId){

        User user = (User) session.getAttribute(Const.CURRENT_USER);
        //用户未登录 强制登录
        if (user == null) {
            return   ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), ResponseCode.NEED_LOGIN.getDesc());
        }
        return icartService.selectOrUnSelect(user.getId(),productId, Const.Cart.UN_CHENCKED) ;
    }




}
