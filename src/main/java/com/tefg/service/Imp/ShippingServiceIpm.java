package com.tefg.service.Imp;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Maps;
import com.tefg.common.ServerResponse;
import com.tefg.dao.ShippingMapper;
import com.tefg.pojo.Shipping;
import com.tefg.service.IShippingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author 贺威
 * @create 2018-11-13 16:54
 */
@Service("iShippingService")
public class ShippingServiceIpm implements IShippingService {

    @Autowired
    private ShippingMapper shippingMapper;

    /**
     *  添加地址
     * @param userId
     * @param shipping
     * @return
     */
    @Override
    public ServerResponse add(Integer userId, Shipping shipping) {

        shipping.setUserId(userId);

        int rowCount = shippingMapper.insert(shipping);

        if (rowCount > 0) {
            Map result= Maps.newHashMap();
            result.put("shippingId", shipping.getId());
            return ServerResponse.createBySuccess("新建地址成功", result);
        }

        return ServerResponse.createByErrorMessage("新建地址失败");
    }


    /**
     * 删除地址
     * @param userId
     * @param shippingId
     * @return
     */
    @Override
    public ServerResponse<String> del(Integer userId, Integer shippingId){

        int rowCount = shippingMapper.deleteByShippingIdWithUserId(userId, shippingId);

        if (rowCount > 0) {
            return ServerResponse.createBySuccess("删除地址成功");
        }

        return ServerResponse.createByErrorMessage("删除地址失败");

    }

    /**
     * 更新地址
     * @param userId
     * @param shipping
     * @return
     */
    @Override
    public ServerResponse update(Integer userId, Shipping shipping){
        shipping.setUserId(userId);
        int rowCount = shippingMapper.updateByPrimary(shipping);
        if (rowCount > 0) {
            return ServerResponse.createBySuccess("更新地址成功");
        }

        return ServerResponse.createByErrorMessage("更新地址失败");
    }


    /**
     * 获取地址详情
     * @param userId
     * @param shippingId
     * @return
     */
    @Override
    public ServerResponse<Shipping> select(Integer userId, Integer shippingId){
        Shipping shipping = shippingMapper.selectByShippingIdUserId(userId, shippingId);
        if (shipping == null) {
            return ServerResponse.createByErrorMessage("无法查询到该地址");
        }
        return ServerResponse.createBySuccess("更新地址成功",shipping);
    }

    /**
     * 分页
     * @param pageNum
     * @param pageSize
     * @param userId
     * @return
     */
    @Override
    public ServerResponse<PageInfo> List(Integer pageNum, Integer pageSize, Integer userId) {

        PageHelper.startPage(pageNum, pageSize);
        List<Shipping> shippingList = shippingMapper.selectByUserId(userId);

        PageInfo info = new PageInfo(shippingList);
        return ServerResponse.createBySuccess(info);
    }
}
