package com.imooc.service.center;

import com.imooc.pojo.Orders;
import com.imooc.utils.PagedGridResult;
import com.imooc.vo.OrderStatusCountsVO;

/**
 * @author augenye
 * @date 2019/11/16 1:34 下午
 */
public interface MyOrdersService {

    /**
     * 查询我的订单列表
     * @param userId
     * @param orderStatus
     * @param page
     * @param pageSize
     * @return
     */
    PagedGridResult queryMyOrders(String userId, Integer orderStatus, Integer page, Integer pageSize);

    /**
     * 更新订单发货状态
     * @param orderId
     */
    void updateDeliverOrderStatus(String orderId);

    /**
     * 查询订单归属
     * @param userId
     * @param orderId
     * @return
     */
    Orders queryMyOrder(String userId, String orderId);

    /**
     * 更新订单确认收货
     * @param orderId
     * @return
     */
    boolean updateReceiveOrderStatus(String orderId);

    /**
     * 删除订单
     * @param userId
     * @param orderId
     * @return
     */
    boolean deleteOrder(String userId, String orderId);

    /**
     * 根据用户id查询订单
     * @param userId
     */
    OrderStatusCountsVO getOrderStatusCounts(String userId);

    /**
     * 获得分页的订单动向
     * @param userId
     * @param page
     * @param pageSize
     * @return
     */
    PagedGridResult getOrdersTrend(String userId, Integer page, Integer pageSize);



}
