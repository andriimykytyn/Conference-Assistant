package com.conference.views;

public class ReportsView {

    public String getHtml(){
        IndexSingleton indexSingleton = IndexSingleton.getInstance();
        return indexSingleton.getPage()
                .replace("<!--#header#-->", indexSingleton.getHeader())
                .replace("<li class=\"nav-item active\">\n" +
                        "                <a class=\"nav-link\" href=\"/main\"><!--#Conferences#--></a>"
                        , "<li class=\"nav-item\">\n" +
                        "                <a class=\"nav-link\" href=\"/main\">Conferences</a>")
                .replace("<li class=\"nav-item\">\n" +
                        "                <a class=\"nav-link\" href=\"/reports\"><!--#Reports#--></a>"
                        , "<li class=\"nav-item active\">\n" +
                        "                <a class=\"nav-link\" href=\"/reports\">Reports</a>")
                .replace("<!--#Questions#-->", "Questions")
                .replace("<!--#useraction#-->", "Log out")
                .replace("#action#", "/user/logout");
    }


}