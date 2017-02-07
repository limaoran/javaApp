package com.rr.concurrent.interfacetest;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentSkipListMap;

/**
 * ConcurrentMap的使用

public interface ConcurrentMap<K,V>extends Map<K,V>提供其他原子 putIfAbsent、remove、replace 方法的 Map。 
内存一致性效果：当存在其他并发 collection 时，将对象放入 ConcurrentMap 之前的线程中的操作 happen-before 随后通过另一线程从 ConcurrentMap 中访问或移除该元素的操作。
 * @author Administrator
 *
 */
public class ConcurrentMapTest {
	public static void main(String[] args) {
		ConcurrentMap map = null;
		map = new ConcurrentHashMap();
		//map = new ConcurrentSkipListMap();
		
		map.put("a", "1");
		map.put("c", "2");
		map.put("b", "3");
		
		//如果key=c不存在，则添加此key
		map.putIfAbsent("c", "0");
		//如果有key=c，value=f的，则移除，如果不存在则返回false
		boolean b =map.remove("c","2");
		System.out.println("c删除了吗？"+b);
		
		for(Object obj : map.keySet()){
			System.out.println(obj + "  " +map.get(obj));
		}
		
	}

}
