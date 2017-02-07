package com.rr.nio.nio01_bufferdemo;

import java.nio.Buffer;
import java.nio.IntBuffer;

/**
 * 创建只读的子缓冲区
 * @author Administrator
 *
 */
public class Demo03_ReadonlyBuffer {
	public static void main(String[] args) {
		//准备出10个大小的缓冲区
		IntBuffer buf = IntBuffer.allocate(10);
		
		for(int i=0;i<10;i++){
			buf.put(i*2+1);	//加入10个奇数
		}
		//需要通过slice创建子缓冲区
		//IntBuffer sub = buf.slice();
		
		//创建只读缓冲区
		IntBuffer sub = buf.asReadOnlyBuffer();
		//只读缓冲区不可以更改里面的内容，否则会出现java.nio.ReadOnlyBufferException异常。
	/*	for(int i=0;i<sub.capacity();i++){
			int temp = sub.get(i);
			sub.put(temp-1);
		}*/
		
		buf.flip();
		buf.limit(buf.capacity());
		while(buf.hasRemaining()){
			System.out.println(buf.get());
		}
		//由结果可以发现：
		//	子缓冲区可以修改主缓冲区的内容
	}
	
	/**
	 * 打印Buffer
	 * @param buf
	 */
	static void print(Buffer buf){
		System.out.println("position="+buf.position()+",limit="+buf.limit()+",capacity="+buf.capacity());
	}
}
