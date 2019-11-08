package com.imooc.vo;

import lombok.Data;

/**
 * @author augenye
 * @date 2019/11/8 7:05 下午
 */
@Data
public class ShopCartVO {
    private String itemId;
    private String itemImgUrl;
    private String itemName;
    private String specId;
    private String specName;
    private String priceDiscount;
    private String priceNormal;
}
