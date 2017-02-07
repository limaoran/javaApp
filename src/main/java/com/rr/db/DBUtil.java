package com.rr.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 * 连接池配置
 * @author Administrator
 *
 */
public class DBUtil {
	
	private DataSource ds = null;
	private InitialContext ctx = null;
	private PreparedStatement pst = null;
	private Statement st = null;
	private ResultSet rs = null;
	private Connection con = null;
	
	public DBUtil() throws NamingException{
		ctx = new InitialContext();
		ds = (DataSource)ctx.lookup("java:comp/env/DBSource");
	}
	
	public Connection getConnection() throws SQLException{
		this.con = ds.getConnection();
		return con;
	}
	
	public Statement getStatement() throws SQLException{
		this.st=con.createStatement();
		return st;
	}
	
	public PreparedStatement getPreparedStatement(String sql) throws SQLException{
		this.pst=con.prepareStatement(sql);
		return pst;
	}
	
	public ResultSet executeQuery(String sql) throws SQLException{
		rs = this.st.executeQuery(sql);
		return rs;
	}
	
	public ResultSet executeQuery(String sql , Object...param) throws SQLException{
		rs = this.pst.executeQuery(sql);
		for(int i=0;i<param.length;i++){
			this.pst.setObject(i+1, param[i]);
		}
		return rs;
	}
	
	public void closeConnection(){
		try{
			if(this.con!=null){
				this.con.close();
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	
	public void closePreparedStatement(){
		try{
			if(this.pst!=null){
				this.pst.close();
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	
	public void closeStatement(){
		try{
			if(this.st!=null){
				this.st.close();
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	
	public void closeResultSet(){
		try{
			if(this.rs!=null){
				this.rs.close();
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	
	public void close(){
		this.closeResultSet();
		this.closeStatement();
		this.closePreparedStatement();
		this.closeConnection();
	}
}
