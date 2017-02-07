package com.rr.java8;

/**
 * 接下来看看构造函数是如何使用::关键字来引用的，首先我们定义一个包含多个构造函数的简单类：
 * @author Administrator
 *
 */
class Person{
	String firstName;
    String lastName;
    Person() {}
    Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
    @Override
    public String toString() {
    	return "My name is "+firstName+lastName;
    }
}
/**
 * 接下来我们指定一个用来创建Person对象的对象工厂接口：
 * @author Administrator
 * @param <P>
 */
interface PersonFactory<P extends Person>{
	P create(String firstName, String lastName);
}

public class LambdaFuncDemo2 {
	public static void main(String[] args) {
		PersonFactory<Person> pf = Person::new;
		Person p = pf.create("李", "晴信");
		System.out.println(p);
	}
}
