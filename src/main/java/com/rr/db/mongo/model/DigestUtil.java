package com.rr.db.mongo.model;

import com.sun.xml.internal.org.jvnet.staxex.Base64EncoderStream;
import org.apache.commons.codec.digest.DigestUtils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by Limaoran on 2016/9/27.
 */
public class DigestUtil {
    public final static String MD5 = "MD5";
    public final static String NONE = "NONE";
    public final static String SHA_1 = "SHA_1";
    public final static String SHA_256 = "SHA_256";
    public final static String SHA_512 = "SHA_512";
    public final static String SHA_384 = "SHA_384";
    public final static String NULL = null;

    /**
     * 文件加密
     * @param filename
     * @param algorithm
     */
    public static void digestFile(String filename,String algorithm){
        byte [] b = new byte[1024*4];
        int len = 0;
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try{
            MessageDigest md = MessageDigest.getInstance(algorithm);
            fis = new FileInputStream(filename);
            while( (len=fis.read(b))!=-1){
                md.update(b,0,len);
            }
            byte [] digest = md.digest();
            StringBuilder filenameBuffer = new StringBuilder(128).append(filename).append(algorithm);
            OutputStream encodeStream = new Base64EncoderStream(fos);
            encodeStream.write(digest);
            encodeStream.flush();
            encodeStream.close();
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            try {
                if (fis != null) {
                    fis.close();
                }
                if(fos!=null){
                    fos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 密码加密算法
     * @param password
     * @param alg
     * @return
     */
    public static String digestString(String password,String alg){
        if(alg==null)  alg = MD5;
        String newPass = "";
        switch(alg){
            case MD5 :newPass = DigestUtils.md5Hex(password);break;
            case SHA_1:newPass = DigestUtils.sha1Hex(password);break;
            case SHA_256:newPass = DigestUtils.sha256Hex(password);break;
            case SHA_384:newPass = DigestUtils.sha384Hex(password);break;
            case SHA_512:newPass = DigestUtils.sha512Hex(password);break;
            default:newPass = DigestUtils.shaHex(password);break;
        }
        return newPass;
    }

    /**
     * 加密密码算法，默认的加密算法是SHA-256
     * @param password 未加密的密码
     * @return 加密后的密码,64位字符串
     */
    public static String digestPassword(String password){
        try{
            if(password!=null && !"".equals(password)){
                return digestString(password,SHA_256);
            }else{
                return null;
            }
        }catch (Exception e){
            throw new RuntimeException("Security error: " + e);
        }
    }

    /**
     * 判断密码是不是相等，默认的加密算法是SHA-256
     * @param beforePwd 要判断的密码
     * @param afterPwd  加密后的数据库密码
     * @return  true 密码相等
     */
    public static boolean isPasswordEnable(String beforePwd,String afterPwd){
        if(beforePwd!=null && beforePwd.length()>0){
            String password = digestPassword(beforePwd);
            return password.equals(afterPwd);
        }
        return false;
    }

    public static void main(String[] args) {
        long begin=System.currentTimeMillis();
        for(int i=0;i<100000;i++)
            DigestUtil.digestPassword("rqrtqwtwqtrwqytqwfdafdsgheuherwyrewuerygtew");
        long end=System.currentTimeMillis();
        System.out.println("cost="+(end-begin));
        System.out.println(DigestUtil.digestPassword("rqrtqwtwqtrwqytqwfdafdsgheuherwyrewuerygtew"));
        System.out.println(DigestUtil.isPasswordEnable("123456", DigestUtil.digestPassword("123456")));
    }
}