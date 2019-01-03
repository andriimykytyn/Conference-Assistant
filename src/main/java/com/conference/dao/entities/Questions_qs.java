package com.conference.dao.entities;

public class Questions_qs implements Comparable<Questions_qs> {
    private int id_qs;
    private String question_qs;
//  DEFAULT - 0
    private int rating_qs;
    private int fk_id_rp;
    private int fk_id_usr;

    @Override
    public int compareTo(Questions_qs other) {
        return Integer.compare(rating_qs,other.rating_qs);
    }

    public Questions_qs() {

    }

    public Questions_qs(int id_qs, String question_qs, int rating_qs, int fk_id_rp, int fk_id_usr) {
        this.id_qs = id_qs;
        this.question_qs = question_qs;
        this.rating_qs = rating_qs;
        this.fk_id_rp = fk_id_rp;
        this.fk_id_usr = fk_id_usr;
    }

    public int getId_qs() {
        return id_qs;
    }

    public void setId_qs(int id_qs) {
        this.id_qs = id_qs;
    }

    public String getQuestion_qs() {
        return question_qs;
    }

    public void setQuestion_qs(String question_qs) {
        this.question_qs = question_qs;
    }

    public int getRating_qs() {
        return rating_qs;
    }

    public void setRating_qs(int rating_qs) {
        this.rating_qs = rating_qs;
    }

    public int getFk_id_rp() {
        return fk_id_rp;
    }

    public void setFk_id_rp(int fk_id_rp) {
        this.fk_id_rp = fk_id_rp;
    }

    public int getFk_id_usr() {
        return fk_id_usr;
    }

    public void setFk_id_usr(int fk_id_usr) {
        this.fk_id_usr = fk_id_usr;
    }

    @Override
    public String toString() {
        return "Question{" +
                "id=" + id_qs +
                ", question='" + question_qs + '\'' +
                ", rating='" + rating_qs + '\'' +
                ", fk_report_id='" + fk_id_rp + '\'' +
                ", fk_user_id='" + fk_id_usr + '\'' +
                "}";
    }
}