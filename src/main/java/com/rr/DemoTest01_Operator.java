package com.rr;

/**
 * 简单表达式
 * @author Administrator
 *
 */
public class DemoTest01_Operator {
	public static void main(String[] args) {
		int a=4;
		int b=7;
		
		System.out.println("a+=2的结果是："+ ( a+=2 ));
		System.out.println("b-=2的结果是："+ ( b-=2 ));
		
		System.out.println("a*=2的结果是："+ ( a*=2 ));
		System.out.println("b/=2的结果是："+ ( b/=2 ));
		
		System.out.println("a%=2的结果是："+ ( a%=2 ));
	}
}
