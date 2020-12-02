package salman.servlet.http.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebFilter("/*")
public class AuthenticationFilter implements Filter{

    public FilterConfig filterConfig;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request= (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        String action = request.getServletPath();
        if ("/".equals(action) || "/login".equals(action) || "/login.jsp".equals(action)) {
            if (request.getSession().getAttribute("isLoggedIn") != null) {
                request.setAttribute("login","Anda Sudah Login");
                request.getRequestDispatcher("/welcome").forward(servletRequest,servletResponse);
            } else {
                filterChain.doFilter(servletRequest,servletResponse);
            }
        } else {
            Object isLoggedObj = request.getSession().getAttribute("isLoggedIn");
            if (isLoggedObj != null) {
                boolean isLoggedIn = (Boolean) isLoggedObj;
                if (isLoggedIn) {
                    filterChain.doFilter(servletRequest,servletResponse);
                    return;
                }
            }
            String path = request.getContextPath() + "/login?notlogged=true";
            response.sendRedirect(path);
        }
    }

    @Override
    public void destroy() {

    }
}
