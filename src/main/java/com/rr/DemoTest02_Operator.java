//
package com.rr;

/**
 * 单目运算符
 * 
 * 使用三目运算符时，操作数有3个，其格式如下：
 * 	变量 = 条件判断?表达式1:表达式2
 * @author Administrator
 *
 */
public class DemoTest02_Operator {
	public static void main(String[] args) {
		System.out.println("1>2对吗："+ ( 1>2?"1>2是对的！":"1>2是错误的！" ) );
		
		System.out.println("2和3的最大值："+sum(2,3));
	}
	
	/**
	 * 使用三目运算符 求两个数的最大值
	 * @param x 
	 * @param y
	 * @return
	 */
	public static int sum(int x,int y){
		return x>y?x:y;
	}
}
