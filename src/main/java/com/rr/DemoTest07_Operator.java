package com.rr;

/**
 * 逻辑运算符
 * &	and，与
 * &&	短路与
 * |	or，或
 * ||	短路或
 * 
 * 关于&&与&、||与|的说明
 * 	&&与&
 * 		&&表示短路与
 * 		对于“与”来说，要求所有的条件都判断，而如果使用“短路与”如果第一个条件为false，则后面的条件不再判断
 * 	||与|
 * 		||表示短路或
 * 		对于“或”来说，要求所有的条件都判断，而如果使用“短路或”如果第一个条件为true，则后面的条件将不再判断
 * 
 * @author Administrator
 *
 */
public class DemoTest07_Operator {
	public static void main(String[] args) {
		
		int a=2;
		int b=4;
		
		int x=2;
		int y=4;
		
		System.out.println("a="+a+"\tb="+b+"\tx="+x+"\ty="+y);
		//测试a和b
		if(a++ > 3 && b++ > 5){
			System.out.println("true\ta++大于3了！ \t b++大于5了");
		}else{
			System.out.println("false\ta++小于3！ \t  b++小于5");
		}
		System.out.println("\ta="+a);
		System.out.println("\tb="+b);
		
		//测试x和y
		if(x++ > 3 & y++ > 5){
			System.out.println("true\tx++大于3了！ \t y++大于5了");
		}else{
			System.out.println("false\tx++小于3！ \t  y++小于5");
		}
		System.out.println("\tx="+x);
		System.out.println("\ty="+y);
		
		//结论
		String str = "由以上结果可以看出&和&&的区别不只是&为地址符，&&为逻辑运算符\n"+
			"&&在判断第一个表达式为true的时候，才会判断第二个表达式，否则不会判断第二个表达式\n"+
			"&在判断第一个表达式的时候，无论是true/false，都会去判断第二个表达式";
		System.out.println(str);
		
		
		System.out.println("==========================================");
		
		int c=3;
		int d=4;
		
		int e=3;
		int f=4;
		System.out.println("c="+c+"\td="+d+"\te="+e+"\tf="+f);
		//测试c和d
		if(c++ > 2 || d++ > 5){
			System.out.println("true\tc++大于2了！ \t d++大于5了");
		}else{
			System.out.println("false\tc++小于2！ \t  d++小于5");
		}
		System.out.println("\tc="+c);
		System.out.println("\td="+d);
		
		//测试e和f
		if(e++ > 2 | f++ > 5){
			System.out.println("true\te++大于2了！ \t f++大于5了");
		}else{
			System.out.println("false\te++小于2！ \t  f++小于5");
		}
		System.out.println("\te="+e);
		System.out.println("\tf="+f);
		
		//结论
		String str2 = "对于“或”来说，要求所有的条件都判断，而如果使用“短路或”如果第一个条件为true，则后面的条件将不再判断";
		System.out.println(str2);
	}
}
