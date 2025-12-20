
package filter;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter(urlPatterns = {
        "/admin.jsp",
        "/vote.jsp",
        "/results.jsp"
})
public class AuthFilter implements Filter {

    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        HttpSession session = req.getSession(false);

        if (session == null || session.getAttribute("role") == null) {
            res.sendRedirect("login.jsp");
            return;
        }

        String role = session.getAttribute("role").toString();
        String uri = req.getRequestURI();

        if (uri.contains("admin.jsp") && !role.equalsIgnoreCase("admin")) {
            res.sendRedirect("login.jsp");
            return;
        }

        if ((uri.contains("vote.jsp") || uri.contains("results.jsp"))
                && !role.equalsIgnoreCase("voter")) {
            res.sendRedirect("login.jsp");
            return;
        }

        chain.doFilter(request, response);
    }
}
