package com.imooc.config;

import com.imooc.service.OrdersService;
import com.imooc.utils.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author augenye
 * @date 2019/11/11 7:04 下午
 */
@Component
public class OrderJob {

    @Autowired
    private OrdersService ordersService;

    @Scheduled(cron = "0/3 * * * * ? ")
    public void autoCloseOrder() {

        ordersService.closeOrder();
        System.out.println("定时执行任务，当前时间为："+ DateUtil.getCurrentDateString(DateUtil.DATETIME_PATTERN));
    }
}
