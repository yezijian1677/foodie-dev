package com.imooc.bo;

import lombok.Data;
import lombok.ToString;

/**
 * 用于创建订单的BO对象
 * @author augenye
 * @date 2019/11/9 3:20 下午
 */
@Data
@ToString
public class SubmitOrderBO {
    private String userId;
    private String itemSpecIds;
    private String addressId;
    private Integer payMethod;
    private String leftMsg;
}
