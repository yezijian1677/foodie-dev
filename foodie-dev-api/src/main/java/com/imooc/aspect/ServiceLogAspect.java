package com.imooc.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * @author augenye
 * @date 2019/11/7 10:37 上午
 */
@Aspect
@Component
@Slf4j
public class ServiceLogAspect {

    /**
     * Aop通知：
     * 1. 前置通知，方法调用执行前
     * 2. 后置通知，方法正常调用后
     * 3. 环绕通知，方法调用前后
     * 4. 异常通知，方法调用失败后
     * 5. 最终通知，方法调用之后执行
     */

    /**
     * 切面表达式：
     * execution 代表所要执行的的表达式主体
     * 第一处 * 代表方法返回类型， * 代表任何类型
     * 第二处 包名代表aop监控的类所在的包
     * 第三处 .. 代表该包以及子包下的所有类方法
     * 第四处 * 代表类名，* 代表所有类
     * 最终 .*.*代表任何类，任何方法 (..)任意参数
     *
     * @param joinPoint 切入点
     * @return object
     * @throws Throwable throw
     */
    @Around("execution(* com.imooc.service.impl..*.*(..))")
    public Object recordTimeLog(ProceedingJoinPoint joinPoint) throws Throwable {

        log.info("====== 开始执行 ======");
        log.info("执行的类: {}",joinPoint.getTarget().getClass());
        log.info("执行签名: {}",joinPoint.getSignature().getName());
        // 记录开始时间
        long begin = System.currentTimeMillis();
        
        // 执行目标service
        Object result = joinPoint.proceed();

        // 记录结束时间
        long end = System.currentTimeMillis();
        long takeTime = end - begin;

        if (takeTime > 3000) {
            log.error("====== 执行完毕, 耗时: {}毫秒 ======", takeTime);
        } else if (takeTime > 2000) {
            log.warn("====== 执行完毕, 耗时: {}毫秒 ======", takeTime);
        } else {
            log.info("====== 执行完毕, 耗时: {}毫秒 ======", takeTime);
        }

        return result;
    }
}
