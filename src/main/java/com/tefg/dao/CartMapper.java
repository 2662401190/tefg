package com.tefg.dao;

import com.tefg.pojo.Cart;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CartMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Cart record);

    int insertSelective(Cart record);

    Cart selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Cart record);

    int updateByPrimaryKey(Cart record);

    /**
     * 查询购物车
     *
     * @param userId
     * @param productId
     * @return
     */
    Cart selectCartByUserIdWithProductId(@Param("userId") Integer userId, @Param("productId") Integer productId);

    /**
     * 查询购物车集合
     * @param id
     * @return
     */
    List<Cart> selectCartByUserId(Integer id);


    int selectCartProductCheckedStatusByUserId(Integer userId);

    /**
     *  批量删除
     * @param userId
     * @param productIds
     * @return
     */
    int deleteByUserIdProductIds(@Param("userId") Integer userId, @Param("productIds") List<String> productIds);


    /**
     * 全选 或者 全不选
     * @param userId
     * @param cheked
     * @return
     */
    int checkedOrUncheckedAProduct(@Param("userId") Integer userId,@Param("productId") Integer productId,@Param("checked") Integer cheked);


    /**
     * 获取购物车中商品的数量
     * @param userId
     * @return
     */
    int selectCartProuctCount(Integer userId);

    /**
     * 从购物车中获取已选中的商品
     * @param userId
     * @return
     */
    List<Cart> selectCheckedCartByUserId(Integer userId);
}