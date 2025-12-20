package com.voting.dao;

import com.voting.model.Election;
import com.voting.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ElectionDAO {

    public List<Election> findAll() {
        String sql = "SELECT * FROM elections";
        List<Election> list = new ArrayList<>();
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Election e = new Election();
                e.setElectionId(rs.getInt("election_id"));
                e.setTitle(rs.getString("title"));
                e.setStartDate(rs.getDate("start_date"));
                e.setEndDate(rs.getDate("end_date"));
                list.add(e);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
