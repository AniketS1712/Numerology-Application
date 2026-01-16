package com.numerology.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class Numerology {

    public static void saveResult(
            String name,
            String dob,
            int lifePath,
            String career,
            String relationship,
            String health,
            String money,
            String characteristics) throws Exception {

        Connection con = DBConnection.getConnection();

        String sql = "INSERT INTO numerology_result " +
                "(name, dob, life_path_number, career, relationship, health, money, characteristics) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, name);
        ps.setString(2, dob);
        ps.setInt(3, lifePath);
        ps.setString(4, career);
        ps.setString(5, relationship);
        ps.setString(6, health);
        ps.setString(7, money);
        ps.setString(8, characteristics);

        ps.executeUpdate();
        ps.close();
        con.close();
    }
}
