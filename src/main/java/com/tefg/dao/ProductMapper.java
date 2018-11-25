package com.tefg.dao;

import com.tefg.pojo.Product;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ProductMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Product record);

    int insertSelective(Product record);

    Product selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Product record);

    int updateByPrimaryKey(Product record);

    /**
     * 查询 商品集合
     *
     * @return
     */
    List<Product> products_list();


    /**
     * 搜索查询
     *
     * @param productName
     * @param prodictId
     * @return
     */
    List<Product> selectByNameAndProduct(@Param("productName") String productName, @Param("id") Integer prodictId);

    // 前台


    /**
     * 搜搜查询
     *
     * @param productName
     * @param categoryIdList
     * @return
     */
    List<Product> selectByNameAndCategoryIds(@Param("productName") String productName, @Param("productIdList") List<Integer> categoryIdList);


    /**
     * 一级
     *
     * @param categoryId
     * @return
     */
    List<Product> productSearch(Integer categoryId);


    /**
     * 二级
     *
     * @param categoryId
     * @return
     */
    List<Product> productSearchTwo(Integer categoryId);


    /**
     * 查询最新的三件商品
     * @return
     */
    @Select("select * from tefg_product ORDER BY id  desc limit 3")
    List<Product> newThreeProduct();


    /**
     *
     * todo给钱推荐的十件商品
     * @return
     */
    @Select("SELECT * FROM tefg_product ORDER BY stock DESC  LIMIT 5")
    List<Product>  moneyTen();


    List<Product> electronicsTopFive(Integer categoryId);

}