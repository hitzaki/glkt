package com.xuanchen.glkt.common.handler;

import com.xuanchen.glkt.common.util.Result;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Result globalHandler(Exception e){
        // 全局内出现异常都返回这个Result，前提：一定要让这个Service导入Common模块
        e.printStackTrace();
        return Result.fail().message("全局异常处理");
    }

}
