package com.imooc.controller;

import com.imooc.enums.YesOrNo;
import com.imooc.pojo.Carousel;
import com.imooc.pojo.Category;
import com.imooc.service.CarouselService;
import com.imooc.service.CategoryService;
import com.imooc.utils.Result;
import com.imooc.vo.CategoryVO;
import com.imooc.vo.NewItemsVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;

/**
 * @author augenye
 * @date 2019-11-04 22:58
 */
@Slf4j
@Api(value = "首页", tags = "首页相关接口")
@RestController
@RequestMapping("index")
public class IndexController {

    @Autowired
    private CarouselService carouselService;
    @Autowired
    private CategoryService categoryService;

    @ApiOperation(value = "获取首页轮播图列表", notes = "获取首页轮播图列表", httpMethod = "GET")
    @GetMapping("/carousel")
    public Result carousel() {
        List<Carousel> list = carouselService.queryAll(YesOrNo.YES.type);
        return Result.ok(list);
    }

    /**
     * 首页分类展示需求：
     * 1. 第一次刷新主页查询大分类，渲染展示到首页
     * 2. 如果鼠标上移到大分类，则加载其子分类的内容，如果已经存在子分类，则不需要加载 lazy load
     */
    @ApiOperation(value = "获取商品(一级分类)", notes = "获取商品(一级分类)", httpMethod = "GET")
    @GetMapping("/cats")
    public Result cats() {
        List<Category> list = categoryService.queryAllRootLevelCat();
        return Result.ok(list);
    }

    @ApiOperation(value = "获取商品子分类", notes = "获取商品子分类", httpMethod = "GET")
    @GetMapping("/subCat/{rootCatId}")
    public Result subCats(@ApiParam(name = "rootCatId", value = "一级分类ID", required = true) @PathVariable Integer rootCatId) {
        if (rootCatId == null) {
            return Result.errorMsg("分类不存在");
        }
        List<CategoryVO> list = categoryService.getSubCatList(rootCatId);
        return Result.ok(list);
    }

    @ApiOperation(value = "查询每个分类下六个最新商品", notes = "查询每个分类下六个最新商品", httpMethod = "GET")
    @GetMapping("/sixNewItems/{rootCatId}")
    public Result sixNewItems(@ApiParam(name = "rootCatId", value = "一级分类ID", required = true) @PathVariable Integer rootCatId) {
        if (rootCatId == null) {
            return Result.errorMsg("分类不存在");
        }
        List<NewItemsVO> list = categoryService.getSixNewItemsLazy(rootCatId);

        return Result.ok(list);
    }
}
