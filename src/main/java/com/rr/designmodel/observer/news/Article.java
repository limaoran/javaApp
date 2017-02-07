package com.rr.designmodel.observer.news;

/**
 * Created by Limaoran on 2016/11/16.
 */
public class Article {
    private String title;
    private String content;

    public Article() {
    }

    public Article(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
