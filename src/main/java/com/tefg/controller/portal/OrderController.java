package com.tefg.controller.portal;

import com.alipay.api.AlipayApiException;
import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.demo.trade.config.Configs;
import com.google.common.collect.Maps;
import com.tefg.common.Const;
import com.tefg.common.ResponseCode;
import com.tefg.common.ServerResponse;
import com.tefg.dao.ShippingMapper;
import com.tefg.pojo.Shipping;
import com.tefg.pojo.User;
import com.tefg.service.IOrderService;
import com.tefg.vo.Ordervo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Iterator;
import java.util.Map;

/**
 * @author 曾敬伟
 * @date 2018/11/26 - 12:21
 */
@Controller
@RequestMapping("/order/")
public class OrderController {


    //生成日志
    private static final Logger logger = LoggerFactory.getLogger(OrderController.class);

    @Autowired
    private IOrderService iOrderService;
    @Autowired
    private ShippingMapper shippingMapper;

    /**
     * 创建订单
     * @param session
     * @param shippingId    发货地址的id
     * @return
     */
    @RequestMapping("create.do")
    public String create(HttpSession session,@RequestParam(value = "shippingId") Integer shippingId,Model model) {
        System.out.println("进入");
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if (user == null) {
            return "user-login";
        }
        Shipping shipping = shippingMapper.selectByShippingIdUserId(user.getId(),shippingId);
        if (shipping == null) {
            ServerResponse message = ServerResponse.createByErrorMessage("请填写收货地址");
            model.addAttribute("message",message);
            return "index";
        }
        ServerResponse orderDetail = iOrderService.createOrder(user.getId(), shippingId);
        model.addAttribute("orderDetail",orderDetail);
        return "/porde/create";
    }

    /**
     * 未付款的状态下取消订单
     * @param session
     * @param orderNo
     * @return
     */
    @RequestMapping("cancel.do")
    @ResponseBody
    public ServerResponse cancel(HttpSession session, Long orderNo) {
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if (user == null) {
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), ResponseCode.NEED_LOGIN.getDesc());
        }
        return iOrderService.cancel(user.getId(),orderNo);
    }


    /**
     * 获取购物车选中的商品
     * @param session
     * @return
     */
    @RequestMapping("get_order_cart_product.do")
    @ResponseBody
    public ServerResponse getOrderCartProduct(HttpSession session) {
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if (user == null) {
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), ResponseCode.NEED_LOGIN.getDesc());
        }
        return iOrderService.getOrderCartProduct(user.getId());
    }

    /**
     * 获取订单详情
     * @param session
     * @param orderNo
     * @return
     */
    @RequestMapping("detail.do")
    @ResponseBody
    public ServerResponse detail(HttpSession session,@RequestParam(value ="orderNo" ) Long orderNo) {
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if (user == null) {
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(),ResponseCode.NEED_LOGIN.getDesc());
        }
        return iOrderService.getOrderDetail(user.getId(), orderNo);
    }



    /**
     * 个人中心查看我的订单
     * @param session
     * @param pageNUm
     * @return
     */
    @RequestMapping("list.do")
    @ResponseBody
    public ServerResponse list(HttpSession session, @RequestParam(value = "pageNum",defaultValue = "1")int pageNUm, @RequestParam(value = "pageSize",defaultValue = "3") int pageSize) {
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        System.out.println(user);
        if (user == null) {
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(),ResponseCode.NEED_LOGIN.getDesc());
        }
        return iOrderService.getOrderList(user.getId(), pageNUm, pageSize);
    }



    /**
     * 支付订单
     * @param session 判断用户登录
     * @param orderNo 支付订单号
     * @param request
     * @return
     */
    @RequestMapping("pay.do")
    public String pay(HttpSession session,@RequestParam(value = "orderNo") long orderNo, HttpServletRequest request,Model model) {
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if (user == null) {
            return "user-login";
        }
        String path = request.getSession().getServletContext().getRealPath("upload");

        ServerResponse pay = iOrderService.pay(orderNo, user.getId(), path);
        model.addAttribute("pay",pay);
        return "/porde/pay";
    }

    /**
     * 回调函数
     * @param request
     * @return
     */
    @RequestMapping("alipay_callback.do")
    @ResponseBody
    public Object alipayCallback(HttpServletRequest request) {
        Map<String, String> params = Maps.newHashMap();
        Map requestParams = request.getParameterMap();
        //迭代器去取出数据
        for (Iterator iter = requestParams.keySet().iterator(); iter.hasNext(); ) {
            String name = (String) iter.next();
            String[] values = (String[]) requestParams.get(name);
            String valueStr = "";
            for (int i = 0; i < values.length; i++) {
                valueStr = (i == values.length - 1) ? valueStr + values[i] : valueStr + values[i] + ",";
            }
            params.put(name, valueStr);
        }
        logger.info("支付宝回调,sign:{},trade_status:{},参数:{}", params.get("sign"), params.get("trade_status"), params.toString());

        //非常重要,验证回调的正确性,是不是支付宝发的,并且还要避免重复通知
        params.remove("sign_type");
        try {
            boolean alipayRSACheckedV2 = AlipaySignature.rsaCheckV2(params, Configs.getAlipayPublicKey(),"utf-8",Configs.getSignType());
            if(!alipayRSACheckedV2){
                return ServerResponse.createByErrorMessage("非法请求,验证不通过");
            }
        }catch (AlipayApiException e){
            logger.error("支付宝验证回调异常",e);
        }
        //todo 验证各种数据

        ServerResponse serverResponse = iOrderService.aliCallback(params);
        if(serverResponse.isSuccess()){
            return Const.AlipayCallback.RESPONSE_SUCCESS;
        }
        return Const.AlipayCallback.RESPONSE_FAILED;
    }


    /**
     * 前台查询订单状态,验证是否支付成功,成功则跳到订单页面
     * @param session
     * @param orderNo
     * @return
     */
    @RequestMapping("query_order_pay_status.do")
    @ResponseBody
    public ServerResponse<Boolean> queryOrderPayStatus(HttpSession session, long orderNo) {
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if (user == null) {
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), ResponseCode.NEED_LOGIN.getDesc());
        }
        ServerResponse<Boolean> serverResponse = iOrderService.queryOrderPayStatus(user.getId(),orderNo);
        if(serverResponse.isSuccess()){
            return ServerResponse.createBySuccess(true);
        }
        return ServerResponse.createBySuccess(false);
    }
}
