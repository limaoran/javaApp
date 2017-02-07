package com.rr.net;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * 客户端
 * @author Administrator
 *
 */
public class TCPClient {
	public static void main(String[] args) {
		String host = "127.1.1.1";
		Socket socket = null;
		try {
			socket = new Socket(host , 9999);
			
			OutputStream os = socket.getOutputStream();
			DataOutputStream dos = new DataOutputStream(os);
			dos.writeUTF("hello server!");
			dos.flush();
			dos.close();
			socket.close();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
