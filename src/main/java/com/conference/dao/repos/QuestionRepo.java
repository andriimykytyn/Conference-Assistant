package com.conference.dao.repos;

import com.conference.dao.entities.Questions_qs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class QuestionRepo {

    public void saveQuestion(Questions_qs questions_qs) {
        DataSource dataSource = new DataSource();
        try(
                Connection conn = dataSource.getConnection();
                PreparedStatement stmt =
                        conn.prepareStatement("INSERT INTO questions_qs (question_qs, fk_id_rp, fk_id_usr) VALUES (?,?,?)")
        ) {
            stmt.setString(1, questions_qs.getQuestion_qs());
            stmt.setInt(2, questions_qs.getFk_id_rp());
            stmt.setInt(3, questions_qs.getFk_id_usr());

            System.out.println(stmt.toString());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}