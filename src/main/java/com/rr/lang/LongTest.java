package com.rr.lang;

import org.apache.hadoop.hbase.util.Bytes;

import java.security.MessageDigest;

/**
 * 测试string和long同样数值的字节占比
 *
 *  long 类型有 8 字节. 8字节内可以保存无符号数字到18,446,744,073,709,551,615. 如果用字符串保存--假设一个字节一个字符--，需要将近3倍的字节数。
 * Created by Limaoran on 2016/9/29.
 */
public class LongTest {
    public static void main(String[] args) throws Exception{
        long l = 1234567890L;
//        long l = 1234567890987654321L;
        byte [] lb = Bytes.toBytes(l);
        System.out.println("long bytes length : "+lb.length);   // return 8

        String s = ""+l;
        byte[] sb = Bytes.toBytes(s);
        System.out.println("long as string length : "+sb.length);   // return 10    19

        // hash
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte [] digest = md.digest(Bytes.toBytes(s));
        System.out.println("md5 digest bytes length : " + digest.length);   // return 16

        String digestStr = new String(digest);
        byte[] sbDigest = Bytes.toBytes(digestStr);
        System.out.println("md5 digest as string length : "+sbDigest.length);   //return 34
    }
}
