package com.imooc.service;

import com.imooc.pojo.Category;
import com.imooc.vo.CategoryVO;

import java.util.List;

/**
 * @author augenye
 * @date 2019/11/7 2:10 下午
 */
public interface CategoryService {

    /**
     * 查询所有大分类
     * @return
     */
    List<Category> queryAllRootLevelCat();

    /**
     * 根据一级分类id查询子分类
     * @param rootCatId
     * @return
     */
    List<CategoryVO> getSubCatList(Integer rootCatId);
}
