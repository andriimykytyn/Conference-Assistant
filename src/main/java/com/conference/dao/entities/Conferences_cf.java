package com.conference.dao.entities;

public class Conferences_cf {
    private int id_cf;
    private String name_cf;
    private String info_cf;

    public Conferences_cf() {
    }

    public Conferences_cf(int id_cf, String name_cf, String info_cf) {
        this.id_cf = id_cf;
        this.name_cf = name_cf;
        this.info_cf = info_cf;
    }

    public int getId_cf() {
        return id_cf;
    }

    public void setId_cf(int id_cf) {
        this.id_cf = id_cf;
    }

    public String getName_cf() {
        return name_cf;
    }

    public void setName_cf(String name_cf) {
        this.name_cf = name_cf;
    }

    public String getInfo_cf() {
        return info_cf;
    }

    public void setInfo_cf(String info_cf) {
        this.info_cf = info_cf;
    }

    @Override
    public String toString() {
        return "Conference{" +
                "id_cf='" + id_cf + '\'' +
                ", name_cf='" + name_cf + '\'' +
                ", info_cf='" + info_cf + '\'' +
                "}";
    }
}