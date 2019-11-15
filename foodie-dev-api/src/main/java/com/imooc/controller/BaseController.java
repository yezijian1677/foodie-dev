package com.imooc.controller;

import org.springframework.stereotype.Controller;

import java.io.File;

/**
 * @author augenye
 * @date 2019-11-04 22:58
 */
@Controller
public class BaseController {

    public static final String FOODIE_SHOPCART = "shopcart";

    public static final Integer COMMENT_PAGE_SIZE = 10;
    public static final Integer PAGE_SIZE = 20;

    //微信支付中心 -> 支付中心 -> 天天吃货平台
    //                   ｜回调中心的Url
    String payReturnUrl = "http://bnxqj6.natappfree.cc/orders/notifyMerchantOrderPaid";

    // 支付中心的地址
    String paymentUrl = "http://payment.t.mukewang.com/foodie-payment/payment/createMerchantOrder";

    public static final String IMAGE_USER_FACE_LOCATION = File.separator + "Users" +
            File.separator + "yezijian" +
            File.separator + "project" +
            File.separator + "foodie-dev" +
            File.separator + "images" +
            File.separator + "foodie" +
            File.separator + "faces";

}
