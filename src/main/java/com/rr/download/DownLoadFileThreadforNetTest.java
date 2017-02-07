package com.rr.download;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * 从网络中，多线程获取文件，有问题：某些文件打不开
 * @author Administrator
 *
 */
public class DownLoadFileThreadforNetTest {

	public static void main(String[] args) throws IOException {
//		String path = "http://2007.wsxz.cn/music/2011/03/01/09375000.mp3";
		String path = "http://dl.toofiles.com/vaaoje/audios/cac-eac.mp3";
//		String path = "http://www.win2.cn/driver/R3_4-in-Right_V1.201.zip";
//		String path = "http://192.168.16.189/s/test.rar";
		File file = new File(path);
		
		String saveFile = "z:/"+file.getName();
		download(path, saveFile);
//		download(file.toURL().toString(), saveFile);
		
//		Date date = new Date(33594);
//		System.out.println("小时:"+ date.getHours());
//		System.out.println("分钟："+date.getMinutes());
//		System.out.println("秒："+date.getSeconds());
	}
	
	public static final int THREADSIZE =3;
	
	public static void download(String urlPath,String saveFile) throws IOException{
		URL url = new URL(urlPath);
		HttpURLConnection httpCon = (HttpURLConnection) url.openConnection();
		httpCon.addRequestProperty("User_Agent", "NetFox");
//		httpCon.setRequestProperty("Range","bytes=101010");
		//我们先实现普通文件的下载
		int fileLength = httpCon.getContentLength();
		int sizeOne = fileLength/THREADSIZE+1;
		httpCon.disconnect();	//断开连接
		
		for(int i=0;i<THREADSIZE;i++){
			HttpURLConnection hcon = (HttpURLConnection) url.openConnection();
			//丢弃的字节
			hcon.addRequestProperty("User_Agent", "NetFox");
			hcon.setRequestProperty("RANGE", "bytes="+ sizeOne*i );
//			hcon.getInputStream().read();
			RandomAccessFile raf = new RandomAccessFile(saveFile, "rw");
//			raf.setLength(fileLength);
//			// 设置到此文件开头测量到的文件指针偏移量，在该位置发生下一个读取或写入操作。
			raf.seek(sizeOne*i);
			Thread t = new Thread(new DownloadThread(sizeOne, raf, hcon.getInputStream()));
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
			System.out.println("线程"+Thread.currentThread().getName()+"启动！");
			long startTime = System.currentTimeMillis();
			int offset = 0;
			int len = 0;
			byte [] buf = new byte[1024*8];
			try {
				while( len<readLength && (offset=netis.read(buf)) !=-1){
					raf.write(buf,0,offset);
					len += offset;
//					System.out.println("线程："+Thread.currentThread().getName()+"读取："+len);
					print(Thread.currentThread().getName(),readLength , len);
				}
				//
				System.out.println("线程："+Thread.currentThread().getName()+"下载完成！");
				System.out.println("线程："+Thread.currentThread().getName()+"下载所有时间："+(System.currentTimeMillis()-startTime));
				
				netis.close();
				raf.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	public static void print(String content,long length , long currentLength){
		System.out.println(content+" 下载进度："+ ((int)((float)currentLength/(float)length*100))+"%");
	}
}
