package com.test.mongo;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.io.IOException;

import com.rr.db.mongo.AccountDAO;
import com.rr.db.mongo.MongoConnection;
import com.rr.db.mongo.model.Account;
import com.rr.db.mongo.model.JsonPojoMapper;
import org.junit.Before;
import org.junit.Test;

/**
 *  Result is runned on suse11 enterprise linux virual host,with kernel 2.6.32.12 x86_64,allocate mem=2G
 *	@author: hejing
 *	@date: 2012-11-5-下午03:35:37
 */
public class AccountDAOTest {
	AccountDAO dao=new AccountDAO();
	MongoConnection connection;
	private final String SERVERIP="10.74.165.169";
	//private final int PORT=30000;  //mongos端口
	private final int PORT=27017;
	private final String DBNAME="bbs";
	
	class AcctAttr{
		private int age;
		private int sex;
		private String addr;
		public int getAge() {
			return age;
		}
		public void setAge(int age) {
			this.age = age;
		}
		public int getSex() {
			return sex;
		}
		public void setSex(int sex) {
			this.sex = sex;
		}
		public String getAddr() {
			return addr;
		}
		public void setAddr(String addr) {
			this.addr = addr;
		}
		
	}
	@Before
	public void setUp(){
		connection=dao.getConnection();
		connection.connect();
	}
//	@Test
//	public void crudTest() throws Exception{
//		Account entity=new Account();
//		entity.setUsername("hejing");
//		entity.setPassword("ddddddd");
//		AcctAttr acctAttr=new AcctAttr();
//		acctAttr.setAddr("chengdu china");
//		acctAttr.setAge(36);
//		acctAttr.setSex(1);
//		entity.setAcctAttr(JsonPojoMapper.toJson(acctAttr, true));
//
//		Account r=dao.add(entity);
//		assertNotNull(r);
//
//		long begin;
//		long end;
//		entity.setPassword("aaaaaaaaa");
//		begin=System.currentTimeMillis();
//		for(int i=0;i<1000;i++){
//			dao.updateAccount(entity);
//		}
//		end=System.currentTimeMillis();
//		System.out.println("updateAccount costs="+(end-begin));
//
//		begin=System.currentTimeMillis();
//		for(int i=0;i<1000;i++){
//			r=dao.getAccountByName("hejing");
//		}
//		end=System.currentTimeMillis();
//		System.out.println("getAccountByName costs="+(end-begin));
//		assertNotNull(r);
//
//		begin=System.currentTimeMillis();
//		for(int i=0;i<1000;i++){
//			r=dao.getAccountByID(r.get_id());
//		}
//		end=System.currentTimeMillis();
//		System.out.println("getAccountByID costs="+(end-begin));
//		assertNotNull(r);
//
//		dao.deleteAccount(r.getUserName());
//		r=dao.getAccountByName("hejing");
//		assertNull(r);
//	}
//
//	@Test
//	public void dupAddTest(){
//		Account entity=new Account();
//		entity.setUserName("bbs");
//		entity.setPasswd("ddddddd");
//
//		Account r=dao.add(entity);
//		assertNotNull(r);
//
//		try{
//			r=dao.add(entity);
//		}catch(Exception e){
//			assertNotNull(e);
//		}
//		dao.deleteAccount("bbs");
//	}
	
}
