package com.rr.nio.nio01_bufferdemo;

import java.nio.ByteBuffer;

/**
 * 创建直接缓冲区
 * 	直接操作IO
 * @author Administrator
 *
 */
public class Demo04_ByteBuffer {
	public static void main(String[] args) {
		
		//创建直接缓冲区
		ByteBuffer buf = ByteBuffer.allocateDirect(1024);
		
		byte [] temp = {1,3,5,7,9};
		//设置一组数据
		buf.put(temp);
		
		buf.flip();
		System.out.println("主缓冲区的内容：");
		while(buf.hasRemaining()){
			
//			int i = buf.get();
//			System.out.println(i);
			System.out.print(buf.get()+",");
		}
		//这种方式只能提高一些尽可能的性能。
	}
}
