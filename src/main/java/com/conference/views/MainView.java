package com.conference.views;

public class MainView {

    public String getHtml() {
        IndexSingleton indexSingleton = IndexSingleton.getInstance();
        return indexSingleton.getPage()
                .replace("<!--#header#-->", indexSingleton.getHeader())
                .replace("<!--#Conferences#-->", "Conferences")
                .replace("<!--#Reports#-->", "Reports")
                .replace("<!--#Questions#-->", "Questions")
                .replace("<!--#useraction#-->", "Log out")
                .replace("#action#", "/user/logout")
                .replace("<!--#main#-->", indexSingleton.getConferences());


    }
}