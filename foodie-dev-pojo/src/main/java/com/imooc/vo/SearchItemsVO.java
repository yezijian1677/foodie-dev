package com.imooc.vo;

import lombok.Data;

/**
 * 用于展示商品评价的VO
 * @author augenye
 * @date 2019/11/8 10:47 上午
 */
@Data
public class SearchItemsVO {

    private String itemId;
    private String itemName;
    private Integer sellCounts;
    private String imgUrl;
    private int price;//分为单位

}

