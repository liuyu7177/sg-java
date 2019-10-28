package com.liuyu7177.config;

import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * Created by libiyan on 2019/10/26.
 *
 * @author liuyu
 */
@Data
@Component
public class JsonResult<T> {

    public JsonResult() {
    }

    public JsonResult(boolean status) {
        this.status = status;
    }

    public JsonResult(boolean status, int code) {
        this.status = status;
        this.code = code;
    }

    public JsonResult(boolean status, int code, String msg) {
        this.status = status;
        this.code = code;
        this.msg = msg;
    }

    public JsonResult(boolean status, int code, String msg, T data) {
        this.status = status;
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    private boolean status;
    private int code;
    private String msg;
    private T data;
}
