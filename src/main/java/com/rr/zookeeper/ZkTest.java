package com.rr.zookeeper;

import org.apache.zookeeper.*;

/**
 * Created by Limaoran on 2016/9/18.
 */
public class ZkTest {

    public static String url = "MasterWin:2181";
    public static String root = "/zk";
    public static String child1 = "/zk/child1";

    public static void main(String[] args) throws Exception{
        ZooKeeper zk = new ZooKeeper(url, 3000, new Watcher() {
            @Override
            public void process(WatchedEvent event) {
                System.out.println("触发了事件："+ event.getType());
//                System.out.println("事件状态："+event.getState());
            }
        });

        // 确保连接上之后再往下走
        while (zk.getState() != ZooKeeper.States.CONNECTED ){
            Thread.sleep(3000);
        }

        if(zk.exists(root,true) == null){
            zk.create(root,"root".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        }
        if(zk.exists(child1,true) ==null){
            // 创建临时节点
            zk.create(child1,"child1".getBytes(),ZooDefs.Ids.OPEN_ACL_UNSAFE,CreateMode.EPHEMERAL);
        }
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
}
