package com.conference.dao.repos;

import com.conference.dao.entities.Reports_rp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ReportsRepo {
    public Reports_rp getReportByConferenceId(String id_cf) {
        DataSource dataSource = new DataSource();

        String reportsQuery = "Select * FROM reports_rp WHERE fk_id_cf ='" + id_cf +"'";

        try (
                Connection conn = dataSource.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(reportsQuery);)
        {
            if (rs.next()) {
                Reports_rp reports = new Reports_rp(
                        rs.getInt("id_rp"),
                        rs.getString("name_rp"),
                        rs.getString("announcer_rp"),
                        rs.getInt("fk_id_cf")
                );
                return reports;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}