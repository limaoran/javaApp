package com.rr;

/**
 * java也提供了 左移 << 和 右移 >>
 * @author Administrator
 *
 */
public class DemoTest11_Operator {
	public static void main(String[] args) {
		int x=3;	//0000 0011
		System.out.println("3左移两位的结果："+ (x<<2));	//0000 1100
		System.out.println("3右移两位的结果："+ (x>>2)); //0000 000011
		
		int y=-3;	//11111111 11111111 11111111 11111101
		//System.out.println("-3的二进制："+Integer.toBinaryString(y));
		System.out.println(y<<2);
		System.out.println(y>>2);
		
		System.out.println(y>>>2);	//无符号右移
	}
}
