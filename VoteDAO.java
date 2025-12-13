package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import util.DBConnection;

public class VoteDAO {

    public static boolean castVote(int voterId, int candidateId) {

        Connection con = null;
        PreparedStatement checkStmt = null;
        PreparedStatement voteStmt = null;
        PreparedStatement updateVoterStmt = null;

        try {
            con = DBConnection.getConnection();

            con.setAutoCommit(false);

            String checkQuery = "SELECT has_voted FROM voters WHERE voter_id = ?";
            checkStmt = con.prepareStatement(checkQuery);
            checkStmt.setInt(1, voterId);

            ResultSet rs = checkStmt.executeQuery();

            if (!rs.next() || rs.getBoolean("has_voted")) {
                con.rollback();
                return false;
            }

            String voteQuery =
                "INSERT INTO votes (voter_id, candidate_id) VALUES (?, ?)";
            voteStmt = con.prepareStatement(voteQuery);
            voteStmt.setInt(1, voterId);
            voteStmt.setInt(2, candidateId);
            voteStmt.executeUpdate();

            String updateVoterQuery =
                "UPDATE voters SET has_voted = 1 WHERE voter_id = ?";
            updateVoterStmt = con.prepareStatement(updateVoterQuery);
            updateVoterStmt.setInt(1, voterId);
            updateVoterStmt.executeUpdate();

           
            con.commit();
            return true;

        } catch (Exception e) {
            try {
                if (con != null) {
                    con.rollback();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
            return false;

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
