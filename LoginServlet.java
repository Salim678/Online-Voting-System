package web;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;
import model.Voter;
import service.AuthService;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    private AuthService authService = new AuthService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String email = req.getParameter("email");
        String password = req.getParameter("password");

        Voter voter = authService.login(email, password);

        if (voter != null) {

            HttpSession session = req.getSession(true);

            session.setAttribute("userId", voter.getId());
            session.setAttribute("role", voter.getRole());
            session.setAttribute("voter", voter);

            if ("admin".equalsIgnoreCase(voter.getRole())) {
                resp.sendRedirect("admin.jsp");
            } else {
                resp.sendRedirect("vote.jsp");
            }

        } else {
            req.setAttribute("error", "Invalid login!");
            req.getRequestDispatcher("login.jsp").forward(req, resp);
        }
    }
}
