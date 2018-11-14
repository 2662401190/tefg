package com.tefg.vo;

/**
 * 结合了产品和购物车的一个抽象对象
 * @author 贺威
 * @create 2018-11-12 15:20
 */
public class cartProduct {

    private Integer id;
    private Integer userId;
    private Integer productId;
    /**
     * 购物车中商品的数量
     */
    private Integer quantity;

    private String productName;
    private String productSubtitle;
    private String productMainImage;
    private Double productPrice;
    private Integer productStatuts;
    /**
     * 产品总价
     */
    private Double productTotalPrice;

    /**
     * 产品库存
     */
    private Integer productStock;

    /**
     * 此商品是否勾选
     */
    private Integer productChecked;

    /**
     * 限制数量的一个返回结果
     */
    private String limitQuantity;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductSubtitle() {
        return productSubtitle;
    }

    public void setProductSubtitle(String productSubtitle) {
        this.productSubtitle = productSubtitle;
    }

    public String getProductMainImage() {
        return productMainImage;
    }

    public void setProductMainImage(String productMainImage) {
        this.productMainImage = productMainImage;
    }

    public Double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Double productPrice) {
        this.productPrice = productPrice;
    }

    public Integer getProductStatuts() {
        return productStatuts;
    }

    public void setProductStatuts(Integer productStatuts) {
        this.productStatuts = productStatuts;
    }

    public Double getProductTotalPrice() {
        return productTotalPrice;
    }

    public void setProductTotalPrice(Double productTotalPrice) {
        this.productTotalPrice = productTotalPrice;
    }

    public Integer getProductStock() {
        return productStock;
    }

    public void setProductStock(Integer productStock) {
        this.productStock = productStock;
    }

    public Integer getProductChecked() {
        return productChecked;
    }

    public void setProductChecked(Integer productChecked) {
        this.productChecked = productChecked;
    }

    public String getLimitQuantity() {
        return limitQuantity;
    }

    public void setLimitQuantity(String limitQuantity) {
        this.limitQuantity = limitQuantity;
    }
}
