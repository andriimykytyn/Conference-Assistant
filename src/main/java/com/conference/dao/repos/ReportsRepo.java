package com.conference.dao.repos;

import com.conference.dao.entities.Reports_rp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ReportsRepo {
    public List<Reports_rp> getReportByConferenceId(String id_cf) {
        DataSource dataSource = new DataSource();
        List<Reports_rp> reports = new ArrayList<>();

        try (
                Connection conn = dataSource.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("Select * FROM reports_rp WHERE fk_id_cf =" + id_cf);
            )
        {
            while ( rs.next() ) {
                reports.add(new Reports_rp(
                        rs.getInt("id_rp"),
                        rs.getString("name_rp"),
                        rs.getString("announcer_rp"),
                        rs.getInt("fk_id_cf")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return reports;
    }
    public List<Reports_rp> getAllReports(){
        DataSource dataSource = new DataSource();
        List<Reports_rp> reports = new ArrayList<>();

        try (
                Connection conn = dataSource.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("Select * FROM reports_rp")
        )
        {
            while ( rs.next() ) {
                reports.add(new Reports_rp(
                        rs.getInt("id_rp"),
                        rs.getString("name_rp"),
                        rs.getString("announcer_rp"),
                        rs.getInt("fk_id_cf")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return reports;
    }
}