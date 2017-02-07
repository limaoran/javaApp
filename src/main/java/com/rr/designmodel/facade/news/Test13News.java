package com.rr.designmodel.facade.news;

/**
 * Created by Limaoran on 2016/11/17.
 */
public class Test13News {
    public static void main(String[] args) {
        // 80年代，基金出现之前
        GuPiao gupiao = new GuPiao();
        gupiao.mai();

        QiHuo qihuo = new QiHuo();
        qihuo.mai();

        GuoZhai guozhai = new GuoZhai();
        guozhai.mai();

        System.out.println();
        // 有了基金之后
        JiJin jijin = new JiJin();

        jijin.maiJiJinA();
        System.out.println("======================");
        jijin.maiJiJinB();
    }
}
