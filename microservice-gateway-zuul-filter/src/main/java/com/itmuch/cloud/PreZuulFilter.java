package com.itmuch.cloud;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;

public class PreZuulFilter extends ZuulFilter {
    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(PreZuulFilter.class);

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
        return false;
    }

    @Override
    public Object run() {
        LOGGER.info("进入了zuulFilter run 方法");
        HttpServletRequest httpServletRequest = RequestContext.getCurrentContext().getRequest();
        String requestUrI = httpServletRequest.getRequestURI();
        LOGGER.info("******" + requestUrI);
        return requestUrI;
    }
}
