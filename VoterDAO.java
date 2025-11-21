
package com.voting.dao;

import com.voting.model.Voter;
import com.voting.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class VoterDAO {

    public Voter login(String email, String password) {
        String sql = "SELECT * FROM voters WHERE email=? AND password=?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, email);
            ps.setString(2, password);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Voter v = new Voter();
                    v.setVoterId(rs.getInt("voter_id"));
                    v.setName(rs.getString("name"));
                    v.setEmail(rs.getString("email"));
                    v.setPassword(rs.getString("password"));
                    return v;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
