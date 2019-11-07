package com.imooc.vo;

import lombok.Data;

import java.util.List;

/**
 * @author augenye
 * @date 2019/11/7 7:10 下午
 */
@Data
public class NewItemsVO {

    private Integer rootCatId;
    private String rootCatName;
    private String slogan;
    private String catImage;
    private String bgColor;

    private List<SimpleItemVO> simpleItemList;
}
