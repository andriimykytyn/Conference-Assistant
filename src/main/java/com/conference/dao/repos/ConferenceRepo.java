package com.conference.dao.repos;

import com.conference.dao.entities.Conferences_cf;

import java.sql.*;

public class ConferenceRepo {

   public Conferences_cf getConference() {
       DataSource dataSource = new DataSource();

       String query = "SELECT * FROM conferences_cf";

       try(Connection conn = dataSource.getConnection();
           Statement stmt = conn.createStatement();
           ResultSet rs = stmt.executeQuery(query);)
       {
           if (rs.next()) {
               Conferences_cf conferences_cf = new Conferences_cf(
                    rs.getInt("id_cf"),
                    rs.getString("name_cf"),
                    rs.getString("info_cf")
               );

               return conferences_cf;
           }
       } catch (SQLException e) {
           e.printStackTrace();
       }

       return null;
   }

}