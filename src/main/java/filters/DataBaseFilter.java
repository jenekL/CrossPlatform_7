package filters;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebServlet("/kek")
public class DataBaseFilter implements Filter {
    public DataBaseFilter() {
    }

    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;

//        String servletPath = req.getServletPath();
//        if(servletPath.contains("/jdbcOpen")){
//
//        }

       // Session session = HibernateUtil.getSession();

        filterChain.doFilter(servletRequest, servletResponse);
    }

    public void destroy() {

    }
}
