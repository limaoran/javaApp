package com.test.mongo;

import java.net.UnknownHostException;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import com.rr.db.mongo.AccountDAO;
import com.rr.db.mongo.MongoConnection;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.Mongo;
import com.mongodb.WriteConcern;

/**
 *  Result is runned on suse11 enterprise linux virual host,with kernel 2.6.32.12 x86_64,allocate mem=2G
 *	@author: hejing
 *	@date: 2012-11-7-下午03:12:13
 */
public class PerformanceAccountDAOTest {
	AccountDAO dao=new AccountDAO();
    MongoConnection connection;
	private final String SERVERIP="192.168.0.13";
	private final int PORT=30000;
	private final String DBNAME="bbs";
	
	@Before
	public void setUp(){
		connection=dao.getConnection();
		connection.connect();
	}
	/**
	 * WriteConcern.NONE && no username index
	 * 
	 * performanceTest costs=129625
	 *	performanceTest get costs=250
	 *	performanceTest costs=137734
	 *	performanceTest get costs=250
	 *	performanceTest costs=113250
	 *	performanceTest get costs=250
	 *	performanceTest costs=108109
	 *	performanceTest get costs=250
	 *	performanceTest costs=130313
	 *	performanceTest get costs=375  avg=123s
	 * 
	 */
//	@Test
//	public void performanceTest(){
//		DBCollection coll=connection.getCollection(dao.getCollectionName());
//		for(int j=0;j<1;j++){
//			coll.drop();
//			long seq=coll.count();
//			long begin=System.currentTimeMillis();
//			for(long i=seq;i<seq+1000000;i++){
//					Account entity=new Account();
//					entity.setUserName("bbs"+String.valueOf(i));
//					entity.setPasswd("ddddddd");
//					dao.add(entity);
//			}
///*			long end=System.currentTimeMillis();
//			System.out.println("performanceTest costs="+(end-begin));
//			begin=System.currentTimeMillis();
//			Account acct=dao.getAccountByName("bbs0");
//			Assert.assertEquals("bbs0",acct.getUserName());
//			end=System.currentTimeMillis();
//			System.out.println("performanceTest get no index costs="+(end-begin));*/
//		}
//	}
//
//
//	/*
//	 * WriteConcern.SAFE
//	 * performanceWithoutMapperBatchTest costs=64156
//	 * performanceWithoutMapperBatchTest costs=66890
//	 *
//	 * WriteConcern.NONE
//	 * ---------------------------------------------
//	 * performanceWithoutMapperBatchTest costs=59250
//	 * performanceWithoutMapperBatchTest costs=49656
//	 *	performanceWithoutMapperBatchTest costs=50563
//	 *	performanceWithoutMapperBatchTest costs=51469
//	 *	performanceWithoutMapperBatchTest costs=51234
//	 *	performanceWithoutMapperBatchTest costs=54469 avg=51s
//	 */
//
//	//@Test
//	public void performanceWithoutMapperBatchTest() throws UnknownHostException{
//		Mongo m=new Mongo(SERVERIP,PORT);
//		DB db=m.getDB(DBNAME);
//		m.setWriteConcern(WriteConcern.NONE);
//		DBCollection coll=db.getCollection(dao.getCollectionName());
//		for(int j=0;j<5;j++){
//			coll.drop();
//			long seq=coll.count();
//			long begin=System.currentTimeMillis();
//			List<DBObject> accounts=new LinkedList<DBObject>();
//			for(long i=seq;i<seq+1000000;i++){
//		        BasicDBObject entity = new BasicDBObject();
//		        entity.put("userName", "bbs"+String.valueOf(i));
//		        entity.put("email", "bbs"+String.valueOf(i)+"@bbs.org");
//		        entity.put("passwd", "ddddddd");
//		        entity.put("sex", 0);
//		        entity.put("mobilePhone",null);
//		        entity.put("pone",null);
//		        entity.put("qq",null);
//		        entity.put("idNumber",null);
//		        entity.put("address",null);
//		        entity.put("created",new Date());
//		        entity.put("modified",new Date());
//				accounts.add(entity);
//				if(accounts.size()%50000==0){
//					coll.insert(accounts);
//					accounts.clear();
//				}
//			}
//			long end=System.currentTimeMillis();
//			System.out.println("performanceWithoutMapperBatchTest costs="+(end-begin));
//		}
//	}

}
