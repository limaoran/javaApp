package com.rr.nio.nio03_filelock;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

/**
 * 文件锁
 */
public class Demo01_FileLock {
	public static void main(String[] args) throws IOException, InterruptedException {
		File file = new File("d:/test.txt");
		FileOutputStream fos = new FileOutputStream(file,true);
		FileChannel fc = fos.getChannel();
		//锁定文件
		//进行独占锁的操作
		FileLock lock = fc.lock();
		if(lock!=null){
			System.out.println("文件锁定10秒");
			Thread.sleep(1000 * 10);
			//释放
			lock.release();
			System.out.println("文件接触锁定！");
		}
		
		fc.close();
		fos.close();
	}
}
