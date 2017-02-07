package com.rr.designmodel.observer.news;

import java.util.Observable;

/**
 * Created by Limaoran on 2016/11/16.
 */
public class BlogUser extends Observable{

    public void publishBlog(String title,String content){
        Article article = new Article(title,content);
        System.out.println("博主:发表新文章，文章标题:" + title + ",文章内容:" + content);
        this.setChanged();
        this.notifyObservers(article);
    }
}
