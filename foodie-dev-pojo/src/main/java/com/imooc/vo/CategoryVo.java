package com.imooc.vo;

import lombok.Data;

import java.util.List;

/**
 * 二级分类vo
 * @author augenye
 * @date 2019/11/7 2:43 下午
 */
@Data
public class CategoryVO {

    private Integer id;
    private String name;
    private String type;
    private Integer fatherId;

    //三级分类VOList
    private List<SubCategoryVO> subCatList;
}
