package com.tefg.service;

import com.github.pagehelper.PageInfo;
import com.tefg.common.ServerResponse;
import com.tefg.pojo.Product;
import com.tefg.vo.ProductListVo;
import com.tefg.vo.ProuctDetailVO;

import java.util.List;

/**
 * @author 贺威
 * @create 2018-11-07 10:05
 */
public interface IProductService {

    /**
     * 保存商品或者更新商品
     * @param product
     * @return
     */
    ServerResponse saveORupdateProduct(Product product);

    /**
     * 商品的上下架
     * @param productId
     * @param status
     * @return
     */
    ServerResponse<String> setSaleStatus(Integer productId, Integer status);

    /**
     * 获取商品的详情
     * @param productId
     * @return
     */
    ServerResponse<ProuctDetailVO> managePrdouctDetail(Integer productId);

    /**
     * 商品分类信息
     * @param pageNum
     * @param pageSize
     * @return
     */
    ServerResponse getProductList(Integer pageNum, Integer pageSize);


    /**
     * 搜索商品
     * @param productName
     * @param productId
     * @param pageNum
     * @param pageSize
     * @return
     */
    ServerResponse<PageInfo> searchPaoduct(String productName, Integer productId, Integer pageNum, Integer pageSize);


    //todo   前台

    /**
     * 获取商品详情
     * @param productId
     * @return
     */
    ServerResponse<ProuctDetailVO> getProductDetail(Integer productId);


    /**
     * 商品搜索及分页
     * @param keyword
     * @param categoryId
     * @param pageNum
     * @param pageSize
     * @param orderBy
     * @return
     */
    ServerResponse<PageInfo> getProdictByKeywordCategory(String keyword, Integer categoryId, int pageNum, int pageSize, String orderBy);


    /**
     * 一级
     * @param categoryId
     * @param pageNum
     * @param pageSize
     * @return
     */
    PageInfo productSearch(Integer categoryId,int pageNum,int pageSize);


    /**
     * 二级
     * @param categoryId
     * @param pageNum
     * @param pageSize
     * @return
     */
    PageInfo productSearchWithTwo(Integer categoryId,int pageNum,int pageSize);


    /**
     * 新出的三件商品
     * @return
     */
    List<ProductListVo> newThreeProduct();


    /**
     * 给钱的十件商品
     * @return
     */
    ServerResponse<List<ProductListVo>> moneyTen();
    /**
     * 电子产品
     * @param categoryId
     * @return
     */
    ServerResponse<List<ProductListVo>> electronicsTopFive(Integer categoryId);

}
