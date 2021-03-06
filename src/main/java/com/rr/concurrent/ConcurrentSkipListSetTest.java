package com.rr.concurrent;

import java.util.Iterator;
import java.util.concurrent.ConcurrentSkipListSet;

/**
 * ConcurrentSkipListSet的使用
 * 
 一个基于 ConcurrentSkipListMap 的可缩放并发 NavigableSet 实现。set 的元素可以根据它们的自然顺序进行排序，也可以根据创建 set 时所提供的 Comparator 进行排序，具体取决于使用的构造方法。 
此实现为 contains、add、remove 操作及其变体提供预期平均 log(n) 时间开销。多个线程可以安全地并发执行插入、移除和访问操作。迭代器是弱一致 的，返回的元素将反映迭代器创建时或创建后某一时刻的 set 状态。它们不 抛出 ConcurrentModificationException，可以并发处理其他操作。升序排序视图及其迭代器比降序排序视图及其迭代器更快。 
请注意，与在大多数 collection 中不同，这里的 size 方法不是 一个固定时间 (constant-time) 操作。由于这些 set 的异步特性，确定元素的当前数目需要遍历元素。此外，批量操作 addAll、removeAll、retainAll 和 containsAll 并不 保证能以原子方式 (atomically) 执行。例如，与 addAll 操作一起并发操作的迭代器只能查看某些附加元素。 
此类及其迭代器实现 Set 和 Iterator 接口的所有可选 方法。与大多数其他并发 collection 实现一样，此类不允许使用 null 元素，因为无法可靠地将 null 参数及返回值与不存在的元素区分开来。
 * @author Administrator
 *
 */
public class ConcurrentSkipListSetTest {
	public static void main(String[] args) {
		//有排序功能
		ConcurrentSkipListSet set = null;
		set = new ConcurrentSkipListSet();
		
		set.add("a");
		set.add("c");
		set.add("b");
		set.add("c");
		
		Iterator iter = set.iterator();
		while(iter.hasNext()){
			System.out.println(iter.next());
		}
		
		
		System.out.println("set的长度："+ set.size());
	}
}
