package com.rr.db.mongo.model;

import com.mongodb.DBObject;
import com.rr.db.mongo.MongoConnection;

/**
 * Created by Limaoran on 2016/9/27.
 */
public class Account {
    private String _id;
    /** 用户名 */
    private String username;
    /** 密码 */
    private String password;
    /** 账号其它属性，可扩展，格式为json */
    private String acctAttr;

    public DBObject toDBObject(){
        DBObject entity = MongoConnection.getDBObject();
//        BasicDBObject entity = new BasicDBObject();
        entity.put("_id",_id);
        entity.put("username",username);
        entity.put("password",password);
        entity.put("acctAttr",acctAttr);
        return entity;
    }
    public void fromDBObject(DBObject entity){
        this._id = (String) entity.get("_id");
        this.username = (String) entity.get("username");
        this.password = (String) entity.get("password");
        this.acctAttr = (String) entity.get("acctAttr");
    }

    public String get_id() {
        return _id;
    }
    public void set_id(String _id) {
        this._id = _id;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getAcctAttr() {
        return acctAttr;
    }
    public void setAcctAttr(String acctAttr) {
        this.acctAttr = acctAttr;
    }
}
