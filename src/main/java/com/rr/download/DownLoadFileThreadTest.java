package com.rr.download;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;

/**
 * 多线程复制文件
 * @author Administrator
 *
 */
public class DownLoadFileThreadTest {

	public static void main(String[] args) throws IOException {
//		String path = "G:/image/漫画_神秘的程序员们.gif";
//		String path = "G:/flv/9.God is a girl-Groove Coverage.mp4";
//		String path = "E:/pdf/Java程序设计入门教程.pdf";
		String path = "E:/software/压缩类型软件/DiskGenius3.2_x86.rar";
		File file = new File(path);
		String saveFile = "z:/"+file.getName();
		download(path, saveFile);
	}
	
	public static final int THREADSIZE = 3;
	
	public static void download(String urlPath,String saveFile) throws IOException{
//		URL url = new URL(urlPath);
//		HttpURLConnection httpCon = (HttpURLConnection) url.openConnection();
//		httpCon.addRequestProperty("User_Agent", "NetFox");
//		httpCon.setRequestProperty("Range","bytes=101010");
		//我们先实现普通文件的下载
		File file = new File(urlPath);
		long sizeOne = file.length()/THREADSIZE+1;
		for(int i=0;i<THREADSIZE;i++){
			FileInputStream is = new FileInputStream(file);
			//丢弃的字节
			is.skip(sizeOne*i);
			RandomAccessFile raf = new RandomAccessFile(saveFile, "rw");
			// 设置到此文件开头测量到的文件指针偏移量，在该位置发生下一个读取或写入操作。
			raf.seek(sizeOne*i);
			Thread t = new Thread(new DownloadThread(sizeOne, raf, is));
			t.start();
		}
//		System.out.println(file.length());
	}
	
	public static class DownloadThread implements Runnable{
		private long readLength;
		private RandomAccessFile raf;
		private InputStream netis;
		
		public DownloadThread(long readLength , RandomAccessFile raf ,InputStream netis) {
			this.readLength = readLength;
			this.raf = raf;
			this.netis = netis;
		}
		@Override
		public void run() {
			int offset = 0;
			int len = 0;
			byte [] buf = new byte[1024*8];
			try {
				while((offset=netis.read(buf)) !=-1 && len<readLength){
					raf.write(buf,0,offset);
					len += offset;
				}
				//
				System.out.println("线程："+Thread.currentThread().getName()+"下载完成！");
				raf.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
