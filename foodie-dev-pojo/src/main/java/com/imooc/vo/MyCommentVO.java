package com.imooc.vo;

import lombok.Data;

import java.util.Date;

/**
 * @author augenye
 * @date 2019/11/16 8:02 下午
 */
@Data
public class MyCommentVO {
    private String commentId;
    private String content;
    private Date createdTime;
    private String itemId;
    private String itemName;
    private String specName;
    private String itemImg;
}
