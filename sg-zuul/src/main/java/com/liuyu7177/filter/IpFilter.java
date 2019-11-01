package com.liuyu7177.filter;


import com.liuyu7177.common.config.JsonResult;
import com.liuyu7177.common.utils.GsonUtils;
import com.liuyu7177.common.utils.IpUtils;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by liuyu7177 On 2019/10/31
 *
 * @author liuyu
 */
public class IpFilter extends ZuulFilter {
    //    private List<String> blackIpList = Arrays.asList("127.0.0.1");
    private List<String> blackIpList = new ArrayList<>();

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
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        String ip = IpUtils.getIpAddr(request);
        if (StringUtils.isNotBlank(ip) && blackIpList.contains(ip)) {
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(401);
            ctx.setResponseBody(GsonUtils.objectToJson(new JsonResult<String>(true, 200, "非法请求")));
            ctx.getResponse().setContentType("application/json;charset=utf-8");
            return null;
        }
        return null;
    }
}
