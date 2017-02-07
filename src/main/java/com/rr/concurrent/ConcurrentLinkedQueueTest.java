package com.rr.concurrent;

import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * 了解ConcrurrentLinkedQueue的使用
 * 
	一个基于链接节点的无界线程安全队列。此队列按照 FIFO（先进先出）原则对元素进行排序。队列的头部 是队列中时间最长的元素。队列的尾部 是队列中时间最短的元素。新的元素插入到队列的尾部，队列获取操作从队列头部获得元素。当多个线程共享访问一个公共 collection 时，ConcurrentLinkedQueue 是一个恰当的选择。此队列不允许使用 null 元素。 
此实现采用了有效的“无等待 (wait-free)”算法，该算法基于 Maged M. Michael 和 Michael L. Scott 合著的 Simple, Fast, and Practical Non-Blocking and Blocking Concurrent Queue Algorithms 中描述的算法。 
需要小心的是，与大多数 collection 不同，size 方法不是 一个固定时间操作。由于这些队列的异步特性，确定当前元素的数量需要遍历这些元素。 
此类及其迭代器实现了 Collection 和 Iterator 接口的所有可选 方法。 
内存一致性效果：当存在其他并发 collection 时，将对象放入 ConcurrentLinkedQueue 之前的线程中的操作 happen-before 随后通过另一线程从 ConcurrentLinkedQueue 访问或移除该元素的操作。

 * @author Administrator
 *
 */
public class ConcurrentLinkedQueueTest {
	public static void main(String[] args) {
		
		ConcurrentLinkedQueue queue ;
		queue = new ConcurrentLinkedQueue();
		
		//这句话会报错误，因为queue先进先出队列里不能有null存在
		//queue.add(null);
		
		queue.add("a");
		queue.add(3);
		
		//获取并不移除队列的头，如果为null，则返回null
		Object obj = queue.peek();
		System.out.println(obj);
		
		//获取并移除队列的头，如果为null，则返回null
		Object obj2 = queue.poll();
		System.out.println(obj2);

		System.out.println(queue.size());
	}
}
