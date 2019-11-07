package com.imooc.mapper;

import com.imooc.vo.CategoryVO;

import java.util.List;

public interface CategoryMapperCustom{

    /**
     * 查询一级分类下的子分类
     * @param rootCatId
     * @return
     */
    List<CategoryVO> getSubCatList(Integer rootCatId);
}