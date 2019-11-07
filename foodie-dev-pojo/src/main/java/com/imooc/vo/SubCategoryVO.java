package com.imooc.vo;

import lombok.Data;

/**
 * @author augenye
 * @date 2019/11/7 2:46 下午
 */
@Data
public class SubCategoryVO {

    private Integer subId;
    private String subName;
    private String subType;
    private Integer subFatherId;

}
