package com.conference.dao.repos;

import com.conference.dao.entities.Questions_qs;
import com.mysql.cj.protocol.Resultset;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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

    public List<Questions_qs> getQuestionsByReportId(String id_rp){
        DataSource dataSource = new DataSource();
        List<Questions_qs> questions = new ArrayList<>();

        try(
                Connection conn = dataSource.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM questions_qs WHERE fk_id_rp=" + id_rp);
                )
        {
            while ( rs.next() ) {
                questions.add(new Questions_qs(
                   rs.getInt("id_qs"),
                   rs.getString("question_qs"),
                   rs.getInt("rating_qs"),
                   rs.getInt("fk_id_rp"),
                   rs.getInt("fk_id_usr")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return questions;
    }

}