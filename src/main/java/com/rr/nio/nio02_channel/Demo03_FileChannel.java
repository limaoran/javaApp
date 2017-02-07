package com.rr.nio.nio02_channel;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileChannel.MapMode;

/**
 * 内存映射
 *		内存映射在读取的时候是最快的。 	
 * @author Administrator
 *
 */
public class Demo03_FileChannel {
	public static void main(String[] args) throws IOException {
		File file = new File("d:/test.txt");
		FileInputStream fis = new FileInputStream(file);
		FileChannel fc = fis.getChannel();
		
		MappedByteBuffer mbuf = fc.map(MapMode.READ_ONLY, 0,file.length() );
		
		//开辟空间，接受内容
		byte [] data = new byte[(int) file.length()];
		int foot = 0;
		
		while(mbuf.hasRemaining()){
			//mbuf.get(data);
			data[foot++] = mbuf.get();
		}
		System.out.println(new String(data,"GB2312"));
		
		fc.close();
		fis.close();
	}
}
