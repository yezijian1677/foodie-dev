package com.imooc.vo;

import lombok.Data;

/**
 * @author augenye
 * @date 2019/11/16 1:23 下午
 */
@Data
public class MySubOrderItemVO {

    private String itemId;
    private String itemImg;
    private String itemName;
    private String itemSpecId;
    private String itemSpecName;
    private Integer buyCounts;
    private Integer price;
}
