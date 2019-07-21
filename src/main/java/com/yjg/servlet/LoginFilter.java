package com.yjg.servlet;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 *  @author jiguo.yan@hand-china.com
 *  @date 2019/7/20
 *  @Description: 登录过滤的处理
 */
public class LoginFilter implements Filter {
    /**
     * Default constructor.
     */
    public LoginFilter() {
        // TODO Auto-generated constructor stub
    }

    /**
     * @see Filter#destroy()
     */
    @Override
    public void destroy() {
        // TODO Auto-generated method stub
    }

    /**
     * @see Filter# doFilter(ServletRequest, ServletResponse, FilterChain)
     */
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        String path = req.getRequestURI();
        System.out.println("reqURL----------" + path);
        // 如果包含login.jsp证明是登陆就放行
        if (path.contains("login") || path.contains("LoginServlet")||path.contains("/js/") || path.contains("/image/") || path.contains("/css/")
                || path.contains("message.jsp")|| path.contains("404.jsp")|| path.contains("/images/")) {
            chain.doFilter(request, response); // 放行
            return;
        }
        HttpServletResponse res = (HttpServletResponse) response;
        //获取session中的值
        HttpSession session = req.getSession();
        String firstName = (String)session.getAttribute("firstName");
        // 如果session中存在user证明用户登录，可以放行。否则认为未登陆重定向到login.jsp
        if (firstName == null || firstName=="") {
            req.getRequestDispatcher("index.jsp").forward(request, response);
        } else {
            chain.doFilter(request, response);
        }

    }
    /**
     * @see Filter # init(FilterConfig)
     */
    @Override
    public void init(FilterConfig fConfig) throws ServletException {
        // TODO Auto-generated method stub
    }
}
