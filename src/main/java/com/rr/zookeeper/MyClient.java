package com.rr.zookeeper;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

import java.io.IOException;

/**
 * 读数据及监听数据变化获取最新数据
 * Created by Limaoran on 2016/9/18.
 */
public class MyClient implements Watcher {

    private String urlStr ;
    private String usernameStr ;
    private String passwordStr ;

    private ZooKeeper zk ;

    public MyClient(){
        try {
            zk = new ZooKeeper(SetConfig.url,3000,this);

            while(zk.getState()!= ZooKeeper.States.CONNECTED){
                Thread.sleep(3000);
            }
            System.out.println("连接服务器成功！");

            zk.addAuthInfo(SetConfig.authType,SetConfig.authPassword.getBytes());

            init();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void init()throws Exception{
        urlStr = new String(zk.getData(SetConfig.urlNode,true,null));
        usernameStr = new String(zk.getData(SetConfig.usernameNode,true,null));
        passwordStr = new String(zk.getData(SetConfig.passwordNode,true,null));
    }

    @Override
    public void process(WatchedEvent event) {
        System.out.println("触发了事件："+event.getType());
        switch (event.getType()){
            case NodeCreated:{
                System.out.println("节点创建成功！");
                break;
            }
            case NodeDeleted:{
                System.out.println("节点删除成功！");
                break;
            }
            case NodeDataChanged:
            case NodeChildrenChanged:{
                System.out.println("节点更新成功！");
                try {
                    init();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            }
            case None:{
                System.out.println("连接服务器成功！");
                break;
            }
            default:
        }
    }

    public static void main(String[] args) throws Exception{
        MyClient client = new MyClient();

        for(int i=0;i<5;i++){
            System.out.println("--------------当前值------------");
            System.out.println(client.getUrlStr());
            System.out.println(client.getUsernameStr());
            System.out.println(client.getPasswordStr());
            Thread.sleep(10000);
        }
    }

    public String getUrlStr() {
        return urlStr;
    }
    public String getUsernameStr() {
        return usernameStr;
    }
    public String getPasswordStr() {
        return passwordStr;
    }
    public ZooKeeper getZk() {
        return zk;
    }
}
