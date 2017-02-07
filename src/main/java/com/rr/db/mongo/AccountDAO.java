package com.rr.db.mongo;


import com.mongodb.BasicDBObject;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.IndexOptions;
import com.rr.db.mongo.model.Account;

/**
 * Created by Limaoran on 2016/9/27.
 */
public class AccountDAO extends AbstractDAO {
    public static final String COLLECTION_ACCOUNT = "account";
    static{
        // 创建索引
        MongoCollection collection = connection.getCollection(COLLECTION_ACCOUNT);
        IndexOptions opt = new IndexOptions();
        opt.name("idx_name");
        collection.createIndex(new BasicDBObject("username",1),opt);
    }

    /**
     * 通过_id查询账号
     * @param id
     * @return
     */
    public Account getAccountById(String id){
        MongoCollection collection =  connection.getCollection(COLLECTION_ACCOUNT);
        return null;
    }

}
