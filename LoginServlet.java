package web;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;
import model.Voter;
import service.AuthService;

public class LoginServlet extends HttpServlet {

    private AuthService authService = new AuthService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String email = req.getParameter("email");
        String password = req.getParameter("password");

        Voter voter = authService.login(email, password);

        if (voter != null) {
            HttpSession session = req.getSession();
            session.setAttribute("voter", voter);

            resp.sendRedirect("dashboard.jsp");
        } else {
            req.setAttribute("error", "Invalid login!");
            req.getRequestDispatcher("login.jsp").forward(req, resp);
        }
    }
}
