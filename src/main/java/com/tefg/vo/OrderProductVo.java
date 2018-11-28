package com.tefg.vo;

import java.util.List;

/**
 * @author 曾敬伟
 * @date 2018/11/20 - 18:13
 */
public class OrderProductVo {

    private List<OrderItemVo> orderItemVoList;
    private Double productTotalPrice;           //总价
    private String imageHost;                   //图片服务器地址

    public List<OrderItemVo> getOrderItemVoList() {
        return orderItemVoList;
    }

    public void setOrderItemVoList(List<OrderItemVo> orderItemVoList) {
        this.orderItemVoList = orderItemVoList;
    }

    public Double getProductTotalPrice() {
        return productTotalPrice;
    }

    public void setProductTotalPrice(Double productTotalPrice) {
        this.productTotalPrice = productTotalPrice;
    }

    public String getImageHost() {
        return imageHost;
    }

    public void setImageHost(String imageHost) {
        this.imageHost = imageHost;
    }
}
