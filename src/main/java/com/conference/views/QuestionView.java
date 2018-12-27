package com.conference.views;

public class QuestionView {
    public String getHtml() {
        IndexSingleton indexSingleton = IndexSingleton.getInstance();
        return indexSingleton.getPage()
                .replace("<!--#header#-->", indexSingleton.getHeader())
                .replace("<li class=\"nav-item active\">\n" +
                        "                <a class=\"nav-link\" href=\"/main\"><!--#Conferences#--></a>\n" +
                        "            </li>", "<li class=\"nav-item\">\n" +
                        "                <a class=\"nav-link\" href=\"/main\">Conferences</a>\n" +
                        "            </li>")
                .replace("<!--#Reports#-->", "Reports")
                .replace("<li class=\"nav-item\">\n" +
                        "                <a class=\"nav-link\" href=\"/questions\"><!--#Questions#--></a>\n" +
                        "            </li>", "<li class=\"nav-item active\">\n" +
                        "                <a class=\"nav-link\" href=\"/questions\">Questions</a>\n" +
                        "            </li>")
                .replace("<!--#useraction#-->", "Log out")
                .replace("#action#", "/user/logout")
                .replace("<!--#main#-->",indexSingleton.getQuestions())
                .replace("<footer class=\"container-fluid\">\n" +
                        "    <div class=\"row\">\n" +
                        "        <div class=\"col-12\">\n" +
                        "            <p>CA, Andrew Mykytyn.</p>\n" +
                        "        </div>\n" +
                        "    </div>\n" +
                        "</footer>", "");
    }
}