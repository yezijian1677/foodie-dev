package com.imooc.mapper;

import com.imooc.pojo.OrderStatus;
import com.imooc.vo.MyOrdersVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author augenye
 * @date 2019/11/16 1:15 下午
 */
public interface OrdersMapperCustom {

    List<MyOrdersVO> queryMyOrders(@Param("paramsMap") Map<String, Object> map);

    int getMyOrderStatusCounts(@Param("paramsMap") Map<String, Object> map);

    List<OrderStatus> getMyOrderTrend(@Param("paramsMap") Map<String, Object> map);
}
