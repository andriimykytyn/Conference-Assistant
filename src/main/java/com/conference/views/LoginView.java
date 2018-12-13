package com.conference.views;

public class LoginView {

    public String getHtml() {
        IndexSingleton indexSingleton = IndexSingleton.getInstance();
        return indexSingleton.getPage()
                .replace("<!--#header#-->", indexSingleton.getHeader())
                .replace("<!--#main#-->", indexSingleton.getLogin())
                .replace("#action#", "/user/signup")
                .replace("<!--#useraction#-->", "Sign up")
                .replace("<!--#useraction#-->","Sign up");
    }
}