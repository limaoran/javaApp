package com.rr.nio.nio02_channel;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 通道
 * 	读写
 * @author Administrator
 *
 */
public class Demo02_FileChannel {
	public static void main(String[] args) throws IOException {
		FileInputStream fis = new FileInputStream("d:/test.txt");
		FileOutputStream fos = new FileOutputStream("d:/test2.txt");
		
		//声明FileChannel对象，并得到输出的通道
		FileChannel fcOut = fos.getChannel();
		FileChannel fcIn = fis.getChannel();
		
		//创建普通的缓冲区
		ByteBuffer buf = null;
		//buf = ByteBuffer.allocate(1024);
		//创建直接缓冲区
		buf = ByteBuffer.allocateDirect(1024);
		
		int temp = 0;
		while( (temp=fcIn.read(buf))!=-1){
			buf.flip();
			fcOut.write(buf);
			//清空缓冲区，所有的状态变量的位置恢复到原点
			buf.clear();
		}
		/*//读取
		fcIn.read(buf);
		//写，输出缓冲区的内容
		fcOut.write(buf);
		buf.flip();*/
		
		fcIn.close();
		fcOut.close();
		
	}
}
