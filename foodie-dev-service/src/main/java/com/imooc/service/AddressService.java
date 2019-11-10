package com.imooc.service;

import com.imooc.bo.AddressBO;
import com.imooc.pojo.UserAddress;

import java.util.List;

/**
 * @author augenye
 * @date 2019/11/9 1:07 下午
 */
public interface AddressService {

    /**
     * 根据用户id查询用户的收货地址列表
     * @param userId userId
     * @return list
     */
    List<UserAddress> queryAll(String userId);

    /**
     * 用户新增地址
     * @param addressBO 地址
     */
    void addNewUserAddress(AddressBO addressBO);

    /**
     * 用户修改地址
     * @param addressBO 地址
     */
    void updateUserAddress(AddressBO addressBO);

    /**
     * 删除用户地址
     * @param userId 用户id
     * @param addressId 地址id
     */
    void deleteUserAddress(String userId, String addressId);

    /**
     * 设置默认地址
     * @param userId 用户id
     * @param addressId 地址id
     */
    void updateUserAddressToBeDefault(String userId, String addressId);

    /**
     * 根据用户id和地址id查询 详细地址
     * @param userId 用户id
     * @param addressId 地址id
     * @return address
     */
    UserAddress queryUserAddress(String userId, String addressId);
}
