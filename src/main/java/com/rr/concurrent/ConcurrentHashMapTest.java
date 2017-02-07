package com.rr.concurrent;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * ConcurrentHashMap的使用
 * 
支持获取的完全并发和更新的所期望可调整并发的哈希表。此类遵守与 Hashtable 相同的功能规范，并且包括对应于 Hashtable 的每个方法的方法版本。不过，尽管所有操作都是线程安全的，但获取操作不 必锁定，并且不 支持以某种防止所有访问的方式锁定整个表。此类可以通过程序完全与 Hashtable 进行互操作，这取决于其线程安全，而与其同步细节无关。 
获取操作（包括 get）通常不会受阻塞，因此，可能与更新操作交迭（包括 put 和 remove）。获取会影响最近完成的 更新操作的结果。对于一些聚合操作，比如 putAll 和 clear，并发获取可能只影响某些条目的插入和移除。类似地，在创建迭代器/枚举时或自此之后，Iterators 和 Enumerations 返回在某一时间点上影响哈希表状态的元素。它们不会 抛出 ConcurrentModificationException。不过，迭代器被设计成每次仅由一个线程使用。 
这允许通过可选的 concurrencyLevel 构造方法参数（默认值为 16）来引导更新操作之间的并发，该参数用作内部调整大小的一个提示。表是在内部进行分区的，试图允许指示无争用并发更新的数量。因为哈希表中的位置基本上是随意的，所以实际的并发将各不相同。理想情况下，应该选择一个尽可能多地容纳并发修改该表的线程的值。使用一个比所需要的值高很多的值可能会浪费空间和时间，而使用一个显然低很多的值可能导致线程争用。对数量级估计过高或估计过低通常都会带来非常显著的影响。当仅有一个线程将执行修改操作，而其他所有线程都只是执行读取操作时，才认为某个值是合适的。此外，重新调整此类或其他任何种类哈希表的大小都是一个相对较慢的操作，因此，在可能的时候，提供构造方法中期望表大小的估计值是一个好主意。

 * @author Administrator
 *
 */
public class ConcurrentHashMapTest {
	public static void main(String[] args) {
		
		ConcurrentHashMap map = null;
		map = new ConcurrentHashMap();
		/*	下面的那句话会报错误，因为在ConcurrentHashMap()中的put方法
			是public V put(K key, V value) {
		        if (value == null)
		            throw new NullPointerException();
		        int hash = hash(key.hashCode());
		        return segmentFor(hash).put(key, hash, value, false);
	    	}
		*/
		//map.put("b", null);
		
		map.put("b", 2);
		//map.put("a", "a");
		
		//如果a不存在，则添加a的键值对
		map.putIfAbsent("a","a");
		
		System.out.println(map.get("a"));
		
	}

}
