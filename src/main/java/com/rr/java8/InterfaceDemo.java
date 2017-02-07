package com.rr.java8;

/**
 * 接口默认方法
 * @author Administrator
 */
interface Animal{
	void eat();
	default void drink(){
		System.out.println("I'm drink water!");
	}
	void act();
}
class Cat implements Animal{
	@Override
	public void eat() {
		System.out.println("My name is Red Cat. I'm eatting!");
	}

	@Override
	public void act() {
		System.out.println("喵!喵!");
	}
}
class Dog implements Animal{

	@Override
	public void eat() {
		System.out.println("My name is Blake Dog. I'm eatting!");
	}

	@Override
	public void act() {
		System.out.println("汪！汪！汪！");
	}
	
}


public class InterfaceDemo {
	public static void main(String[] args) {
		
	}
}
