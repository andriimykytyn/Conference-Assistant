package com.conference.views;

public class ReportsView {
    public String getHtml(){
        IndexSingleton indexSingleton = IndexSingleton.getInstance();
        return indexSingleton.getPage()
                .replace("<!--#main#-->", indexSingleton.getReports());
    }


}