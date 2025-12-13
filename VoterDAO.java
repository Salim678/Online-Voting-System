package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.Voter;
import util.DBConnection;

public class VoterDAO {

    public static boolean isEmailExists(String email) {

        String sql = "SELECT voter_id FROM voters WHERE email = ?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();

            return rs.next();

        } catch (Exception e) {
            e.printStackTrace();
            return true;
        }
    }

    public static boolean registerVoter(Voter voter) {

        String sql = """
            INSERT INTO voters(name, email, password, role, has_voted)
            VALUES (?, ?, SHA2(?,256), 'voter', 0)
        """;

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, voter.getName());
            ps.setString(2, voter.getEmail());
            ps.setString(3, voter.getPassword());

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static Voter validateLogin(String email, String password) {

        String sql = """
            SELECT voter_id, name, role
            FROM voters
            WHERE email = ? AND password = SHA2(?,256)
        """;

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, email);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                Voter v = new Voter();
                v.setId(rs.getInt("voter_id"));
                v.setName(rs.getString("name"));
                v.setRole(rs.getString("role"));
                return v;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
