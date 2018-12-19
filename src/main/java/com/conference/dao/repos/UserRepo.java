package com.conference.dao.repos;

import com.conference.dao.entities.Users_usr;

import java.sql.*;

/**
 * Getting / Putting Data into / from Database
 */
public class UserRepo {
    public Users_usr getUserByEmailByPassword(String email_usr, String password_usr) {
        DataSource dataSource = new DataSource();

        String query = "SELECT id_usr, email_usr, role_usr, nickname_usr, password_usr FROM users_usr " +
                "WHERE users_usr.email_usr='" + email_usr + "' AND users_usr.password_usr='" + password_usr + "'";

        try (Connection conn = dataSource.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query);)
        {
            if (rs.next()) {
                Users_usr user = new Users_usr(
                        rs.getInt("id_usr"),
                        rs.getString("email_usr"),
                        rs.getString("role_usr"),
                        rs.getString("nickname_usr"),
                        rs.getString("password_usr")
                );

                return user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public void saveUser(Users_usr usr) {
        DataSource dataSource = new DataSource();
        try (
                Connection conn = dataSource.getConnection();
                PreparedStatement stmt = conn.prepareStatement("INSERT INTO users_usr (nickname_usr, email_usr, password_usr) VALUES (?,?,?)")
        ) {
            stmt.setString(1, usr.getNickname_usr());
            stmt.setString(2, usr.getEmail_usr());
            stmt.setString(3, usr.getPassword_usr());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}