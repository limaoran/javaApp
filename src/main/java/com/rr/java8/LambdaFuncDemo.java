package com.rr.java8;


@FunctionalInterface
interface Converter<F,T>{
	T convert(F from);
}
public class LambdaFuncDemo {

	public static void main(String[] args) {
		Converter<String,Integer> ct = (from)->Integer.valueOf(from);
		Integer intValue = ct.convert("123");
		System.out.println(intValue);

        /*
		//通过静态方法引用来表示
		Converter<String,Integer > ct = Integer::valueOf;
		int val = ct.convert("543");
		System.out.println(val);
		*/
        String str = "Java";
        Converter<String,Integer> ct2 = str::indexOf;
        System.out.println(ct2.convert("v"));
	}
}
