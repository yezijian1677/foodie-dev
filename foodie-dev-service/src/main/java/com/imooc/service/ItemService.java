package com.imooc.service;

import com.imooc.pojo.Items;
import com.imooc.pojo.ItemsImg;
import com.imooc.pojo.ItemsParam;
import com.imooc.pojo.ItemsSpec;
import com.imooc.vo.CommentLevelCountsVO;

import java.util.List;

/**
 * @author augenye
 * @date 2019/11/7 2:10 下午
 */
public interface ItemService {

    /**
     * 根据商品id查询详情
     *
     * @param itemId id
     * @return items
     */
    Items queryItemById(String itemId);


    /**
     * 根据id查询商品图片
     *
     * @param itemId
     * @return
     */
    List<ItemsImg> queryItemImgList(String itemId);


    /**
     * 根据id查询商品规格
     *
     * @param itemId
     * @return
     */
    List<ItemsSpec> queryItemsSpecList(String itemId);


    /**
     * 根据id查询商品属性
     *
     * @param itemId
     * @return
     */
    ItemsParam queryItemsParam(String itemId);


    /**
     * 根据商品id查询评论的数量
     *
     * @param itemId itemId
     */
    CommentLevelCountsVO queryCommentCounts(String itemId);


}
