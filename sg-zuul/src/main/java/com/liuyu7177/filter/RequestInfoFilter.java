package com.liuyu7177.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.apache.commons.io.IOUtils;
import org.springframework.cloud.netflix.ribbon.RibbonHttpResponse;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Enumeration;

/**
 * Created by liuyu7177 On 2019/11/1
 */
public class RequestInfoFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return "post";
    }

    @Override
    public int filterOrder() {
        return 90;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest req = (HttpServletRequest) RequestContext.getCurrentContext().getRequest();
        System.err.println("Request:: " + req.getScheme() + " " + req.getRemoteAddr() + ":" + req.getRemotePort());
        StringBuilder params = new StringBuilder("?");
        //获取URL参数
        Enumeration<String> names = req.getParameterNames();
        while (names.hasMoreElements()) {
            String name = (String) names.nextElement();
            params.append("name");
            params.append("=");
            params.append(req.getParameter(name));
            params.append("&");
        }
        if (params.length() > 0) {
            params.delete(params.length() - 1, params.length());
        }
        System.err.println("Request:: > " + req.getMethod() + " " + req.getRequestURI() + params + " " + req.getProtocol());
        //获取Http请求头参数
        Enumeration<String> headers = req.getHeaderNames();
        while (headers.hasMoreElements()) {
            String name = (String) headers.nextElement();
            String value = req.getHeader(name);
            System.err.println("Request:: > " + name + ":" + value);
        }

        //获取请求体参数
        if (!ctx.isChunkedRequestBody()) {
            ServletInputStream inp = null;
            try {
                inp = ctx.getRequest().getInputStream();
                String body = null;
                if (inp != null) {
                    body = IOUtils.toString(inp, Charset.forName("UTF-8"));
                    System.err.println("Request:: > " + body);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try {
            Object zuulResponse=RequestContext.getCurrentContext().get("zuulResponse");
            if(zuulResponse!=null){
                RibbonHttpResponse resp=(RibbonHttpResponse)zuulResponse;
                String body= IOUtils.toString(resp.getBody(), Charset.forName("UTF-8"));
                System.err.println("Request:: > "+body);
                resp.close();
                RequestContext.getCurrentContext().setResponseBody(body);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        return null;


    }
}
