package com.imooc.exception;

import com.imooc.utils.Result;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.multipart.MaxUploadSizeExceededException;

/**
 * @author augenye
 * @date 2019/11/16 11:26 上午
 */
@RestControllerAdvice
public class CustomExceptionHandler {

    /**
     * 上传文件超过1mb捕获异常
     * @param exception exception
     * @return result msg
     */
    @ExceptionHandler(MaxUploadSizeExceededException.class)
    public Result handlerMaxUploadFile(MaxUploadSizeExceededException exception) {
        return Result.errorMsg("文件大小不能超过1mb，请压缩图片或者降低图片质量");
    }
}
