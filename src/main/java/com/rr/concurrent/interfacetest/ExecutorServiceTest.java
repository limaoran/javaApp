package com.rr.concurrent.interfacetest;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * ExecutorService接口的使用
 * @author Administrator
 *
 */
public class ExecutorServiceTest {
	public static void main(String[] args) {
		ExecutorService es = Executors.newSingleThreadExecutor();
		es.execute(new Runnable(){
			@Override
			public void run() {
				System.out.println("Hello Thread!");
			}});
		//判断调度的线程是否关闭了
		System.out.println(es.isShutdown());
		
		System.out.println("end main!");
	}

}
