package com.rr.concurrent;

import java.util.Iterator;
import java.util.concurrent.ConcurrentSkipListMap;

/**
 * 了解ConcurrentSkipListMap的使用
 * 
可缩放的并发 ConcurrentNavigableMap 实现。映射可以根据键的自然顺序进行排序，也可以根据创建映射时所提供的 Comparator 进行排序，具体取决于使用的构造方法。 
此类实现 SkipLists 的并发变体，为 containsKey、get、put、remove 操作及其变体提供预期平均 log(n) 时间开销。多个线程可以安全地并发执行插入、移除、更新和访问操作。迭代器是弱一致 的，返回的元素将反映迭代器创建时或创建后某一时刻的映射状态。它们不 抛出 ConcurrentModificationException，可以并发处理其他操作。升序键排序视图及其迭代器比降序键排序视图及其迭代器更快。 
此类及此类视图中的方法返回的所有 Map.Entry 对，表示他们产生时的映射关系快照。它们不 支持 Entry.setValue 方法。（注意，根据所需效果，可以使用 put、putIfAbsent 或 replace 更改关联映射中的映射关系。） 
请注意，与在大多数 collection 中不同，这里的 size 方法不是 一个固定时间 (constant-time) 操作。因为这些映射的异步特性，确定元素的当前数目需要遍历元素。此外，批量操作 putAll、equals 和 clear 并不 保证能以原子方式 (atomically) 执行。例如，与 putAll 操作一起并发操作的迭代器只能查看某些附加元素。 
此类及其视图和迭代器实现 Map 和 Iterator 接口的所有可选 方法。与大多数其他并发 collection 一样，此类不 允许使用 null 键或值，因为无法可靠地区分 null 返回值与不存在的元素值。 
 * @author Administrator
 *
 */
public class ConcurrentSkipListMapTest {
	public static void main(String[] args) {
		//线程安全的
		ConcurrentSkipListMap map = null ;
		map = new ConcurrentSkipListMap();
		//插入的value不能为空
		map.put("a", 2);
		map.put("c", 3);
		map.put("b", 1);
		
		Iterator iter = map.entrySet().iterator();
		while(iter.hasNext()){
			System.out.println(iter.next());
		}
		
	}

}
