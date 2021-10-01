package ir.maktab;

import ua_parser.Client;
import ua_parser.Parser;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.PrintWriter;

public class BrowserFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        String userAgent = request.getHeader("user-agent");


        Parser uaParser = new Parser();
        Client client = uaParser.parse(userAgent);

        System.out.println(userAgent);

        if (client.userAgent.family.equals("Firefox")) {
            PrintWriter out = servletResponse.getWriter();
            out.println("<font color='blue'>Please use another browser</font>");

        } else {
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }
}
