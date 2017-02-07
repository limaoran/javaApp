package com.rr;

/**
 * 递增与递减运算符
 * ++	自增
 * --	自减
 * @author Administrator
 *
 */
public class DemoTest06_Operator {
	public static void main(String[] args) {
		
		int a=3,b=3;	//定义两个变量a和b
		int x=6,y=6;	//定义两个变量x和y
		
		System.out.println("a="+a);
		System.out.println("\ta++="+ a++ + ", a="+a);	//先计算后自增
		System.out.println("b="+b);	
		System.out.println("\t++b="+ ++b + ", b="+b);	//先自增后计算
		
		System.out.println("x="+x);
		System.out.println("\tx--="+ x-- + ", x="+x);	//先计算后自减
		System.out.println("y="+y);
		System.out.println("\t--y="+ --y + ", y="+y);	//先自减后计算
		
	}
}
