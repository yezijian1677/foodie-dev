package com.imooc.service.center;

import com.imooc.bo.UserBO;
import com.imooc.center.bo.CenterUserBO;
import com.imooc.pojo.Users;

/**
 * @author augenye
 * @date 2019-11-05 22:00
 */
public interface CenterUserService {

    /**
     * 根据用户id查询用户信息
     * @return
     */
    Users queryUserInfo(String userId);

    /**
     * 更新用户信息
     * @param userId userId
     * @param centerUserBO 用户信息
     * @return users
     */
    Users updateUserInfo(String userId, CenterUserBO centerUserBO);

    /**
     *
     * @param userId userId
     * @param faceUrl 图像路径
     * @return users
     */
    Users updateUsersFace(String userId, String faceUrl);
}
