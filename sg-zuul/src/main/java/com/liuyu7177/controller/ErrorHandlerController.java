package com.liuyu7177.controller;

import com.liuyu7177.common.config.JsonResult;
import com.liuyu7177.common.controller.BaseController;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.ServletWebRequest;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Created by liuyu7177 On 2019/11/1
 * @author liuyu
 */
@RestController
public class ErrorHandlerController extends BaseController implements ErrorController {

    @Autowired
    private ErrorAttributes errorAttributes;

    @Override
    public String getErrorPath() {
        return "/error";
    }

    @RequestMapping("/error")
    public JsonResult<String> error(HttpServletRequest req) {
        Map<String, Object> errorAttributes = getErrorAttributes(req);
        String msg = (String) errorAttributes.get("message");
        String trace = (String) errorAttributes.get("trace");
        if (StringUtils.isNotBlank(trace)) {
            msg += String.format(" and trace %s", trace);
        }
        return ApiError(msg);
    }

    private Map<String, Object> getErrorAttributes(HttpServletRequest req) {
        return errorAttributes.getErrorAttributes(new ServletWebRequest(req), true);
    }
}
