package com.rr.zookeeper;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;

/**
 * 写配置
 * Created by Limaoran on 2016/9/18.
 */
public class SetConfig {

    public static String url = "MasterWin:2181";
    public final static String root = "/myConf";

    // 数据库连接url、username、password
    public final static String urlNode = root+"/url";
    public final static String usernameNode = root + "/username";
    public final static String passwordNode = root + "/password";

    public static String authType = "digest";
    public static String authPassword = "password";

    /**
     * 写配置
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception{

        ZooKeeper zk = new ZooKeeper(url,30900,event->{
            System.out.println("触发了事件："+event.getType());
        });

        zk.addAuthInfo(authType,authPassword.getBytes());

        while(zk.getState()!= ZooKeeper.States.CONNECTED){
            Thread.sleep(3000);
        }
//        zk.delete(urlNode,-1);
//        zk.delete(usernameNode,-1);
//        zk.delete(passwordNode,-1);
//        zk.delete(root,-1);

        if(zk.exists(root,true)==null){
            zk.create(root,"root".getBytes(), ZooDefs.Ids.CREATOR_ALL_ACL, CreateMode.PERSISTENT);
        }
        if(zk.exists(urlNode,true)==null){
            zk.create(urlNode,"192.168.1.107:2181".getBytes(), ZooDefs.Ids.CREATOR_ALL_ACL,CreateMode.PERSISTENT);
        }
        if(zk.exists(usernameNode,true)==null) {
            zk.create(usernameNode,"admin".getBytes(), ZooDefs.Ids.CREATOR_ALL_ACL,CreateMode.PERSISTENT);
        }
        if(zk.exists(passwordNode,true)==null){
            zk.create(passwordNode,"admin1234".getBytes(), ZooDefs.Ids.CREATOR_ALL_ACL,CreateMode.PERSISTENT);
        }

        zk.setData(passwordNode,"admin1234".getBytes(),-1);

        zk.close();
    }
}
