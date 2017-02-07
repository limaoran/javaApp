package com.rr.concurrent.interfacetest;

import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutorCompletionService;

/**
 * CompletionService
 * 
将生产新的异步任务与使用已完成任务的结果分离开来的服务。生产者 submit 执行的任务。使用者 take 已完成的任务，并按照完成这些任务的顺序处理它们的结果。例如，CompletionService 可以用来管理异步 IO ，执行读操作的任务作为程序或系统的一部分提交，然后，当完成读操作时，会在程序的不同部分执行其他操作，执行操作的顺序可能与所请求的顺序不同。 
通常，CompletionService 依赖于一个单独的 Executor 来实际执行任务，在这种情况下，CompletionService 只管理一个内部完成队列。ExecutorCompletionService 类提供了此方法的一个实现。 
内存一致性效果：线程中向 CompletionService 提交任务之前的操作 happen-before 该任务执行的操作，后者依次 happen-before 紧跟在从对应 take() 成功返回的操作。
 * @author Administrator
 *
 */
public class CompletionServiceTest {

	public static void main(String[] args) {
		//TODO
	}

}
