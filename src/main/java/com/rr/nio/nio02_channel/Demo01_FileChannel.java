package com.rr.nio.nio02_channel;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 通道
 * 	写
 * @author Administrator
 *
 */
public class Demo01_FileChannel {
	public static void main(String[] args) throws IOException {
		String info [] = {"Hello","你好","红了！"};
		
		FileOutputStream fos = new FileOutputStream("d:/test.txt");
		//声明FileChannel对象，并得到输出的通道
		FileChannel fc = fos.getChannel();
		
		ByteBuffer buf = ByteBuffer.allocate(1024);
		for(String str : info){
			//将字符串变为字节数组放进缓冲区之中。
			buf.put(str.getBytes());
		}
		buf.flip();
		//输出缓冲区的内容
		fc.write(buf);
		fc.close();
	}
}
