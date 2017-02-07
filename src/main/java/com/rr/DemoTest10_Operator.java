package com.rr;

/**
 * 取反
 * @author Administrator
 *
 */
public class DemoTest10_Operator {
	public static void main(String[] args) {
		int x = -3;//应该以补码的形式存在，补码=反码+1	-0011	-0001
		System.out.println(~x);
		
		//反码 是 数据 除了负号位置外，其他的全部取反
		/*
		 
		 1 00000000 00000000 00000000 00000011	--> -3原码
		 1 11111111 11111111 11111111 11111100	--> -3反码
		 1 11111111 11111111 11111111 11111101	-->	-3补码
		 0 00000000 00000000 00000000 00000010	-->	~-3
		 
		 */
	}
}
