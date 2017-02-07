package com.rr.nio.nio05_socket;

import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Date;
import java.util.Set;

public class DateServer2 {
	public static void main(String[]args)throws Exception {

		int ports[] = {8000,8001,8002,8003,8004};	//表示五个监听端口
		
		Selector selector = Selector.open();	//通过open()方法找到Selector
		
		for(int i=0;i<ports.length;i++){
			ServerSocketChannel initSer = ServerSocketChannel.open();	//打开服务器的通道
			initSer.configureBlocking(false);
			ServerSocket initSock = initSer.socket();
			InetSocketAddress address = new InetSocketAddress(ports[i]);	//实例化绑定地址
			initSock.bind(address);	//进行服务的绑定
			initSer.register(selector, SelectionKey.OP_ACCEPT);	//等待连接
			System.out.println("服务器运行，在"+ports[i]+"端口监听");
			
			
		}
		//要接受全部生成的key，并通过连接进行判断是否获取客户端的输出
		int keysAdd;
		while( (keysAdd=selector.select()) >0 ){
			//
			Set<SelectionKey> set = selector.keys();
			for(SelectionKey key : set){
				if(key.isAcceptable()){
					ServerSocketChannel server = (ServerSocketChannel)key.channel();
					SocketChannel client = server.accept();	//接受新连接
					client.configureBlocking(false);	//配置为非阻塞
					ByteBuffer outBuf = ByteBuffer.allocateDirect(1024);
					outBuf.put( ("当前的时间为："+new Date()).getBytes());
					outBuf.flip();
					client.write(outBuf);
					client.close();
				}
			}
			set.clear();	//清楚全部的key
		}
	}
}
