package filters;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Date;

@WebServlet("/filter")
public class LogFilter implements Filter {
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("LogFilter init");
    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;

        String servletPath = req.getServletPath();

        System.out.println("#INFO" + new Date() + " - servletPath:" + servletPath + " , URL:" +req.getRequestURI());
    }

    public void destroy() {
        System.out.println("LogFilter destroy");
    }
}
