package controller;

import util.DBConnection;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;

@WebServlet("/vote")
public class VoteServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int candidateId = Integer.parseInt(request.getParameter("candidate"));
        int userId = (int) request.getSession().getAttribute("id");

        Connection con = null;

        try {
            con = DBConnection.getConnection();

          
            con.setAutoCommit(false);

            
            PreparedStatement checkStmt =
                    con.prepareStatement("SELECT has_voted FROM users WHERE id=?");
            checkStmt.setInt(1, userId);
            ResultSet rs = checkStmt.executeQuery();

            if (rs.next() && !rs.getBoolean("has_voted")) {

               
                PreparedStatement voteStmt =
                        con.prepareStatement("UPDATE candidates SET votes = votes + 1 WHERE id=?");
                voteStmt.setInt(1, candidateId);
                voteStmt.executeUpdate();

               
                PreparedStatement updateVoter =
                        con.prepareStatement("UPDATE users SET has_voted = TRUE WHERE id=?");
                updateVoter.setInt(1, userId);
                updateVoter.executeUpdate();
                con.commit();

                response.sendRedirect("result.jsp");

            } else {
                response.sendRedirect("error.jsp");
            }

        } catch (Exception e) {
            try {
                if (con != null) {
                    con.rollback();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
            response.sendRedirect("error.jsp");

        } finally {
            try {
                if (con != null) {
                    con.setAutoCommit(true);
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
