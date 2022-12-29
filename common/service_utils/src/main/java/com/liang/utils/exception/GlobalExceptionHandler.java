package com.liang.utils.exception;

import com.liang.utils.result.Result;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 统一异常处理类
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Result error(Exception e){
        e.printStackTrace();
        return Result.error("执行了全局异常处理");
    }

    //java.lang.ArithmeticException: / by zero
    @ExceptionHandler(ArithmeticException.class)
    @ResponseBody
    public Result error(ArithmeticException e){
        e.printStackTrace();
        return Result.error("执行了特定异常处理");
    }

    @ExceptionHandler(GgktException.class)
    @ResponseBody
    public Result error(GgktException e){
        e.printStackTrace();
        return Result.error(e.getMsg(), e.getCode());
    }
}



