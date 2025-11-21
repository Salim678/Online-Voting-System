
package com.voting.servlet;

import com.voting.dao.CandidateDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import java.io.IOException;

public class AdminServlet extends HttpServlet {

    protected void doPost(jakarta.servlet.http.HttpServletRequest req, jakarta.servlet.http.HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if ("addCandidate".equals(action)) {
            String name = req.getParameter("name");
            String party = req.getParameter("party");
            CandidateDAO dao = new CandidateDAO();
            dao.addCandidate(name, party);
            resp.sendRedirect("admin.jsp?added=1");
        } else {
            resp.sendRedirect("admin.jsp");
        }
    }
}
