package com.rr.db.mongo.model;

import com.mongodb.DBObject;
import com.rr.db.mongo.MongoConnection;

import java.util.Random;

/**
 * 64位字符串的登录令牌，可用于ssl
 * Created by Limaoran on 2016/9/27.
 */
public class LoginToken {
    private String _id;
    /** 用户名 */
    private String username;
    /** 令牌 */
    private String token;

    public final static long INVALID = -1;
    /** 令牌有效期 */
    private long tokenLifeTime = INVALID;
    private static Random random = new Random();
    private static final int HOUR = 60 * 60 * 1000;

    public LoginToken(){}

    /**
     * 默认有效期1小时的令牌构造方法
     * @param username
     */
    public LoginToken(String username){
        this(username,HOUR);
    }

    /**
     * @param username 用户名
     * @param tokenLifeTime 有效期，单位毫秒
     */
    public LoginToken(String username,long tokenLifeTime){
        super();
        this.username = username;
        long now = System.currentTimeMillis();
        String src = username+(random.nextLong()+now);
        this.token = DigestUtil.digestPassword(src);
        // 令牌有效期
        this.tokenLifeTime = now + tokenLifeTime;
    }

    public DBObject toDBObject(){
        DBObject entity = MongoConnection.getDBObject();
        entity.put("_id",_id);
        entity.put("username",username);
        entity.put("token",token);
        entity.put("tokenLifeTime",tokenLifeTime);
        return entity;
    }
    public void fromDBObject(DBObject obj){
        this._id = (String) obj.get("_id");
        this.username = (String) obj.get("username");
        this.token = (String) obj.get("token");
        this.tokenLifeTime = (long) obj.get("tokenLifeTime");
    }

    public static void main(String[] args) {
        LoginToken token = new LoginToken("chacha");
        System.out.println(token.getToken());

        token = new LoginToken("chacha",3600*1000*2);
        System.out.println(token.getToken());
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

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public long getTokenLifeTime() {
        return tokenLifeTime;
    }

    public void setTokenLifeTime(long tokenLifeTime) {
        this.tokenLifeTime = tokenLifeTime;
    }
}
