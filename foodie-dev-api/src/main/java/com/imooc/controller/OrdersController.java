package com.imooc.controller;

import com.imooc.bo.SubmitOrderBO;
import com.imooc.enums.PayMethod;
import com.imooc.service.OrdersService;
import com.imooc.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author augenye
 * @date 2019/11/9 3:17 下午
 */
@Slf4j
@Api(value = "订单相关", tags = {"订单相关的api接口"})
@RequestMapping("orders")
@RestController
public class OrdersController {

    @Autowired
    private OrdersService ordersService;

    @ApiOperation(value = "创建订单", notes = "创建订单")
    @PostMapping("/create")
    public Result create(@RequestBody SubmitOrderBO submitOrderBO) {

        if (submitOrderBO.getPayMethod() != PayMethod.WEIXIN.type && submitOrderBO.getPayMethod() != PayMethod.ALIPAY.type) {
            return Result.errorMsg("请选择支付方式");
        }
        
        log.info("order info: {}", submitOrderBO.toString());

        // 1. 创建订单
        ordersService.createOrder(submitOrderBO);

        // 2. 创建订单以后，移除购物车中已结算或提交的商品
        // 3. 支付中心发送订单，保存支付中心的订单数据
        
        return Result.ok();
    }
}
