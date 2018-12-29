package com.conference.views;

public class QuestionView {
    public String getHtml() {
        IndexSingleton indexSingleton = IndexSingleton.getInstance();
        return indexSingleton.getPage()
                .replace("<!--#header#-->", indexSingleton.getHeader())
                .replace("<li class=\"nav-item active\">\n" +
                        "                        <a class=\"nav-link\" href=\"/reports\">Reports</a>"
                        , "<li class=\"nav-item\">\n" +
                        "                        <a class=\"nav-link\" href=\"/reports\">Reports</a>")
                .replace("<li class=\"nav-item\">\n" +
                        "                <a class=\"nav-link\" href=\"/questions\"><!--#Questions#--></a>\n" +
                        "            </li>", "<li class=\"nav-item active\">\n" +
                        "                <a class=\"nav-link\" href=\"/questions\">Questions</a>\n" +
                        "            </li>")
                .replace("<li class=\"nav-item active\">\n" +
                        "                <a class=\"nav-link\" href=\"/main\"><!--#Conferences#--></a>",
                        "<li class=\"nav-item\">\n" +
                                "                <a class=\"nav-link\" href=\"/main\">Conferences</a>")
                .replace("<li class=\"nav-item\">\n" +
                        "                <a class=\"nav-link\" href=\"/reports\"><!--#Reports#--></a>",
                        "<li class=\"nav-item\">\n" +
                                "                <a class=\"nav-link\" href=\"/reports\">Reports</a>")
                .replace("<!--#useraction#-->", "Log out")
                .replace("#action#", "/user/logout")
                .replace("<!--#main#-->",indexSingleton.getQuestions());
    }
}