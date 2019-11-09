package com.imooc.controller;

import com.imooc.bo.AddressBO;
import com.imooc.pojo.UserAddress;
import com.imooc.service.AddressService;
import com.imooc.utils.MobileEmailUtils;
import com.imooc.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author augenye
 * @date 2019-11-09 22:58
 */
@Api(value = "地址相关", tags = {"地址相关的api接口"})
@RequestMapping("address")
@RestController
public class AddressController {

    @Autowired
    private AddressService addressService;

    /**
     * 用户在确认订单页面，可以针对收货地址做如下操作
     * 1. 查询用户的所有收货地址列表
     * 2. 新增收货地址
     * 3. 删除收获地址
     * 4. 修改收获地址
     * 5. 设置默认地址
     */

    @ApiOperation(value = "根据用户id查询地址列表", notes = "根据用户id查询地址列表", httpMethod = "POST")
    @PostMapping("/list")
    public Result list(@RequestParam String userId) {
        if (StringUtils.isBlank(userId)) {
            return Result.errorMsg("");
        }

        List<UserAddress> list = addressService.queryAll(userId);

        return Result.ok(list);
    }

    @ApiOperation(value = "用户新增地址", notes = "用户新增地址", httpMethod = "POST")
    @PostMapping("/add")
    public Result add(@RequestBody AddressBO addressBO) {

        Result checkRes = checkAddress(addressBO);
        if (checkRes.getStatus() != 200) {
            return checkRes;
        }

        addressService.addNewUserAddress(addressBO);

        return Result.ok();

    }

    @ApiOperation(value = "用户修改地址", notes = "用户修改地址", httpMethod = "POST")
    @PostMapping("/update")
    public Result update(@RequestBody AddressBO addressBO) {
        if (StringUtils.isBlank(addressBO.getAddressId())) {
            return Result.errorMsg("修改地址错误");
        }

        Result checkRes = checkAddress(addressBO);
        if (checkRes.getStatus() != 200) {
            return checkRes;
        }

        addressService.updateUserAddress(addressBO);

        return Result.ok();
    }

    @ApiOperation(value = "删除地址", notes = "删除地址", httpMethod = "POST")
    @PostMapping("/delete")
    public Result delete(@RequestParam String userId, @RequestParam String addressId) {

        if (StringUtils.isBlank(userId) || StringUtils.isBlank(addressId)) {
            return Result.errorMsg("");
        }

        addressService.deleteUserAddress(userId, addressId);

        return Result.ok();
    }

    @ApiOperation(value = "用户设定默认地址", notes = "用户设定默认地址", httpMethod = "POST")
    @PostMapping("/setDefault")
    public Result setDefault(@RequestParam String userId, @RequestParam String addressId) {

        if (StringUtils.isBlank(userId) || StringUtils.isBlank(addressId)) {
            return Result.errorMsg("");
        }

        addressService.updateUserAddressToBeDefault(userId, addressId);

        return Result.ok();
    }

    private Result checkAddress(AddressBO addressBO) {
        String receiver = addressBO.getReceiver();
        if (StringUtils.isBlank(receiver)) {
            return Result.errorMsg("收货人不能为空");
        }
        if (receiver.length() > 12) {
            return Result.errorMsg("收货人姓名不能太长");
        }
        String mobile = addressBO.getMobile();
        if (StringUtils.isBlank(mobile)) {
            return Result.errorMsg("收货人手机号不能为空");
        }
        if (mobile.length() != 11) {
            return Result.errorMsg("收货人手机号长度不正确");
        }
        boolean isMobileOk = MobileEmailUtils.checkMobileIsOk(mobile);
        if (!isMobileOk) {
            return Result.errorMsg("收货人手机号格式不正确");
        }

        String province = addressBO.getProvince();
        String city = addressBO.getCity();
        String district = addressBO.getDistrict();
        String detail = addressBO.getDetail();

        if (StringUtils.isBlank(province) ||
                StringUtils.isBlank(city) ||
                StringUtils.isBlank(district) ||
                StringUtils.isBlank(detail)) {
            return Result.errorMsg("收货信息不能为空");
        }
        return Result.ok();
    }
}
