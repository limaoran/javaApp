package com.rr.zookeeper;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;

import java.net.InetAddress;

/**
 * 锁实现
 * Created by Limaoran on 2016/9/18.
 */
public class Lock {
    private String path;
    private ZooKeeper zooKeeper;
    public Lock(String path){
        this.path = path;;
    }

    /**
     * 上锁
     */
    public synchronized void lock()throws Exception{
        Stat stat = zooKeeper.exists(path,true);
        String data = InetAddress.getLocalHost().getHostAddress()+":lock" ;
        zooKeeper.setData(path,data.getBytes(),stat.getVersion());
    }

    /**
     * 开锁
     * @throws Exception
     */
    public synchronized void unLock()throws Exception{
        Stat stat = zooKeeper.exists(path,true);
        String data = InetAddress.getLocalHost().getHostAddress()+":unlock";
        zooKeeper.setData(path,data.getBytes(),stat.getVersion());
    }

    /**
     * 是否锁住了
     * @throws Exception
     */
    public synchronized boolean isLock() {
        try {
            Stat stat = zooKeeper.exists(path,true);
            String data = InetAddress.getLocalHost().getHostAddress()+":lock";
            String nodeData = new String ( zooKeeper.getData(path,true,stat));
            if(data.equals(nodeData)){
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public ZooKeeper getZooKeeper() {
        return zooKeeper;
    }

    public void setZooKeeper(ZooKeeper zooKeeper) {
        this.zooKeeper = zooKeeper;
    }
}
