package com.tefg.service;


import com.github.pagehelper.PageInfo;
import com.tefg.common.ServerResponse;
import com.tefg.vo.Ordervo;

import java.util.Map;

/**
 * @author 曾敬伟
 * @date 2018/11/26 - 12:21
 */
public interface IOrderService {
    //支付订单
    ServerResponse pay(Long orderNo, Integer userId, String path);
    //处理alipay回调地址的逻辑,更新订单状态,判断订单是否支付
    ServerResponse aliCallback(Map<String, String> params);
    //查询订单状态
    ServerResponse queryOrderPayStatus(Integer userId, Long orderNo);
    //获取购物车中已选中的商品创建订单
    ServerResponse createOrder(Integer userId, Integer shippingId);
    //取消订单
    ServerResponse<String> cancel(Integer userId, Long orderNo);
    //获取购物车选中的商品
    ServerResponse getOrderCartProduct(Integer userId);
    //获取订单详情
    ServerResponse<Ordervo> getOrderDetail(Integer userId, Long orderNo);
    //个人中心查看我的订单
    ServerResponse<PageInfo> getOrderList(Integer userId, int pageNum, int pageSize);
    //分页查询订单信息
    ServerResponse<PageInfo> manageList(int pageNum, int pageSize);
    //查看后台订单详情
    ServerResponse<Ordervo> manageDetail(Long orderNo);
    //按订单号查询
    ServerResponse<PageInfo> manageSearch(Long orderNo, int pageNum, int pageSize);
    //按订单号发货
    ServerResponse<String> manageSendGoods(Long orderNo);
}
