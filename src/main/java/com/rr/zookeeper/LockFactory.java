package com.rr.zookeeper;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.ACL;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;
import java.net.InetAddress;
import java.util.Collections;

/**
 * Created by Limaoran on 2016/9/18.
 */
public class LockFactory {
    public static final ZooKeeper DEFAULT_ZOOKEEPER = getDefaultZookeeper();

    //data格式:  ip:stat  如: 192.168.1.107:lock   or    192.168.1.107:unlock
    public static synchronized Lock getLock(String path ,String ip)throws Exception  {
        if(DEFAULT_ZOOKEEPER != null){
            Stat stat = null;
            try {
                stat = DEFAULT_ZOOKEEPER.exists(path,true);
            } catch (Exception e) {
                e.printStackTrace();
            }
            if(stat !=null){
                try {
                    byte[] data = DEFAULT_ZOOKEEPER.getData(path, null, stat);
                    String dataStr = new String(data);
                    String[] ipv = dataStr.split(":");
                    if(ip.equals(ipv[0])){
                        Lock lock = new Lock(path);
                        lock.setZooKeeper(DEFAULT_ZOOKEEPER);
                        return lock;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }else{ // no lock created yet, you can get it
                createZNode(path);
                Lock lock = new Lock(path);
                lock.setZooKeeper(DEFAULT_ZOOKEEPER);
                return lock;
            }
        }
        return null;
    }

    public static ZooKeeper getDefaultZookeeper(){
        try {
            ZooKeeper zooKeeper = new ZooKeeper("MasterWin:2181", 3000, new Watcher() {
                @Override
                public void process(WatchedEvent event) {
                    System.out.println("event: " + event.getType());
                }
            });
            while(zooKeeper.getState()!= ZooKeeper.States.CONNECTED){
                Thread.sleep(3000);
            }
            return zooKeeper;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    static void createZNode(String path)throws Exception{
        if(DEFAULT_ZOOKEEPER!=null){
            InetAddress address = InetAddress.getLocalHost();
            String data = address.getHostAddress()+":unlock";
            DEFAULT_ZOOKEEPER.create(path,data.getBytes(), Collections.singletonList(new ACL(ZooDefs.Perms.ALL, ZooDefs.Ids.ANYONE_ID_UNSAFE)), CreateMode.EPHEMERAL );
        }
    }

    /**
     * 控制不同进程使用某公共资源
     * @param args
     */
    public static void main(String[] args)throws Exception {
        InetAddress address = InetAddress.getLocalHost();
        while(true)  {
            Lock lock = LockFactory.getLock("/root", address.toString());
            if (lock == null) { //后面在获取就是这个状态
                //to do
                System.out.println("被上锁了");
            } else { //第一次获取处于这个状态
                System.out.println("没上锁，sleep..."+lock.isLock());
                Thread.sleep(5*1000);
                lock.unLock();
            }
            Thread.sleep(1000);
        }
    }
}
