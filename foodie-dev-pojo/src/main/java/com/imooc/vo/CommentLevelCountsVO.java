package com.imooc.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 用于展示商品评价数的VO
 * @author augenye
 * @date 2019/11/7 10:23 下午
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentLevelCountsVO {

    private Integer totalCounts;
    private Integer goodCounts;
    private Integer normalCounts;
    private Integer badCounts;

}
