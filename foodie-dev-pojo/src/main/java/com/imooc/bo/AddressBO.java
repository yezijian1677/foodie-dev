package com.imooc.bo;

import lombok.Data;

/**
 * @author augenye
 * @date 2019/11/9 1:27 下午
 */
@Data
public class AddressBO {

    private String addressId;
    private String receiver;
    private String userId;
    private String mobile;
    private String province;
    private String city;
    private String district;
    private String detail;

}
