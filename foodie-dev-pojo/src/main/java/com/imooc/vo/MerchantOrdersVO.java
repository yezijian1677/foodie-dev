package com.imooc.vo;

import lombok.Data;

/**
 * @author augenye
 * @date 2019/11/11 2:34 下午
 */
@Data
public class MerchantOrdersVO {

    private String merchantOrderId;
    private String merchantUserId;
    private Integer amount;
    private Integer payMethod;
    private String returnUrl;

}
