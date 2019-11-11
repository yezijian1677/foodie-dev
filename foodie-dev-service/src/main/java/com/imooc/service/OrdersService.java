package com.imooc.service;

import com.imooc.bo.SubmitOrderBO;
import com.imooc.pojo.OrderStatus;
import com.imooc.vo.OrderVO;

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
    OrderVO createOrder(SubmitOrderBO submitOrderBO);

    /**
     * 修改订单状态
     * @param orderId orderId
     * @param orderStatus orderStatus
     */
    void updateOrderStatus(String orderId, Integer orderStatus);

    /**
     * 查询订单状态
     * @return
     */
    OrderStatus queryOrderStatusInfo(String orderId);

    /**
     * 关闭超时为支付订单
     */
    void closeOrder();

}
