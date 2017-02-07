package com.rr.db.mongo;

import com.mongodb.*;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.rr.log.LogPrint;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Limaoran on 2016/9/27.
 */
public class MongoConnection  {
    private LogPrint log = new LogPrint(getClass());

    private MongoDatabase db;

    public MongoConnection() {
        super();
    }

    static BasicDBObjectBuilder builder = new BasicDBObjectBuilder();

    public static DBObject getDBObject(){
        return builder.get();
    }

    public MongoCollection getCollection(String name) {
        return db.getCollection(name);
    }

    public void connect() {
        try{
            MongoClient client = null;

            // 连接池参数
            MongoClientOptions.Builder builder = MongoClientOptions.builder();
            builder.connectionsPerHost(Config.getConnectionsPerHost());
            builder.threadsAllowedToBlockForConnectionMultiplier(Config.getThreadsAllowedToBlockForConnectionMultiplier());
            builder.connectTimeout(Config.getConnectTimeout());

            if(Config.getConnectionDescriptor()!=null){
                String[] hosts = Config.getConnectionDescriptor().split(",");
                List<ServerAddress> addressList = new ArrayList<>(hosts.length);
                for(String host : hosts){
                    String []hostPortPair = host.split(":");
                    int port = 27017;
                    if (hostPortPair.length > 1) {
                        try {
                            port = Integer.parseInt(hostPortPair[1]);
                        } catch (NumberFormatException e) {
                        }
                    }
                    addressList.add(new ServerAddress(hostPortPair[0],port));
                }
                client = new MongoClient(addressList,builder.build());
            }else {
                client = new MongoClient(new ServerAddress(Config.getDbServerIP(), Config.getDbServerPort()),builder.build());
            }

            db = client.getDatabase(Config.getDbName());

            log.info("MongoConnection init success!");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
