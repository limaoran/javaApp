package com.rr;

/**
 * 括号运算符
 * 
 * 括号可以改变优先级
 * @author Administrator
 *
 */
public class DemoTest08_Operator {
	public static void main(String[] args) {
		int a = 3,b=5;
		int x = 2,y=4;
		
		System.out.println( a + b * x);
		System.out.println( (a + b) * x);	//括号可以改变优先级
	}
}
