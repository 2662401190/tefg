package com.tefg.service;

import com.tefg.common.ServerResponse;
import com.tefg.vo.cartVO;

/**
 * @author 贺威
 * @create 2018-11-12 14:11
 */
public interface IcartService {

    /**
     * 加入到购物车
     * @param userId
     * @param productId
     * @param count
     * @return
     */
    ServerResponse<cartVO> add(Integer userId, Integer productId, Integer count);

    /**
     * 更新购物车
     * @param userId
     * @param productId
     * @param count
     * @return
     */
    ServerResponse<cartVO> update(Integer userId, Integer productId, Integer count);

    /**
     * 删除商品
     * @param userId
     * @param productIds
     * @return
     */
    ServerResponse<cartVO> delectProduct(Integer userId, String productIds);

    /**
     * 查询
     * @param userId
     * @return
     */
    ServerResponse<cartVO> list(Integer userId);


    /**
     * 获取 购物车商品总数
     * @param userId
     * @return
     */
    ServerResponse<Integer> getCartProductCount(Integer userId);

    /**
     * 全选或者全不选
     * @param userId
     * @param cheked
     * @return
     */
    ServerResponse<cartVO> selectOrUnSelect(Integer userId, Integer productId, Integer cheked);
}
