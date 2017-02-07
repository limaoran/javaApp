package com.rr.net.filelistdemo;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 * 获取文件的客户端 
 * @author Administrator
 *
 */
public class Client {
	public static void main(String[] args) {
		new Client().startClient();
	}

	public void startClient() {
		Socket client = null;
		DataInputStream dis = null;
		DataOutputStream dos = null;
		try {
			//连接到服务器
			client = new Socket("127.1.1.1",9000);
			dis = new DataInputStream(client.getInputStream());
			dos = new DataOutputStream(client.getOutputStream());
			//先接收路径数据
			System.out.println("当前路径："+dis.readUTF());
			Scanner scanner = new Scanner(System.in);
			String str="";
			while(true){
				str = scanner.nextLine();
				if("exit".equals(str)){
					break;
				}
				//向服务器发送数据
				dos.writeUTF(str);
				//接收服务器的回应
				System.out.println(dis.readUTF());
			}
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally{
			try{
				if(client!=null){
					client.close();
				}
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		
	}
}
