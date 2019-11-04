package com.liuyu7177.common.exception;

import com.liuyu7177.common.config.JsonResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by libiyan on 2019/10/26.
 *
 * @author liuyu
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public JsonResult<String> defaultErrorHandler(HttpServletRequest request, Exception e) {
            JsonResult<String> r=new JsonResult<>();
            r.setMsg(e.getMessage());
            if(e instanceof  org.springframework.web.servlet.NoHandlerFoundException){
                r.setCode(404);
            }else {
                r.setCode(500);
            }
            r.setData(null);
            r.setStatus(false);
            return  r;
    }
}
