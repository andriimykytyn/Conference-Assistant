package com.conference.views;

import com.conference.dao.entities.Users_usr;
import com.conference.dao.repos.UserRepo;

import javax.servlet.http.HttpSession;

public class MainView {

    public String getHtml() {
        IndexSingleton indexSingleton = IndexSingleton.getInstance();
        return indexSingleton.getPage()
                .replace("<!--#header#-->", indexSingleton.getHeader())
                .replace("<!--#Conferences#-->", "Conferences")
                .replace("<!--#Reports#-->", "Reports")
                .replace("<!--#Questions#-->", "Questions")
                .replace("<!--#useraction#-->", "Log out")
                .replace("#action#", "/user/logout");


    }
}