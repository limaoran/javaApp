package com.rr.designmodel.observer.news;

/**
 * Created by Limaoran on 2016/11/16.
 */
public class Test10 {
    public static void main(String[] args) {
        BlogUser user = new BlogUser();
        user.addObserver(new MyObserver());
        user.publishBlog("哈哈，博客上线了", "大家多来访问");
    }
}
