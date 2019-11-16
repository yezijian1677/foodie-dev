package com.imooc.service.center;

import com.imooc.center.bo.OrderItemsCommentBO;
import com.imooc.pojo.OrderItems;
import com.imooc.utils.PagedGridResult;

import java.util.List;

/**
 * @author augenye
 * @date 2019/11/16 5:11 下午
 */
public interface MyCommentService {

    /**
     * 根据订单id查询关联的商品
     * @param orderId
     * @return
     */
    List<OrderItems> queryPendingComment(String orderId);

    /**
     * 保存商品评论
     * @param orderId
     * @param userId
     * @param commentList
     */
    void saveComments(String orderId, String userId, List<OrderItemsCommentBO> commentList);

    /**
     * 查询我的评价
     * @param userId
     * @param page
     * @param pageSize
     * @return
     */
    PagedGridResult queryMyComments(String userId, Integer page, Integer pageSize);
}
