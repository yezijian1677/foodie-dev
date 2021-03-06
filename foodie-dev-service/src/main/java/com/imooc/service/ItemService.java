package com.imooc.service;

import com.imooc.pojo.Items;
import com.imooc.pojo.ItemsImg;
import com.imooc.pojo.ItemsParam;
import com.imooc.pojo.ItemsSpec;
import com.imooc.utils.PagedGridResult;
import com.imooc.vo.CommentLevelCountsVO;
import com.imooc.vo.ShopCartVO;

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

    /**
     * 查询商品的评价
     *
     * @param itemId 商品id
     * @param level  评价等级
     * @return
     */
    PagedGridResult queryPagedComments(String itemId, Integer level,
                                       Integer page, Integer pageSize);


    /**
     * 搜索商品
     *
     * @param keywords 关键词
     * @param sort     排序规则
     * @param page     页码
     * @param pageSize 页大小
     * @return
     */
    PagedGridResult searchItems(String keywords, String sort,
                                Integer page, Integer pageSize);

    /**
     * 根据分类id搜索商品
     *
     * @param catId    分类id
     * @param sort     排序规则
     * @param page     页码
     * @param pageSize 页大小
     * @return
     */
    PagedGridResult searchItemsByThirdCat(Integer catId, String sort,
                                          Integer page, Integer pageSize);


    /**
     * 根据规格ids查询最新的购物车重的商品数据
     *
     * @param specIds ids
     * @return shopCartVo
     */
    List<ShopCartVO> queryItemsBySpecIds(String specIds);


    /**
     * 根据商品规格id获取规格对象的具体信息
     *
     * @param specId
     * @return
     */
    ItemsSpec queryItemSpecById(String specId);

    /**
     * 根据商品id获取商品图片的主图
     *
     * @param itemId
     * @return
     */
    String queryItemMainImgById(String itemId);

    /**
     * 减少库存
     * @param specId 商品id
     * @param buyCounts 数量
     */
    void decreaseItemSpecStock(String specId, int buyCounts);

}
