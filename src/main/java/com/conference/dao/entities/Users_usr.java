package com.conference.dao.entities;

public class Users_usr {
    private int id_usr;
    private String firstname_usr;
    private String lastname_usr;
    private String email_usr;
    //'USER','ADMIN','MODER'
    private String role_usr;
    private String nickname_usr;
    private String password_usr;

    public Users_usr() {
    }

    public Users_usr(int id_usr, String firstname_usr, String lastname_usr, String email_usr, String role_usr, String nickname_usr, String password_usr) {
        this.id_usr = id_usr;
        this.firstname_usr = firstname_usr;
        this.lastname_usr = lastname_usr;
        this.email_usr = email_usr;
        this.role_usr = role_usr;
        this.nickname_usr = nickname_usr;
        this.password_usr = password_usr;
    }

    public int getId_usr() {
        return id_usr;
    }

    public void setId_usr(int id_usr) {
        this.id_usr = id_usr;
    }

    public String getFirstname_usr() {
        return firstname_usr;
    }

    public void setFirstname_usr(String firstname_usr) {
        this.firstname_usr = firstname_usr;
    }

    public String getLastname_usr() {
        return lastname_usr;
    }

    public void setLastname_usr(String lastname_usr) {
        this.lastname_usr = lastname_usr;
    }

    public String getEmail_usr() {
        return email_usr;
    }

    public void setEmail_usr(String email_usr) {
        this.email_usr = email_usr;
    }

    public String getRole_usr() {
        return role_usr;
    }

    public void setRole_usr(String role_usr) {
        this.role_usr = role_usr;
    }

    public String getNickname_usr() {
        return nickname_usr;
    }

    public void setNickname_usr(String nickname_usr) {
        this.nickname_usr = nickname_usr;
    }

    public String getPassword_usr() {
        return password_usr;
    }

    public void setPassword_usr(String password_usr) {
        this.password_usr = password_usr;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id_usr +
                ", firstname='" + firstname_usr + '\'' +
                ", lastname='" + lastname_usr + '\'' +
                ", email='" + email_usr + '\'' +
                ", role='" + role_usr + '\'' +
                ", nickname='" + nickname_usr + '\'' +
                ", password='" + password_usr + '\'' +
                '}';
    }
}