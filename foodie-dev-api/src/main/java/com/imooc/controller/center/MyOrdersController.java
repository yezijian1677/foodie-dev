package com.imooc.controller.center;

import com.imooc.controller.BaseController;
import com.imooc.pojo.Orders;
import com.imooc.service.center.MyOrdersService;
import com.imooc.utils.PagedGridResult;
import com.imooc.utils.Result;
import com.imooc.vo.OrderStatusCountsVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * @author augenye
 * @date 2019/11/16 1:43 下午
 */
@Api(value = "用户中心我的订单", tags = {"用户中心我的订单相关接口"})
@RestController
@RequestMapping("myorders")
public class MyOrdersController extends BaseController {

    @ApiOperation(value = "查询订单的状态数量", notes = "查询订单的状态数量", httpMethod = "POST")
    @PostMapping("/statusCounts")
    public Result statusCounts(@ApiParam(name = "userId", value = "userId", required = true) @RequestParam String userId) {
        if (StringUtils.isBlank(userId)) {
            return Result.errorMsg(null);
        }

       OrderStatusCountsVO result = myOrdersService.getOrderStatusCounts(userId);

        return Result.ok(result);
    }

    @ApiOperation(value = "查询订单动向", notes = "查询订单动向", httpMethod = "POST")
    @PostMapping("/trend")
    public Result trends(@ApiParam(name = "userId", value = "userId", required = true) @RequestParam String userId,
                        @ApiParam(name = "page", value = "查询下一页的第几页") @RequestParam(defaultValue = "1") Integer page,
                        @ApiParam(name = "pageSize", value = "分页每一页显示的条数") @RequestParam(defaultValue = "10") Integer pageSize) {
        if (StringUtils.isBlank(userId)) {
            return Result.errorMsg(null);
        }

        PagedGridResult grid = myOrdersService.getOrdersTrend(userId, page, pageSize);

        return Result.ok(grid);
    }

    @ApiOperation(value = "查询订单列表", notes = "查询订单列表", httpMethod = "POST")
    @PostMapping("/query")
    public Result query(@ApiParam(name = "userId", value = "userId", required = true) @RequestParam String userId,
                           @ApiParam(name = "orderStatus", value = "订单状态") @RequestParam Integer orderStatus,
                           @ApiParam(name = "page", value = "查询下一页的第几页") @RequestParam(defaultValue = "1") Integer page,
                           @ApiParam(name = "pageSize", value = "分页每一页显示的条数") @RequestParam(defaultValue = "10") Integer pageSize) {
        if (userId == null) {
            return Result.errorMsg(null);
        }

        PagedGridResult grid = myOrdersService.queryMyOrders(userId, orderStatus, page, pageSize);

        return Result.ok(grid);
    }

    //商家发货没有后端，所以这个接口仅仅只是用于模拟
    @ApiOperation(value = "商家发货", notes = "商家发货", httpMethod = "POST")
    @PostMapping("/deliver")
    public Result deliver(@ApiParam(name = "orderId", value = "orderId", required = true) @RequestParam String orderId) {

        if (StringUtils.isBlank(orderId)) {
            return Result.errorMsg("订单id不能为空");
        }

        myOrdersService.updateDeliverOrderStatus(orderId);

        return Result.ok();
    }

    @ApiOperation(value = "用户确认收货", notes = "用户确认收货", httpMethod = "POST")
    @PostMapping("/confirmReceive")
    public Result confirmReceive(@ApiParam(name = "orderId", value = "orderId", required = true) @RequestParam String orderId,
                                 @ApiParam(name = "userId", value = "userId", required = true) @RequestParam String userId) {

        Result checkResult = checkUserOrder(orderId, userId);
        if (checkResult.getStatus() != HttpStatus.OK.value()) {
            return checkResult;
        }
        //订单更新确认收货
        boolean res = myOrdersService.updateReceiveOrderStatus(orderId);
        if (!res) {
            return Result.errorMsg("订单确认收货失败");
        }
        return Result.ok();
    }

    @ApiOperation(value = "用户删除订单", notes = "用户删除订单", httpMethod = "POST")
    @PostMapping("/delete")
    public Result delete(@ApiParam(name = "orderId", value = "orderId", required = true) @RequestParam String orderId,
                                 @ApiParam(name = "userId", value = "userId", required = true) @RequestParam String userId) {

        Result checkResult = checkUserOrder(orderId, userId);
        if (checkResult.getStatus() != HttpStatus.OK.value()) {
            return checkResult;
        }
        //订单删除
        boolean res = myOrdersService.deleteOrder(userId, orderId);
        if (!res) {
            return Result.errorMsg("订单删除失败");
        }
        return Result.ok();
    }



}
