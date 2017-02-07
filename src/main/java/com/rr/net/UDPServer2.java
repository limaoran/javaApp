package com.rr.net;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPServer2 {
	public static void main(String[] args) throws Exception{
		byte buf [] = new byte[1024];
		
		DatagramPacket dp = new DatagramPacket(buf , buf.length);
		DatagramSocket ds = new DatagramSocket(8888);
		while(true){
			ds.receive(dp);
			ByteArrayInputStream bis = new ByteArrayInputStream(buf);
			DataInputStream dis = new DataInputStream(bis);
			System.out.println(dis.readLong());
			bis.close();
			dis.close();
		}
		
	}

}
