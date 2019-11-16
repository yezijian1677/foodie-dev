package com.imooc.controller.center;

import com.imooc.center.bo.OrderItemsCommentBO;
import com.imooc.controller.BaseController;
import com.imooc.enums.YesOrNo;
import com.imooc.pojo.OrderItems;
import com.imooc.pojo.Orders;
import com.imooc.service.center.MyCommentService;
import com.imooc.utils.PagedGridResult;
import com.imooc.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author augenye
 * @date 2019/11/16 1:43 下午
 */
@Api(value = "用户中心我的订单", tags = {"用户中心我的订单相关接口"})
@RestController
@RequestMapping("mycomments")
public class MyCommentsController extends BaseController {

    @ApiOperation(value = "查询列表", notes = "查询列表", httpMethod = "POST")
    @PostMapping("/pending")
    public Result pending(@ApiParam(name = "userId", value = "userId", required = true) @RequestParam String userId,
                           @ApiParam(name = "orderId", value = "orderId") @RequestParam String orderId) {

        //该笔订单是否关联
        Result checkResult = checkUserOrder(userId, orderId);
        if (checkResult.getStatus() != HttpStatus.OK.value()) {
            return checkResult;
        }

        //判断该笔订单是否评价
        Orders myOrder = (Orders) checkResult.getData();
        if (myOrder.getIsComment() == (YesOrNo.YES.type)) {
            return Result.errorMsg("该笔订单已经评价");
        }

        List<OrderItems> list = myCommentService.queryPendingComment(orderId);

        return Result.ok(list);
    }


    @ApiOperation(value = "保存评论", notes = "保存评论", httpMethod = "POST")
    @PostMapping("/saveList")
    public Result saveList(@ApiParam(name = "userId", value = "userId", required = true) @RequestParam String userId,
                           @ApiParam(name = "orderId", value = "orderId") @RequestParam String orderId,
                           @RequestBody List<OrderItemsCommentBO> commentList) {

        //该笔订单是否关联
        Result checkResult = checkUserOrder(userId, orderId);
        if (checkResult.getStatus() != HttpStatus.OK.value()) {
            return checkResult;
        }
        //判断评论内容list不能为空
        if (commentList == null || commentList.isEmpty() || commentList.size() == 0) {
            return Result.errorMsg("评论不能为空！");
        }

        //评论保存
        myCommentService.saveComments(orderId, userId, commentList);

        return Result.ok();
    }

    @ApiOperation(value = "查询我的评价", notes = "查询我的评价", httpMethod = "POST")
    @PostMapping("/query")
    public Result catItems(@ApiParam(name = "userId", value = "userId", required = true) @RequestParam String userId,
                           @ApiParam(name = "page", value = "查询下一页的第几页") @RequestParam(defaultValue = "1") Integer page,
                           @ApiParam(name = "pageSize", value = "分页每一页显示的条数") @RequestParam(defaultValue = "10") Integer pageSize) {
        if (StringUtils.isBlank(userId)) {
            return Result.errorMsg(null);
        }

        PagedGridResult grid = myCommentService.queryMyComments(userId, page, pageSize);

        return Result.ok(grid);
    }

}
