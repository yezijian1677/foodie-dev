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

    Users updateUserInfo(String userId, CenterUserBO centerUserBO);
}
