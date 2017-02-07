package com.rr.net;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

public class UDPClient {
	public static void main(String[] args) throws Exception{
		byte [] buf = null;
		buf = new String("hello").getBytes();
		//long value = 5544;
		//buf = Long.toString(value).getBytes();
		DatagramPacket dp = new DatagramPacket(buf, buf.length ,
				new InetSocketAddress("127.1.1.1",8888));
		DatagramSocket ds = new DatagramSocket(9999);
		ds.send(dp);
		ds.close();
		
	}
}
