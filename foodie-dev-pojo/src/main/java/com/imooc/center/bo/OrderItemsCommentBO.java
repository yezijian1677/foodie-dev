package com.imooc.center.bo;

import lombok.Data;
import lombok.ToString;

/**
 * @author augenye
 * @date 2019/11/16 5:43 下午
 */
@Data
public class OrderItemsCommentBO {

    private String commentId;
    private String itemId;
    private String itemName;
    private String itemSpecId;
    private String itemSpecName;
    private Integer commentLevel;
    private String content;

}
