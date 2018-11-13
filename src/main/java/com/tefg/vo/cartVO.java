package com.tefg.vo;

import java.util.List;

/**
 * @author 贺威
 * @create 2018-11-12 15:34
 */
public class cartVO {


     private List<cartProduct> cartProductList;

    /**
     * 购物车商品总价
     */
    private Double cartTotalPrice;
    /**
     * 是否都勾选
     */
    private Boolean allChecked;

    private String imageHost;


    public List<cartProduct> getCartProductList() {
        return cartProductList;
    }

    public void setCartProductList(List<cartProduct> cartProductList) {
        this.cartProductList = cartProductList;
    }

    public Double getCartTotalPrice() {
        return cartTotalPrice;
    }

    public void setCartTotalPrice(Double cartTotalPrice) {
        this.cartTotalPrice = cartTotalPrice;
    }

    public Boolean getAllChecked() {
        return allChecked;
    }

    public void setAllChecked(Boolean allChecked) {
        this.allChecked = allChecked;
    }

    public String getImageHost() {
        return imageHost;
    }

    public void setImageHost(String imageHost) {
        this.imageHost = imageHost;
    }
}
