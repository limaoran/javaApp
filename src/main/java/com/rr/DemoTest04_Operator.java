package com.rr;

/**
 * 一元运算符
 * +	正号
 * -	负号
 * !	取反
 * @author Administrator
 *
 */
public class DemoTest04_Operator {
	public static void main(String[] args) {
		
		boolean b = false;
		int x = 10;
		int y = 30;
		
		System.out.println("b = "+ b + " , !b = "+ !b);	//取反
		System.out.println("x = "+ x + " , +x = "+ +x);	//使用正号
		System.out.println("y = "+ y + " , -y = "+ -y);	//使用负号
	}
}
