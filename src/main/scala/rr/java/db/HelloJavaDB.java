package rr.java.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

/**
 * 简单方便的javaDB中的derby使用
 * Created by Limaoran on 2016/7/26.
 *  java6以后JDK自带JavaDB，当我们在简单项目和练习中需要使用数据库的时候，但是又不想去建oracle、MySQL、sqlserver等数据库，并且避免各种连接配置麻烦，可以使用Java自带的一个数据库derby简单方便使用。
 *  首先安装jdk，在默认安装的情况下，derby被安装到JAVA_HOME\db并且在这里面有derby要使用的jar包。
 *
 *  简单demo测试一下
 */
public class HelloJavaDB {
    public static void main(String[] args) {
        try {
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver").newInstance();
            System.out.println("Loaded the EmbeddedDriver");
            Properties props =new Properties();
            props.setProperty("user", "user");
            props.setProperty("password", "password");
            try(Connection con = DriverManager.getConnection("jdbc:derby:helloDB;create=true",props)){
                System.out.println("create derbyDB");
                con.setAutoCommit(false);
                Statement statement =con.createStatement();
//                statement.execute("drop table user_uer");
                System.out.println("create table user_uer");
                statement.execute("create table user_uer ( name varchar(20), score int)");
                statement.execute("insert into user_uer ( name,score) values ('小明',89)");
                statement.execute("insert into user_uer (name ,score) values ('小花',90)");
                ResultSet resultSet =statement.executeQuery("select name,score from user_uer");
                System.out.println("------------------------");
                while (resultSet.next()) {
                    System.out.println(resultSet.getString("name"));
                    System.out.println(resultSet.getInt("score"));
                }
                System.out.println("query user_uer data");
                con.commit();
                //在这个运行过程中可能会报错找不到包org.apache.derby.jdbc.EmbeddedDriver，所以要导入jar，
                // 选择JAVA_HOME\db\lib下的derby.jar，这样运行demo就ok了
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
