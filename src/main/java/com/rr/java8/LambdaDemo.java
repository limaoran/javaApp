package com.rr.java8;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * lambdaDemo
 * @author Administrator
 *
 */
public class LambdaDemo {
	public static void main(String[] args) {
		List<String> names = Arrays.asList("peter","tom","mike","anna");
		/*
		//老版本中排序
		Collections.sort(names, new Comparator<String>() {
			@Override
			public int compare(String a, String b) {
				//[tom, peter, mike, anna]
				return b.compareTo(a);
			}
		});
		//[anna, mike, peter, tom]
//		Collections.sort(names);	
		//新版本中排序
		Collections.sort(names,(String a,String b)->{
			return b.compareTo(a);
		});
		Collections.sort(names,(a,b)->{ return b.compareTo(a); });
		*/
		//对于函数体只有一行代码的，你可以去掉大括号{}以及return关键字
		Collections.sort(names,(a,b)->b.compareTo(a));
		//更简化的写法：
		names.sort((a,b)->b.compareTo(a));
		//Java编译器可以自动推导出参数类型，所以你可以不用再写一次类型。
		
		System.out.println(names);
	}
}
