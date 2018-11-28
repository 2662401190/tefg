package com.tefg.dao;

import com.tefg.pojo.OrderItem;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderItemMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(OrderItem record);

    int insertSelective(OrderItem record);

    OrderItem selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(OrderItem record);

    int updateByPrimaryKey(OrderItem record);
    /**
     * 根据订单号与用户Id查询商品
     * @param orderNo
     * @param userId
     * @return
     */
    List<OrderItem> getByOrderNoUserId(@Param("orderNo") Long orderNo, @Param("userId") Integer userId);

    /**
     * 批量插入
     * @param orderItemList
     */
    void batchInsert(@Param("orderItemList") List<OrderItem> orderItemList);
    /**
     * 管理员查询
     * @param orderNo
     * @return
     */
    List<OrderItem> getByOrderNo(@Param("orderNo") Long orderNo);
}