package com.tefg.service;

import com.github.pagehelper.PageInfo;
import com.tefg.common.ServerResponse;
import com.tefg.pojo.Shipping;

/**
 * @author 贺威
 * @create 2018-11-13 16:53
 */
public interface IShippingService {

    /**
     * 添加地址
     * @param userId
     * @param shipping
     * @return
     */
    ServerResponse add(Integer userId, Shipping shipping);

    /**
     * 删除地址
     * @param userId
     * @param shippingId
     * @return
     */
    ServerResponse<String> del(Integer userId, Integer shippingId);

    /**
     * 更新地址
     * @param id
     * @param shipping
     * @return
     */
    ServerResponse update(Integer id, Shipping shipping);

    /**
     * 获取地址详情
     * @param userId
     * @param shippingId
     * @return
     */
    ServerResponse<Shipping> select(Integer userId, Integer shippingId);


    /**
     * 分页
     * @param pageNum
     * @param pageSize
     * @param userId
     * @return
     */
    ServerResponse<PageInfo> List(Integer pageNum, Integer pageSize, Integer userId);
}
