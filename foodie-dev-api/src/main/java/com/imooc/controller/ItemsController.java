package com.imooc.controller;

import com.imooc.pojo.Items;
import com.imooc.pojo.ItemsImg;
import com.imooc.pojo.ItemsParam;
import com.imooc.pojo.ItemsSpec;
import com.imooc.service.ItemService;
import com.imooc.utils.PagedGridResult;
import com.imooc.utils.Result;
import com.imooc.vo.CommentLevelCountsVO;
import com.imooc.vo.ItemInfoVO;
import com.imooc.vo.ShopCartVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author augenye
 * @date 2019-11-04 22:58
 */
@Slf4j
@Api(value = "商品接口", tags = "商品信息展示的相关接口")
@RestController
@RequestMapping("items")
public class ItemsController extends BaseController {

    @Autowired
    private ItemService itemService;

    @ApiOperation(value = "查询商品详情", notes = "查询商品详情", httpMethod = "GET")
    @GetMapping("/info/{itemId}")
    public Result info(@ApiParam(name = "itemId", value = "商品ID", required = true) @PathVariable String itemId) {
        if (StringUtils.isBlank(itemId)) {
            return Result.errorMsg("商品id为空");
        }
        Items item = itemService.queryItemById(itemId);
        List<ItemsImg> itemImgList = itemService.queryItemImgList(itemId);
        List<ItemsSpec> itemSpecList = itemService.queryItemsSpecList(itemId);
        ItemsParam itemParam = itemService.queryItemsParam(itemId);

        ItemInfoVO itemInfoVO = new ItemInfoVO();
        itemInfoVO.setItem(item);
        itemInfoVO.setItemImgList(itemImgList);
        itemInfoVO.setItemSpecList(itemSpecList);
        itemInfoVO.setItemParams(itemParam);

        return Result.ok(itemInfoVO);
    }

    @ApiOperation(value = "查询商品评论等级", notes = "查询商品评论等级", httpMethod = "GET")
    @GetMapping("/commentLevel")
    public Result commentLevel(@ApiParam(name = "itemId", value = "商品ID", required = true) @RequestParam String itemId) {
        if (StringUtils.isBlank(itemId)) {
            return Result.errorMsg("商品id为空");
        }
        CommentLevelCountsVO countsVO = itemService.queryCommentCounts(itemId);
        return Result.ok(countsVO);
    }

    @ApiOperation(value = "查询商品评论", notes = "查询商品评论", httpMethod = "GET")
    @GetMapping("/comments")
    public Result comments(@ApiParam(name = "itemId", value = "商品ID", required = true) @RequestParam String itemId,
                           @ApiParam(name = "level", value = "评价等级") @RequestParam Integer level,
                           @ApiParam(name = "page", value = "查询下一页的第几页") @RequestParam Integer page,
                           @ApiParam(name = "pageSize", value = "分页每一页显示的条数") @RequestParam Integer pageSize) {
        if (StringUtils.isBlank(itemId)) {
            return Result.errorMsg("商品id为空");
        }
        if (page == null) {
            page = 1;
        }
        if (pageSize == null) {
            page = COMMENT_PAGE_SIZE;
        }

        PagedGridResult grid = itemService.queryPagedComments(itemId, level, page, pageSize);

        return Result.ok(grid);
    }

    @ApiOperation(value = "查询商品", notes = "查询商品", httpMethod = "GET")
    @GetMapping("/search")
    public Result search(@ApiParam(name = "keywords", value = "关键词", required = true) @RequestParam String keywords,
                           @ApiParam(name = "sort", value = "排序规则") @RequestParam String sort,
                           @ApiParam(name = "page", value = "查询下一页的第几页") @RequestParam(defaultValue = "1") Integer page,
                           @ApiParam(name = "pageSize", value = "分页每一页显示的条数") @RequestParam(defaultValue = "20") Integer pageSize) {
        if (StringUtils.isBlank(keywords)) {
            return Result.errorMsg("关键词为空");
        }

        PagedGridResult grid = itemService.searchItems(keywords, sort, page, pageSize);

        return Result.ok(grid);
    }

    @ApiOperation(value = "分类id搜索商品列表", notes = "分类id搜索商品列表", httpMethod = "GET")
    @GetMapping("/catItems")
    public Result catItems(@ApiParam(name = "catId", value = "分类id", required = true) @RequestParam Integer catId,
                         @ApiParam(name = "sort", value = "排序规则") @RequestParam String sort,
                         @ApiParam(name = "page", value = "查询下一页的第几页") @RequestParam(defaultValue = "1") Integer page,
                         @ApiParam(name = "pageSize", value = "分页每一页显示的条数") @RequestParam(defaultValue = "20") Integer pageSize) {
        if (catId == null) {
            return Result.errorMsg("关键词为空");
        }

        PagedGridResult grid = itemService.searchItemsByThirdCat(catId, sort, page, pageSize);

        return Result.ok(grid);
    }

    //用于用户长时间未登录网站，刷新购物车重的数据，主要是商品价格，类似京东淘宝
    @ApiOperation(value = "根据商品规格ids查询商品数据", notes = "根据商品规格ids查询商品数据", httpMethod = "GET")
    @GetMapping("/refresh")
    public Result refresh(@ApiParam(name = "itemSpecIds", value = "拼接规格", required = true, example = "1001,1002,1003") @RequestParam String itemSpecIds) {

        if (StringUtils.isBlank(itemSpecIds)) {
            return Result.errorMsg("关键词为空");
        }

        List<ShopCartVO> list = itemService.queryItemsBySpecIds(itemSpecIds);

        return Result.ok(list);
    }
}
