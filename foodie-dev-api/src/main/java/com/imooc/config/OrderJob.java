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
    /**
     * 测试打字的速度为什么我要联系新的打字方法，改变正着旧的打字方法呢，我也不知道啊，我现在到底可以用到几根手指，我也不知道自己能用到几根手机
     * 到底怎么改啊，适应不过来，我要咋办嘛，太难了嗷
     * 使用定时任务关闭超期未支付的订单，会存在的弊端
     * 1。 会有时间差，程序不严谨
     * 不支持集群
     * 单机没毛病，但是集群后，就会有多个定时任务，
     * 解决方案：只使用一台计算机节点，单独用来运行所有的定时任务
     * 延时队列
     */
}
