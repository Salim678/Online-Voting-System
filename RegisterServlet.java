package web;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;
import model.Voter;
import service.AuthService;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    
    private AuthService authService = new AuthService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        Voter voter = new Voter(0, name, email, password, false);

        boolean status = authService.register(voter);

        if (status) {
            resp.sendRedirect("login.jsp?success=1");
        } else {
            req.setAttribute("error", "Registration failed");
            req.getRequestDispatcher("register.jsp").forward(req, resp);
        }
    }
}
