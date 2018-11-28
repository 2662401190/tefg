package com.tefg.dao;

import com.tefg.pojo.Order;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Order record);

    int insertSelective(Order record);

    Order selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);
    /**
     * 查询传过来的用户Id和订单号是否存在
     * @param userId
     * @param orderNo
     * @return
     */
    Order selectByUserIdAndOrderNo(@Param("userId") Integer userId, @Param("orderNo") Long orderNo);

    /**
     * 根据传过来的orderNo订单号查询订单号是否存在
     * @param orderNo
     * @return
     */
    Order selectByOrderNo(Long orderNo);

    /**
     * 获取用户订单的集合
     * @param userId
     * @return
     */
    List<Order> selectByUserId(Integer userId);

    /**
     * 分页查询所有的订单
     * @return
     */
    List<Order> selectAllOrder();
}