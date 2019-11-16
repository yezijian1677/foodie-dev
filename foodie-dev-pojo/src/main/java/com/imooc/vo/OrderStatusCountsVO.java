package com.imooc.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author augenye
 * @date 2019/11/16 8:52 下午
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderStatusCountsVO {

    private Integer waitPayCounts;
    private Integer waitDeliverCounts;
    private Integer waitReceiveCounts;
    private Integer waitCommentCounts;
}
