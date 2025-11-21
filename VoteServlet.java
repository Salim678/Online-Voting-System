
package com.voting.servlet;

import com.voting.dao.VoteDAO;
import com.voting.model.Voter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import java.io.IOException;

public class VoteServlet extends HttpServlet {

    protected void doPost(jakarta.servlet.http.HttpServletRequest req, jakarta.servlet.http.HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        if (session == null || session.getAttribute("voter") == null) {
            resp.sendRedirect("login.jsp");
            return;
        }
        Voter voter = (Voter) session.getAttribute("voter");
        int candidateId = Integer.parseInt(req.getParameter("candidateId"));
        int electionId = Integer.parseInt(req.getParameter("electionId"));
        VoteDAO dao = new VoteDAO();
        if (dao.hasVoted(voter.getVoterId(), electionId)) {
            resp.sendRedirect("vote.jsp?message=already_voted");
            return;
        }
        boolean ok = dao.castVote(voter.getVoterId(), candidateId, electionId);
        if (ok) resp.sendRedirect("results.jsp?success=1");
        else resp.sendRedirect("vote.jsp?error=1");
    }
}
