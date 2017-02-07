package com.rr.concurrent.interfacetest;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
public interface ScheduledExecutorServiceextends ExecutorService一个 ExecutorService，可安排在给定的延迟后运行或定期执行的命令。 

schedule 方法使用各种延迟创建任务，并返回一个可用于取消或检查执行的任务对象。scheduleAtFixedRate 和 scheduleWithFixedDelay 方法创建并执行某些在取消前一直定期运行的任务。 

用 Executor.execute(java.lang.Runnable) 和 ExecutorService 的 submit 方法所提交的命令，通过所请求的 0 延迟进行安排。schedule 方法中允许出现 0 和负数延迟（但不是周期），并将这些视为一种立即执行的请求。 

所有的 schedule 方法都接受相对 延迟和周期作为参数，而不是绝对的时间或日期。将以 Date 所表示的绝对时间转换成要求的形式很容易。例如，要安排在某个以后的 Date 运行，可以使用：schedule(task, date.getTime() - System.currentTimeMillis(), TimeUnit.MILLISECONDS)。但是要注意，由于网络时间同步协议、时钟漂移或其他因素的存在，因此相对延迟的期满日期不必与启用任务的当前 Date 相符。 Executors 类为此包中所提供的 ScheduledExecutorService 实现提供了便捷的工厂方法。 

用法示例
以下是一个带方法的类，它设置了 ScheduledExecutorService ，在 1 小时内每 10 秒钟蜂鸣一次： 
 import static java.util.concurrent.TimeUnit.*;
 class BeeperControl {
    private final ScheduledExecutorService scheduler = 
       Executors.newScheduledThreadPool(1);

    public void beepForAnHour() {
        final Runnable beeper = new Runnable() {
                public void run() { System.out.println("beep"); }
            };
        final ScheduledFuture<?> beeperHandle = 
            scheduler.scheduleAtFixedRate(beeper, 10, 10, SECONDS);
        scheduler.schedule(new Runnable() {
                public void run() { beeperHandle.cancel(true); }
            }, 60 * 60, SECONDS);
    }
 }
 * @author Administrator
 *
 */
public class ScheduledExecutorServiceTest {

	public static void main(String[] args) {

		ScheduledExecutorService scheduled = new ScheduledThreadPoolExecutor (1);
		//立即执行
		//scheduled.execute(run);
		 
		//指定此任务在1秒后执行 
		//scheduled.schedule(run, 1, TimeUnit.SECONDS);
		
		//指定任务在1秒后执行，并以后每隔2秒执行一次，此类可以理解成定时器概念 (Timer)
		final ScheduledFuture future = scheduled.scheduleAtFixedRate(run, 1, 2, TimeUnit.SECONDS);
		
		//在10秒后执行此任务
		scheduled.schedule(new Runnable(){
			@Override
			public void run() {
				//取消future任务的执行
				future.cancel(true);
				
				System.out.println(future.isCancelled());
				//TODO 当取消任务后，程序并没有停止运行，目前还不知道是什么问题，有待解决，所以先采用此种方式解决
				System.exit(0);
			}}, 5, TimeUnit.SECONDS);
	}
	
	static Runnable run = new Runnable(){
		@Override
		public void run() {
			System.out.println("run");
		}};
}
