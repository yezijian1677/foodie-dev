package com.imooc.center.bo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.*;
import java.util.Date;

/**
 * @author augenye
 * @date 2019-11-06 12:14
 */
@ApiModel(value = "用户中心user对象BO", description = "从客服端，由用户传输的数据，封装在次entity当中")
@Data
public class CenterUserBO {

    @ApiModelProperty(value = "用户名", name = "username", example = "imooc")
    private String username;

    @ApiModelProperty(value = "密码", name = "password", example = "123456")
    private String password;

    @ApiModelProperty(value = "确认密码", name = "confirmPassword", example = "和密码一致", required = false)
    private String confirmPassword;

    @NotBlank(message = "用户昵称字段不能为空")
    @Length(max = 12, message = "用户昵称不能超过12")
    @ApiModelProperty(value = "昵称", name = "昵称", example = "猪猪侠", required = true)
    private String nickname;

    @NotBlank(message = "用户真是姓名字段不能为空")
    @Length(max = 12, message = "用户真是姓名字段超过12")
    @ApiModelProperty(value = "真实名字", name = "真实名字", example = "猪超强", required = true)
    private String realname;

    @Pattern(regexp = "^(((13[0-9]{1})|(15[0-9]{1})|(18[0-9]{1}))+\\d{8})$", message = "手机号码格式错误")
    @ApiModelProperty(value = "手机电话", name = "手机电话", example = "13000000000", required = true)
    private String mobile;

    @Email
    @ApiModelProperty(value = "邮箱", name = "邮箱", example = "zhuchaoqiang@qq.com")
    private String email;

    @Min(value = 0, message = "性别选择不正确")
    @Max(value = 2, message = "性别选择不正确")
    @ApiModelProperty(value = "性别", name = "性别", example = "0：女 1：男 2：保密")
    private Integer sex;

    @ApiModelProperty(value = "生日", name = "生日", example = "1900-01-01")
    private Date birthday;

}
