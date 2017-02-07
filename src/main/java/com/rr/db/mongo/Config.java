package com.rr.db.mongo;

import java.io.InputStream;
import java.util.Properties;

/**
 * Created by Limaoran on 2016/9/27.
 */
public class Config {
    /** db的ip */
    private static String dbServerIP="127.0.0.1";
    /** db的端口 */
    private static int dbServerPort=27017;
    /** 数据库名称 */
    private static String dbName="chacha";
    /** 连接数据库用户名 */
    private static String dbUsername="chacha";
    /** 连接数据库密码 */
    private static String dbPassword="cha123";
    /**
     * 连接串，适用于多db server的情况，连接描述符配置了，
     * 则dbServerIP、dbServerPort配置失效.格式ip1:port1,ip2:port2
     */
    private static String connectionDescriptor=null;
    /** 连接池大小 */
    private static int connectionsPerHost=90;
    /** 等待链接的线程池，与连接池大小相等，为允许等待的线程数  */
    private static int threadsAllowedToBlockForConnectionMultiplier=20;
    /** 建立数据库连接时的超时时长，单位毫秒 */
    private static int connectTimeout=30000;
    /** 是否自动重连 */
    private static boolean autoConnectRetry=true;
    private static int serverPort=9001;
    private static int tokenLifeTime=3600;

    static{
        try{
            Properties prop = new Properties();
            InputStream is = Config.class.getClassLoader().getResourceAsStream("identity.properties");
            prop.load(is);
            dbServerIP=prop.getProperty("dbServerIP");
            dbServerPort=Integer.parseInt(prop.getProperty("dbServerPort"));
            dbName=prop.getProperty("dbName");
            dbUsername=prop.getProperty("dbUsername");
            dbPassword=prop.getProperty("dbPassword");
            connectionDescriptor=prop.getProperty("connectionDescriptor");
            connectionsPerHost=Integer.parseInt((String)prop.getProperty("poolSize"));
            threadsAllowedToBlockForConnectionMultiplier=Integer.parseInt((String)prop.getProperty("threadsAllowedToBlockForConnectionMultiplier"));
            connectTimeout=Integer.parseInt((String)prop.getProperty("connectTimeout"));
            autoConnectRetry=Boolean.parseBoolean((String)prop.getProperty("autoConnectRetry"));
            serverPort=Integer.parseInt(prop.getProperty("ServerPort"));
            tokenLifeTime=Integer.parseInt(prop.getProperty("tokenLifeTime"));
        }catch (Exception e) {
            throw new ExceptionInInitializerError("chacha server argument init error!");
        }
    }

    public static String getDbServerIP() {
        return dbServerIP;
    }

    public static int getDbServerPort() {
        return dbServerPort;
    }

    public static String getDbName() {
        return dbName;
    }

    public static String getDbUsername() {
        return dbUsername;
    }

    public static String getDbPassword() {
        return dbPassword;
    }

    public static String getConnectionDescriptor() {
        return connectionDescriptor;
    }

    public static int getConnectionsPerHost() {
        return connectionsPerHost;
    }

    public static int getThreadsAllowedToBlockForConnectionMultiplier() {
        return threadsAllowedToBlockForConnectionMultiplier;
    }

    public static int getConnectTimeout() {
        return connectTimeout;
    }

    public static boolean isAutoConnectRetry() {
        return autoConnectRetry;
    }

    public static int getServerPort() {
        return serverPort;
    }

    public static int getTokenLifeTime() {
        return tokenLifeTime;
    }
}
