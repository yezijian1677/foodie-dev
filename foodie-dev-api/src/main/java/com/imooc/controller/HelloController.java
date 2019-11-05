package com.imooc.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author augenye
 * @date 2019-11-04 22:58
 */
@RestController
public class HelloController {

    /**
     * 七个事务情况
     * 第一大类：支持事务的模式
     * Propagation_Required: 使用当前事务，如果没有当前事务，则自己创建一个事务
     * 子方法是必须运行在一个事务当中的，如果当前存在事务，则加入这个事务，成为一个整体
     *
     * Propagation_Support:表示当前方法不需要事务上下文
     * 但是如果存在当前事务的话，那么该方法会在这个事务中运行
     * 即：如果有事务，则使用事务，如果没有事务，则不使用事务
     *
     * Propagation_Mandatory: 必须在事务中运行，如果事务不存在，则抛出异常
     * Propagation_Required_New: 表示当前方法必须运行在自己的事务当中，如果当前事务存在，则
     * 挂起当前事务，然后开启自己的新事务
     *
     * 第二大类：不支持事务的类型
     * Propagation_Not_Support: 不应该运行在事务当中，如果存在事务，则在该方法运行期间，会把
     * 事务挂起
     * Propagation_NEVER: 表示该方法不会运行在事务当中，如果有一个事务存在，则会抛出异常
     *
     *
     * Propagation_NESTED: 嵌套事务，如果已经存在一个事务，那么该方法将会在嵌套事务中运行，嵌套的
     * 事务可以独立于当前事务进行单独的提交或者回滚，如果当前事务不存在，那么其行为与Propagation_Required一样
     *
     * 之所以不用EnableAutoConfiguration
     */

    @GetMapping("hello")
    public Object hello() {
        return "hello world";
    }
}
