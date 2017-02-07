package com.rr.db.mongo;

import com.mongodb.DBObject;
import com.mongodb.QueryBuilder;
import com.rr.log.LogPrint;
import org.bson.types.ObjectId;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by Limaoran on 2016/9/27.
 */
public class AbstractDAO {
    protected final LogPrint log = new LogPrint(getClass());
    protected static String dbServerIP ;
    protected static int dbServerPort ;
    protected static String dbName ;
    protected static String dbUserName;
    protected static String dbPassword;
    protected static String connectionDescriptor;
    private static int connectionsPerHost=90;
    private static int threadsAllowedToBlockForConnectionMultiplier=20;
    private static int connectTimeout=30000;
    private static boolean autoConnectRetry=true;
    protected static MongoConnection connection=new MongoConnection();

    static{
        try {
            Properties prop = new Properties();
            InputStream is = AbstractDAO.class.getClassLoader().getResourceAsStream("/mongodb.properties");
            prop.load(is);
            dbServerIP=Config.getDbServerIP();
            dbServerPort=Config.getDbServerPort();
            dbName=Config.getDbName();
            dbUserName=Config.getDbUsername();
            dbPassword=Config.getDbPassword();
            connectionDescriptor=Config.getConnectionDescriptor();
            connectionsPerHost=Config.getConnectionsPerHost();
            threadsAllowedToBlockForConnectionMultiplier=Config.getThreadsAllowedToBlockForConnectionMultiplier();
            connectTimeout=Config.getConnectTimeout();
            autoConnectRetry=Config.isAutoConnectRetry();

            connection = new MongoConnection();
            connection.connect();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public MongoConnection getConnection(){
        return connection;
    }

    protected DBObject queryById(String id){
        return QueryBuilder.start("_id").is(id).get();
    }
    protected String generateId(){
        return new ObjectId().toHexString();
    }
}
