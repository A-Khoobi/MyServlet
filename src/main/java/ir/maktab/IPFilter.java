package ir.maktab;


import javax.servlet.*;
import java.io.IOException;

public class IPFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        String IP = servletRequest.getRemoteAddr();

        System.out.println("IP: " + IP);

        filterChain.doFilter(servletRequest, servletResponse);
    }

//    @Override
//    public void destroy() {
//
//    }
}
