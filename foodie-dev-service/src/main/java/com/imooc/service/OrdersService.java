package com.imooc.service;

import com.imooc.bo.SubmitOrderBO;

import java.util.List;

/**
 * @author augenye
 * @date 2019/11/9 4:48 下午
 */
public interface OrdersService {

    /**
     * 创建订单相关信息
     *
     * @param submitOrderBO 订单
     */
    void createOrder(SubmitOrderBO submitOrderBO);

}
