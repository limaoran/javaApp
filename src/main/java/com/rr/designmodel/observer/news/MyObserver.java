package com.rr.designmodel.observer.news;


import java.util.Observable;
import java.util.Observer;

/**
 * Created by Limaoran on 2016/11/16.
 */
public class MyObserver implements Observer {
    @Override
    public void update(Observable o, Object arg) {
        Article art = (Article) arg;
        System.out.println("博主发表了新的文章，快去看吧!");
        System.out.println("博客标题为：" + art.getTitle());
        System.out.println("博客内容为:" + art.getContent());
    }
}
