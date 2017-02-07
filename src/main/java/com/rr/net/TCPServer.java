package com.rr.net;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 同步式的网络编程
 * @author Administrator
 *
 */
public class TCPServer {
	public static void main(String[] args) {
		ServerSocket server = null;
		try {
			//实例化，并在指定端口监听
			server = new ServerSocket(9999);
			while(true){
				Socket s = server.accept();
				System.out.println("A client connect");
				DataInputStream dis = new DataInputStream(s.getInputStream());
				String str = dis.readUTF();
				System.out.println(str);
				dis.close();
				s.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
