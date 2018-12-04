package com.tefg.dao;

import com.tefg.pojo.Shipping;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ShippingMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Shipping record);

    int insertSelective(Shipping record);

    Shipping selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Shipping record);

    int updateByPrimaryKey(Shipping record);


    /**
     * 删除
     * @param userId
     * @param shippingId
     * @return
     */
    int deleteByShippingIdWithUserId(@Param("userId") Integer userId,@Param("shippingId") Integer shippingId);


    int updateByPrimary(Shipping record);

    Shipping selectByShippingIdUserId(@Param("userId") Integer userId,@Param("shippingId") Integer shippingId);

    List<Shipping> selectByUserId(Integer userId);



}