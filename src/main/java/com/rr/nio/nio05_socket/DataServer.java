package com.rr.nio.nio05_socket;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


/**
 * 非阻塞服务器端的编写
 * @author Administrator
 *
 */
public class DataServer {
	private ServerSocketChannel server;
	private ExecutorService service;

	private Charset charset = Charset.forName("GBK");
	
	public DataServer() throws IOException {
		server = ServerSocketChannel.open();
		server.socket().bind(new InetSocketAddress(80));
		
		service = Executors.newFixedThreadPool(4);
		
		this.service();
	}
	public void service(){
		while(true){
			try {
				SocketChannel client = server.accept();
				System.out.println("A client accept!");
				//设置非阻塞
				client.configureBlocking(false);
				service.execute(new Handler(client));
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
	}
	class Handler implements Runnable{
		private SocketChannel client;
		private Selector selector;
		public Handler(SocketChannel client) {
			this.client = client;
			try {
				selector = Selector.open();
				client.register(selector, 
						SelectionKey.OP_READ | SelectionKey.OP_WRITE ,
						ByteBuffer.allocate(1024));
			} catch (ClosedChannelException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		@Override
		public void run() {
			try {
				while(selector.select()>0){
					Set<SelectionKey> set = selector.selectedKeys();
					Iterator<SelectionKey> it = set.iterator();
					while(it.hasNext()){
						SelectionKey key = null;
						try{
							key = it.next();
							it.remove();
							if(key.isReadable()){
								//可以读
								ByteBuffer buf = (ByteBuffer) key.attachment();
								SocketChannel sc = (SocketChannel) key.channel();
								sc.read(buf);
								buf.flip();
								String msg = charset.decode(buf).toString();
								System.out.println("得到内容："+msg);
							}
							if(key.isWritable()){
								//可以写
								//java.util.Date
								String str = "当前日期："+ new java.util.Date().toString();
								ByteBuffer buf = charset.encode(str);
								SocketChannel sc = (SocketChannel) key.channel();
								sc.write(buf);
								//取消
//								key.cancel();
							}
						}catch(Exception e){
							e.printStackTrace();
							key.cancel();
							key.channel().close();
						}
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		new DataServer();
	}
}
