package com.rr;

/**
 * 位运算符
 * 
 *  & 按位于
 *  | 按位或
 *  ^ 异或（相同为0，不同为1）
 *  ~ 取反
 *  << 左移位
 *  >> 右移位
 *  >>> 无符号右移位
 * @author Administrator
 *
 */
public class DemoTest09_Operator {
	public static void main(String[] args) {
		int x=3;	//3的二进制数据：0000 0011
		int y=6;	//6的二进制数据：0000 0110
		
		System.out.println("x & y = " + ( x&y ));//按位与	0000 0010
		System.out.println("x | y = " + ( x|y ));//按位或	0000 0111
		System.out.println("x ^ y = " + ( x^y ));//异或	0000 0101
	
		/*
		 * 位运算的结果表
		 * 		二进制数1	二进制数2	与操作（&）	或操作（|）	异或操作（^）
		 * 1		0		0		0		0		0	
		 * 2		0		1		0		1		1
		 * 3		1		0		0		1		1
		 * 4		1		1		1		1		0
		 * 
		 */
	}
}
