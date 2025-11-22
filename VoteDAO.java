
package dao;

import com.voting.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class VoteDAO {

    public boolean hasVoted(int voterId, int electionId) {
        String sql = "SELECT COUNT(*) as cnt FROM votes WHERE voter_id=? AND election_id=?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, voterId);
            ps.setInt(2, electionId);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt("cnt") > 0;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean castVote(int voterId, int candidateId, int electionId) {
        String sql = "INSERT INTO votes (voter_id, candidate_id, election_id) VALUES (?,?,?)";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, voterId);
            ps.setInt(2, candidateId);
            ps.setInt(3, electionId);
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
