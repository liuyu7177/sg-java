package com.liuyu7177.controller;

import com.liuyu7177.config.JsonResult;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by libiyan on 2019/10/26.
 *
 * @author liuyu
 */
@Component
public class BaseController {
    public BaseController() {

    }

    /**
     * 重定向到指定url
     *
     * @param url
     * @return
     */
    public String Redirect(String url) {
        return "redirect:" + url;
    }

    /**
     * 请求转发到指定url
     *
     * @param url
     * @return
     */
    public String Forward(String url) {
        return "forward:" + url;
    }

    /**
     * ModelAndView 实体对象
     */
    public ModelAndView mv;

    public HttpServletRequest request;
    public HttpServletResponse response;

    public HttpServletRequest getRequest() {
        return request;
    }

    public void setRequest(HttpServletRequest request) {
        this.request = request;
    }

    public ModelAndView getMv() {
        return mv;
    }

    public void setMv(ModelAndView mv) {
        this.mv = mv;
    }


    @ModelAttribute
    public void init(HttpServletRequest request, HttpServletResponse response) {
        mv = new ModelAndView();
        mv.setViewName(request.getServletPath());
    }

    /**
     * 返回ModelAndView
     *
     * @return
     */
    public ModelAndView View() {
        return mv;
    }

    /**
     * 返回ModelAndView
     *
     * @param viewName 视图名称（视图路径）
     * @return
     */
    public ModelAndView View(String viewName) {
        mv.setViewName(viewName);
        return mv;
    }

    /**
     * 返回ModelAndView对象
     *
     * @param viewName
     * @return
     */
    public ModelAndView View(View viewName) {
        mv.setView(viewName);
        return mv;
    }

    //region ApiSucceed 接口操作成功
    public JsonResult<String> ApiSucceed() {
        return new JsonResult<>(true,200,"操作成功",null);
    }

    public JsonResult<String> ApiSucceed(String msg) {
        return new JsonResult<>(true,200,msg,null);
    }

    public JsonResult<String> ApiSucceed(String msg, String data) {
        return new JsonResult<>(true,200,msg,data);
    }

    public <T> JsonResult<T> ApiSucceed(String msg, T data) {
        return new JsonResult<>(true,200,msg,data);
    }
    //endregion

    //region 接口操作失败
    public JsonResult<String> ApiError() {
        return new JsonResult<>(false,200,"操作失败",null);
    }

    public JsonResult<String> ApiError(String msg) {
        return new JsonResult<>(false,200,msg,null);
    }

    public JsonResult<String> ApiError(String msg, String data) {
        return new JsonResult<>(false,200,msg,data);
    }

    public <T> JsonResult<T> ApiError(String msg, T data) {
        return new JsonResult<>(false,200,msg,data);
    }
    //endregion
}
