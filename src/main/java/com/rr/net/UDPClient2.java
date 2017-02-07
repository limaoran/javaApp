package com.rr.net;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

/**
 * 传输long类型的数据
 * @author Administrator
 *
 */
public class UDPClient2 {

	public static void main(String[] args) throws Exception{
		long n = 10000L;
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		DataOutputStream dos = new DataOutputStream(bos);
		dos.writeLong(n);
		
		byte [] buf = bos.toByteArray();
		
		//System.out.println(buf.length);
		
		DatagramPacket dp = new DatagramPacket(buf, buf.length,new InetSocketAddress("127.1.1.1",8888));
		DatagramSocket ds = new DatagramSocket(9999);
		ds.send(dp);
		ds.close();
		
	}

}
