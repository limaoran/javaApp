package com.rr.effective;
 
import java.util.HashMap;
import java.util.Map;

/**
 * 第1条：考虑用静态工厂方法代替构造函数
 * 
 * 静态工厂方法的一个好处是，与构造函数不同，静态工厂方法具有名字。
 * 静态工厂方法的第二个好处是，与构造方法不同，它们每次被调用的时候，不要求非得创建一个新的对象。
 * 静态工厂方法第三个好处是，与构造函数不同，它们可以返回一个原返回类型的子类型的对象。
 * 
 * 静态工厂方法的主要缺点是，类如果不含共有的或者受保护的构造方法，就不能被子类化。
 * 静态工厂方法的第二个缺点是，它们与其他的静态方法没有任何区别。
 * @author Administrator
 *
 */
public class Demo01 {
	public static Boolean valueOf(boolean b){
		return b? Boolean.TRUE:Boolean.FALSE;
	}
	
	public static void main(String[] args) {
	}
}

//Provider Framework sketch
abstract class Foo{
	//Maps String key to corresponding Class object
	private static Map map = null;
	
	static{
		initMap();
	}
	//Initializes implementations map the first time it's called
	private static synchronized void initMap(){
		if(map==null){
			map = new HashMap();
			//load implementation class names and keys from 
			//Properties file , translate names into Class 
			//objects using Class.forName and store mappings
		}
	}
	public static Foo getInstance(String key){
		Class c = (Class) map.get(key);
		if(c == null){
			return new DefaultFoo();
		}
		try{
			return (Foo)c.newInstance();
		}catch(Exception e){
			return new DefaultFoo();
		}
	}
}
class DefaultFoo extends Foo{
	//TODO doSomething
}