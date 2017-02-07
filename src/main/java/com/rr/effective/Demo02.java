package com.rr.effective;

import java.io.ObjectStreamException;
import java.io.Serializable;

/**
 * 第2条	使用私有构造方法强化singleton属性
 * 
 * Singleton是指这样的类，它只能实例化一次，singleton通常被用来代表那些本质上具有唯一性的系统组件，比如视频显示或者文集系统。
 * @author Administrator
 *
 */
public class Demo02 {

}

/**
 * 实现singleton有两种方法：
 * 这两种方法都要把构造方法保持为私有的，
 * 并且提供一个静态成员，以便允许客户能够访问该类唯一的实例。
 * 
 * 在第一种方法中，共有静态成员是一个final域：
 * @author Administrator
 *
 */
class SingletonOne{
	public static final SingletonOne INSTANCE = new SingletonOne();
	
	private SingletonOne(){
		
	}
}
/**
 * 第二种方法提供了一个共有的静态工厂方法，
 * 而不是共有的静态final域：
 * @author Administrator
 *
 */
class SingletonTwo{
	private static final SingletonTwo instance = new SingletonTwo();
	
	private SingletonTwo(){
		
	}
	public static SingletonTwo getInstance(){
		return instance;
	}
}
/**
 * 为了使一个singleton类变成可序列化的（serializable），
 * 仅仅在声明中加上”implements Serializable”是不够的，
 * 为了维护singleton性，你必须也要提供一个readResolve方法，
 * 否则的话，一个序列化的实例在每次反序列化的时候，
 * 都会导致创建一个新的实例，
 * 比如说，在我们的例子中，会导致“假冒的SingetonThree”。
 * 为了防止这种情况，在SingletonTwo类中加入下面的readResolve方法：
 * @author Administrator
 *
 */
class SingletonThree implements Serializable{
	private static final SingletonThree instance = new SingletonThree();
	
	private SingletonThree(){
		
	}
	public static SingletonThree getInstance(){
		return instance;
	}
	//read Resove method to preserve singleton property
	private Object readResolve() throws ObjectStreamException{
		// Retrue the onw true SingletonThree and let the garbage collection
		// take care of the SingletonThree impersonator
		return instance;
	}
}