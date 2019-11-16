package com.imooc.vo;

import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @author augenye
 * @date 2019/11/16 1:20 下午
 */

@Data
public class MyOrdersVO {

    private String orderId;
    private Date createdTime;
    private Integer payMethod;
    private Integer realPayAmount;
    private Integer postAmount;
    private Integer isComment;
    private Integer orderStatus;

    private List<MySubOrderItemVO> subOrderItemList;

}
