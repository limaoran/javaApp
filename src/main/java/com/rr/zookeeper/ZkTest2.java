package com.rr.zookeeper;

import org.apache.zookeeper.*;

/**
 * Created by Limaoran on 2016/9/18.
 */
public class ZkTest2 implements Watcher{

    public static String url = "MasterWin:2181";
    public static String root = "/zk";
    public static String child1 = "/zk/child1";

    public static String authType = "digest";
    public static String authPassword = "password";

    public static void main(String[] args) throws Exception{
        ZooKeeper zk = new ZooKeeper(url, 3000, new ZkTest2());

        // 授权、加密操作
        zk.addAuthInfo(authType,authPassword.getBytes());

        // 确保连接上之后再往下走
        while (zk.getState() != ZooKeeper.States.CONNECTED ){
            Thread.sleep(3000);
        }

        String createPath = null;
        if(zk.exists(root,true) == null){
            createPath = zk.create(root,"root".getBytes(), ZooDefs.Ids.CREATOR_ALL_ACL, CreateMode.PERSISTENT);
        }
        System.out.println("root path："+createPath);
        if(zk.exists(child1,true) ==null){
            // 创建临时节点
            createPath = zk.create(child1,"child1".getBytes(),ZooDefs.Ids.CREATOR_ALL_ACL,CreateMode.PERSISTENT);
        }
        System.out.println("child path:"+createPath);

        String rootData = new String( zk.getData(root,true ,null) );   //Stat可以设置一个版本号，Zookeeper可以保存多个版本
        System.out.println("RootData:"+rootData);

        zk.setData(root,"root update 1".getBytes(),-1);    //-1覆盖所有的版本

        rootData = new String( zk.getData(root,true ,null) );   //Stat可以设置一个版本号，Zookeeper可以保存多个版本
        System.out.println("RootData:"+rootData);

        System.out.println(zk.getChildren(root,true));

        System.out.println("----------------------------");
        System.out.println("ChildData:"+new String(zk.getData(child1,false,null)));  //true和false设置是否监听，true会触发Watcher事件，false不会
        zk.setData(child1 , "child1 update".getBytes(),-1);
        // 这里打印数据时，事件会发生在打印数据后，因为事情已经发生了，事件从服务器返回到客户端再执行，会慢一些！因为是异步传输的！
        System.out.println("ChildData:"+new String(zk.getData(child1,true,null)));

        // close时，会删除临时节点，会触发 NodeDelete 事件
        zk.close();
    }

    @Override
    public void process(WatchedEvent event) {
        System.out.println("触发了事件："+ event.getType());
//                System.out.println("事件状态："+event.getState());
        switch (event.getType()){
            case NodeCreated:{
                System.out.println("节点创建成功！");
                break;
            }
            case NodeDeleted:{
                System.out.println("节点删除成功！");
                break;
            }
            case NodeDataChanged:{
                System.out.println("节点更新成功！");
                break;
            }
            case NodeChildrenChanged:{
                System.out.println("子节点创建成功！");
                break;
            }
            case None:{
                System.out.println("连接服务器成功！");
                break;
            }
            default:
        }
    }
}
