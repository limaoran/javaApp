package com.rr.net.filelistdemo;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.regex.Pattern;

/**
 * 文件列表服务器
 * @author Administrator
 *
 */
public class Server {
	public static void main(String[] args) {
		new Server().startServer();
	}
	/**
	 * 启动服务器
	 */
	public void startServer(){
		ServerSocket server = null;
		Socket client = null;
		DataOutputStream dos = null;
		DataInputStream dis = null;
		try {
			//绑定端口
			server = new ServerSocket(9000);
			//有客户端连接到服务器
			client = server.accept();
			//客户端默认文件路径为：g:\
			dos = new DataOutputStream(client.getOutputStream());
			dis = new DataInputStream(client.getInputStream());
			//记录当前路径
			StringBuilder currentPath = new StringBuilder("g:");
			dos.writeUTF(currentPath.toString());
			
			//准备接受客户端的请求
			File file = new File(currentPath.toString()+"/");
			String str = "";
			while(true){
				str = dis.readUTF();
				if(str.startsWith("cd ") && !str.startsWith("cd ..")){
					str = str.substring(3).trim();
					//判断文件是否存在，是否为文件夹
					boolean getFile = false;
					for(File f : file.listFiles()){
						if(f.getName().equals(str)){
							if(f.isDirectory()){
								//修改当前路径
								currentPath.append("/"+f.getName());
								dos.writeUTF("当前路径："+currentPath.toString());
							}else{
								dos.writeUTF("您要访问的不是一个文件夹！");
							}
							getFile = true;
							break;
						}
					}
					if(!getFile){
						//如果文件没有找到
						dos.writeUTF("您要进入的文件夹不存在！");
					}
				}else if(str.startsWith("cd..") || str.startsWith("cd ..") ){
					//放回上一级文件夹
				//TODO	if(currentPath.)
					currentPath.delete(currentPath.lastIndexOf("/"), currentPath.length()-1);
					dos.writeUTF("当前路径："+currentPath.toString());
				}
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
