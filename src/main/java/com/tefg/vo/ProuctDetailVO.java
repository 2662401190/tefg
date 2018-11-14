package com.tefg.vo;

/**
 * @author 贺威
 * @create 2018-11-07 11:44
 */
public class ProuctDetailVO {


    private Integer id;
    private Integer category; // 种类
    private String name;
    private String subtitle; // 副标题
    private String mainImage;// 主图片
    private String subimages;// 小图片
    private String detail;  //描述
    private Double price;  //价格
    private Integer stock; //库存
    private Integer statucs; //状态
    private String createTime;// 创建时间
    private String updateTime;// 更新时间

    private String imageHost;  // 图片服务器url的前缀
    private Integer parenCategory; //父分类

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCategory() {
        return category;
    }

    public void setCategory(Integer category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getMainImage() {
        return mainImage;
    }

    public void setMainImage(String mainImage) {
        this.mainImage = mainImage;
    }

    public String getSubimages() {
        return subimages;
    }

    public void setSubimages(String subimages) {
        this.subimages = subimages;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Integer getStatucs() {
        return statucs;
    }

    public void setStatucs(Integer statucs) {
        this.statucs = statucs;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public String getImageHost() {
        return imageHost;
    }

    public void setImageHost(String imageHost) {
        this.imageHost = imageHost;
    }

    public Integer getParenCategory() {
        return parenCategory;
    }

    public void setParenCategory(Integer parenCategory) {
        this.parenCategory = parenCategory;
    }
}
