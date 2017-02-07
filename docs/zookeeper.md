# zookeeper

## zookeeper命令

```sh
# zkCli.cmd
# ls /
# create /test "testValue"
# get /test
# create /test/child1 child1Value
# get /test/child1

```


## ZooDefs

zookeeper针对每个路径都可以设置权限

* ANYONE_ID_UNSAFE  任何人都可以访问
* AUTH_IDS          有权限的才可以访问
* OPEN_ACL_UNSAFE   创建者有所有的权限
* CREATOR_ALL_ACL   所有人都可以访问
* READ_ACL_UNSAFE   只读权限

## CreateMode

* EPHEMERAL             临时节点
* EPHEMERAL_SEQUENTIAL
* PERSISTENT            持久化节点
* PERSISTENT_SEQUENTIAL

## Zookeeper简单Demo

代码实现：
```java
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
```
执行结果：
```sh
触发了事件：None
触发了事件：NodeCreated
RootData:root update 1
触发了事件：NodeDataChanged
RootData:root update 1
[child1]
----------------------------
ChildData:child1
ChildData:child1 update
触发了事件：NodeDeleted
触发了事件：NodeChildrenChanged
```

## Java Client 进阶练习（加密操作）

ACL: 是针对用户访问的控制

Zookeeper的void addAuthInfo(java.lang.String scheme, byte[ ] auth)是 加密操作，对一个session下创建的path进行加密

通常和ZooDefs.Ids. CREATOR_ALL_ACL  一起用

代码实现：
```java
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
```

执行结果：
```text
触发了事件：None
连接服务器成功！
触发了事件：NodeCreated
节点创建成功！
root path：/zk
触发了事件：NodeCreated
节点创建成功！
child path:/zk/child1
RootData:root
触发了事件：NodeDataChanged
节点更新成功！
RootData:root update 1
[child1]
----------------------------
ChildData:child1
ChildData:child1 update
```

## 案例一：配置管理

写配置：SetConfig.java
```java
public class SetConfig {

    public static String url = "MasterWin:2181";
    public static String root = "/myConf";

    // 数据库连接url、username、password
    public static String urlNode = root+"/url";
    public static String usernameNode = root + "/username";
    public static String passwordNode = root + "/password";

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

        while(zk.getState()!= ZooKeeper.States.CONNECTED){
            Thread.sleep(3000);
        }
        zk.addAuthInfo(authType,authPassword.getBytes());
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
            zk.create(passwordNode,"admin123".getBytes(), ZooDefs.Ids.CREATOR_ALL_ACL,CreateMode.PERSISTENT);
        }
        zk.close();
    }
}
```

读数据及监听数据变化获取最新数据：MyClient.java
```java
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
```

## 案例二：分布式锁实现


