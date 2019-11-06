package com.imooc.bo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author augenye
 * @date 2019-11-06 12:14
 */
@ApiModel(value = "用户对象BO", description = "从客服端，由用户传输的数据，封装在次entity当中")
@Data
public class UserBo {

    @ApiModelProperty(value = "用户名", name = "username", example = "imooc")
    private String username;

    @ApiModelProperty(value = "密码", name = "password", example = "123456")
    private String password;

    @ApiModelProperty(value = "确认密码", name = "confirmPassword", example = "和密码一致")
    private String confirmPassword;

}
