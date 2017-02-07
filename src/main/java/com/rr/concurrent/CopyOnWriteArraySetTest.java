package com.rr.concurrent;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * CopyOnWriteArraySet的使用
对其所有操作使用内部 CopyOnWriteArrayList 的 Set。因此，它共享以下相同的基本属性： 

它最适合于具有以下特征的应用程序：set 大小通常保持很小，只读操作远多于可变操作，需要在遍历期间防止线程间的冲突。 
它是线程安全的。 
因为通常需要复制整个基础数组，所以可变操作（add、set 和 remove 等等）的开销很大。 
迭代器不支持可变 remove 操作。 
使用迭代器进行遍历的速度很快，并且不会与其他线程发生冲突。在构造迭代器时，迭代器依赖于不变的数组快照。 
示例用法。 以下代码使用一个写时复制（copy-on-write）的 set，以维护在状态更新时执行某项操作的一组 Handler 对象。 

 class Handler { void handle(); ... }

 class X {
    private final CopyOnWriteArraySet<Handler> handlers = new CopyOnWriteArraySet<Handler>();
    public void addHandler(Handler h) { handlers.add(h); }

    private long internalState;
    private synchronized void changeState() { internalState = ...; }

    public void update() {
       changeState();
       for (Handler handler : handlers)
           handler.handle();
    }
 }
 此类是 Java Collections Framework 的成员。
 * @author Administrator
 *
 */
public class CopyOnWriteArraySetTest {
	public static void main(String[] args) {
		CopyOnWriteArraySet set = new CopyOnWriteArraySet();
		set.add("c");
		set.add("a");
		
		Iterator iter = set.iterator();
		while(iter.hasNext()){
			System.out.println(iter.next());
		}
		
		System.out.println(set.size());
	}

}
