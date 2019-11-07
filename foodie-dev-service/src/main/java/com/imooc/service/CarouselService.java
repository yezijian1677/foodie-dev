package com.imooc.service;

import com.imooc.pojo.Carousel;

import java.util.List;

/**
 * @author augenye
 * @date 2019/11/7 1:37 下午
 */
public interface CarouselService {

    /**
     * 查询所有轮播图列表
     * @param isShow
     * @return
     */
    List<Carousel> queryAll(Integer isShow);
}
