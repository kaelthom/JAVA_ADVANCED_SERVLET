package com.mywebapp.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        String path = ((HttpServletRequest) servletRequest).getRequestURI();
        if (path.contains("/error") || path.contains("login")&& (servletRequest.getParameter("action")==null||servletRequest.getParameter("action").equals("login"))) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            if (servletRequest instanceof HttpServletRequest) {
                HttpSession session = ((HttpServletRequest) servletRequest).getSession();
                if (session.getAttribute("userLogged") == null) {
                    ((HttpServletResponse) servletResponse).sendRedirect(((HttpServletRequest) servletRequest).getContextPath() + "/error");
                } else {
                    filterChain.doFilter(servletRequest, servletResponse);
                }
            }
        }
    }

    @Override
    public void destroy() {

    }
}
