package com.rr.concurrent.interfacetest;

import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
	
/**
 * 
 * @author Administrator
 *
 */
public class CallableTest {
	public static void main(String[] args) {
		//调度线程
		Callable call = Executors.callable(run);
		System.out.println("=================");
		try {
			//执行线程
			call.call();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("=================");
		
	}
	
	private static Runnable run = new Runnable(){
		@Override
		public void run() {
			System.out.println("run方法运行！");
		}};
}
