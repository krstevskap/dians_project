package mk.finki.dians.dians_project.web.filter;


import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mk.finki.dians.dians_project.model.User;

import java.io.IOException;

@WebFilter
public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req=(HttpServletRequest) request;
        HttpServletResponse resp=(HttpServletResponse) response;

        User user=(User) req.getSession().getAttribute("user");

        String path=req.getServletPath();

        if(!"/login".equals(path) && !"/register".equals(path) && !"home.css".equals(path)&& !"loginStyle.css".equals(path)&& !"register.css".equals(path) && user==null){
            resp.sendRedirect("/login");
        }
        else {
            chain.doFilter(request,response);
        }
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
