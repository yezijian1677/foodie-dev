package com.imooc.bo;

import lombok.Data;
import lombok.ToString;

/**
 * @author augenye
 * @date 2019/11/8 7:05 下午
 */
@Data
@ToString
public class ShopcartBO {
    private String itemId;
    private String itemImgUrl;
    private String itemName;
    private String specId;
    private String specName;
    private String buyCounts;
    private String priceDiscount;
    private String priceNormal;
}
