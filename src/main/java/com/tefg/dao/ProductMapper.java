package com.tefg.dao;

import com.tefg.pojo.Product;
import org.apache.ibatis.annotations.Param;

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
     * @return
     */
    List<Product> products_list();


    /**
     * 搜索查询
     * @param productName
     * @param prodictId
     * @return
     */
    List<Product> selectByNameAndProduct(@Param("name") String productName,@Param("id")Integer prodictId);

    // 前台


    /**
     * 搜搜查询
     * @param productName
     * @param categoryIdList
     * @return
     */
    List<Product> selectByNameAndCategoryIds(@Param("productName") String productName,@Param("productIdList") List<Integer> categoryIdList);
}