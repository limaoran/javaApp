package com.rr.designmodel.facade.news;

/**
 * 把购买国债、股票、期货等物品交给基金来处理，这样用户不用关心国债、股票等具体的细节，而只和基金打交道即可！
 * 用户就可以只关心能赚到钱就可以了。
 * Created by Limaoran on 2016/11/17.
 */
public class JiJin {
    private GuoZhai guoZhai;
    private GuPiao guPiao;
    private QiHuo qiHuo;
    public JiJin(){
        this.guoZhai = new GuoZhai();
        this.guPiao = new GuPiao();
        this.qiHuo = new QiHuo();
    }
    public void maiJiJinA(){
        guoZhai.mai();
        guPiao.mai();
    }
    public void maiJiJinB(){
        guoZhai.mai();
        guPiao.mai();
        qiHuo.mai();
    }
}
class GuoZhai{
    public void mai(){
        System.out.println("买国债");
    }
}
class GuPiao{
    public void mai(){
        System.out.println("买股票");
    }
}
class QiHuo{
    public void mai(){
        System.out.println("买期货");
    }
}
