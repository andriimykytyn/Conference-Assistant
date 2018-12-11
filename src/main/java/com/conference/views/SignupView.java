package com.conference.views;

public class SignupView{

    public String getHtml() {
        IndexSingleton indexSingleton = IndexSingleton.getInstance();
        return indexSingleton.getPage()
                .replace("<!--#header#-->", indexSingleton.getHeader())
                .replace("<!--#main#-->", indexSingleton.getRegister())
                .replace("#action#", "/login")
                .replace("<!--#useraction#-->", "Log in")
                .replace("<!--#useraction#-->","Log in");
    }

}