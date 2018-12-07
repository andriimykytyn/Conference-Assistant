package com.conference.views;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class IndexSingleton {

    private String htmlPath;
    private String page;

    private static IndexSingleton ourInstance = new IndexSingleton();

    public static IndexSingleton getInstance() {
        return ourInstance;
    }

    private IndexSingleton() {
    }


    public String getHtmlPath() {
        return htmlPath;
    }

    public void setHtmlPath(String htmlPath) {
        this.htmlPath = htmlPath;
    }

    public String getPage() { return page; }

    public void setPage(String page) { this.page = page; }

    public String getPartialHtml(String filename) {
        StringBuilder strb = new StringBuilder();
        Path file = Paths.get(this.htmlPath + filename);
        Charset charset = Charset.forName("UTF-8");

        try(BufferedReader reader = Files.newBufferedReader(file, charset)) {
            String line = null;
            while ((line = reader.readLine()) != null) {
                strb.append(line).append("\n");
            }
        } catch (IOException e) {
            System.err.format("IOException: %s%n", e);
        }

        return strb.toString();
    }
}
