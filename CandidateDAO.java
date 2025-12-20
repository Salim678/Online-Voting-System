package com.voting.dao;

import com.voting.model.Candidate;
import com.voting.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CandidateDAO {

    public List<Candidate> findAll() {
        String sql = "SELECT * FROM candidates";
        List<Candidate> list = new ArrayList<>();
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Candidate c = new Candidate();
                c.setCandidateId(rs.getInt("candidate_id"));
                c.setName(rs.getString("name"));
                c.setParty(rs.getString("party"));
                list.add(c);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public void addCandidate(String name, String party) {
        String sql = "INSERT INTO candidates (name, party) VALUES (?,?)";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, name);
            ps.setString(2, party);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
