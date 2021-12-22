package com.example.request.context.filter;

import com.example.request.context.BasicRequestContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * 请求上下文过滤器
 *
 * @author liugang
 * @create 2021/12/16
 */
@Order(Integer.MIN_VALUE)
@Slf4j
public class BasicRequestContextFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;

        // 获取header数据
        BasicRequestContext.set(BasicRequestContext.REQUEST_VERSION, request.getHeader(BasicRequestContext.REQUEST_VERSION));
        BasicRequestContext.set(BasicRequestContext.REQUEST_PLATFORM, request.getHeader(BasicRequestContext.REQUEST_PLATFORM));
        BasicRequestContext.set(BasicRequestContext.REQUEST_DEVICE, request.getHeader(BasicRequestContext.REQUEST_DEVICE));
        BasicRequestContext.set(BasicRequestContext.REQUEST_DATA_SOURCE, request.getHeader(BasicRequestContext.REQUEST_DATA_SOURCE));

        // 放行拦截
        try {
            filterChain.doFilter(servletRequest, servletResponse);
        } finally {
            BasicRequestContext.clear();
            log.info("BasicRequestContextFilter，清除线程本地变量");
        }
    }

    @Override
    public void destroy() {

    }

}
