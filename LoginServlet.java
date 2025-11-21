
package com.voting.servlet;

import com.voting.dao.VoterDAO;
import com.voting.model.Voter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import java.io.IOException;

public class LoginServlet extends HttpServlet {

    protected void doPost(jakarta.servlet.http.HttpServletRequest req, jakarta.servlet.http.HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        VoterDAO dao = new VoterDAO();
        Voter voter = dao.login(email, password);
        if (voter != null) {
            HttpSession session = req.getSession();
            session.setAttribute("voter", voter);
            resp.sendRedirect("vote.jsp");
        } else {
            resp.sendRedirect("login.jsp?error=1");
        }
    }
}
