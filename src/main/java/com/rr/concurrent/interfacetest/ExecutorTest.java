package com.rr.concurrent.interfacetest;

import java.util.concurrent.Executor;

/**
 * 
 * 执行已提交的 Runnable 任务的对象。此接口提供一种将任务提交与每个任务将如何运行的机制（包括线程使用的细节、调度等）分离开来的方法。通常使用 Executor 而不是显式地创建线程。例如，可能会使用以下方法，而不是为一组任务中的每个任务调用 new Thread(new(RunnableTask())).start()： 
 * @author Administrator
 *
 */
public class ExecutorTest {

	public static void main(String[] args) {
		Executor executor = new Executor(){
			@Override
			public void execute(Runnable command) {
				//启动新的线程
				new Thread(command).start();
				//command.run();
			}};
		executor.execute(runable);
		executor.execute(runable);
		System.out.println("end main!");
	}
	static Runnable runable = new Runnable(){
		@Override
		public void run() {
			System.out.println("start run!");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("end run!");
		}};
}
