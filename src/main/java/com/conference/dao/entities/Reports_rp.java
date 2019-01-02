package com.conference.dao.entities;

public class Reports_rp {
    private int id_rp;
    private String name_rp;
    private String announcer_rp;
    private int fk_id_cf;

    public Reports_rp() {

    }

    public Reports_rp(int id_rp, String name_rp, String announcer_rp, int fk_id_cf) {
        this.id_rp = id_rp;
        this.name_rp = name_rp;
        this.announcer_rp = announcer_rp;
        this.fk_id_cf = fk_id_cf;
    }

    public int getId_rp() {
        return id_rp;
    }

    public void setId_rp(int id_rp) {
        this.id_rp = id_rp;
    }

    public String getName_rp() {
        return name_rp;
    }

    public void setName_rp(String name_rp) {
        this.name_rp = name_rp;
    }

    public String getAnnouncer_rp() {
        return announcer_rp;
    }

    public void setAnnouncer_rp(String announcer_rp) {
        this.announcer_rp = announcer_rp;
    }

    public int getFk_id_cf() {
        return fk_id_cf;
    }

    public void setFk_id_cf(int fk_id_cf) {
        this.fk_id_cf = fk_id_cf;
    }

    @Override
    public String toString() {
        return "Reports{" +
                "id_rp='" + id_rp + '\'' +
                "name_rp='" + name_rp + '\'' +
                "announcer_rp='" + announcer_rp + '\'' +
                "fk_id_cf='" + fk_id_cf + '\'' +
                "}";
    }
}