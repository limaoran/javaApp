package com.rr.nio.nio01_bufferdemo;

import java.nio.Buffer;
import java.nio.IntBuffer;

public class Demo01_IntBuffer {
	public static void main(String[] args) {
		//准备出10个大小的缓冲区
		IntBuffer buf = IntBuffer.allocate(10);
		print(buf);
		
		buf.put(3);
		
		print(buf);
		
		buf.put(new int[]{1,2,4});
		
		print(buf);
		
		
		//重设缓冲区
		//执行flip方法，limit设置为position，position设置为0
	//	buf.flip();
		
		buf.put(new int[]{4,6,22,55,11});
		
		print(buf);
		
		//重设缓冲区
		buf.flip();	//重设缓冲区的作用可以说是为了遍历缓冲的内容，并将position从设为0开始，limit设置position的位置
		//设置limit
	//	buf.limit(buf.capacity());
		//遍历缓冲区
		System.out.println("缓冲区的内容：");
		while(buf.hasRemaining()){
			int i = buf.get();
			System.out.println(i);
		}
	}
	
	/**
	 * 打印Buffer
	 * @param buf
	 */
	static void print(Buffer buf){
		System.out.println("position="+buf.position()+",limit="+buf.limit()+",capacity="+buf.capacity());
	}
}
