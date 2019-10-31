package com.liuyu7177.filter;

import com.liuyu7177.common.utils.IpUtils;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;

/**
 * Created by liuyu7177 On 2019/10/31
 * @author liuyu
 */
public class IpFilter extends ZuulFilter {
    private List<String> blackIpList= Arrays.asList("127.0.0.1");

    public IpFilter() {
       super();
    }

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext ctx=RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        String ip=IpUtils.getIpAddr(request);
        return null;
    }
}
