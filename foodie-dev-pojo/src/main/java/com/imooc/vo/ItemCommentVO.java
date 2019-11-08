package com.imooc.vo;

import lombok.Data;

/**
 * 用于展示商品评价的VO
 * @author augenye
 * @date 2019/11/8 10:47 上午
 */
@Data
public class ItemCommentVO {

    private Integer commentLevel;
    private String content;
    private String specName;
    private String createdTime;
    private String userFace;
    private String nickname;

}

