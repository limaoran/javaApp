package com.rr.effective;

/**
 * 第3条	通过私有的构造方法强化不可实例化的能力
 * 
 * 如果：企图通过将一个类做成抽象类来强制该类不可被实例化，这是行不通的。
 * 
 * 因此：我们只要让这个类包含单个显示的私有构造方法，则它就不可被实例化了
 * @author Administrator
 *
 */
public class Demo03 {
	
}


class UtilityClass{
	//Suppress default constructor for noninstantiability
	private UtilityClass(){
		//Thie constructor will never be invoked
	}
}