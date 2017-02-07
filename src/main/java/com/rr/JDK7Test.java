package com.rr;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

public class JDK7Test {

	public static void main(String[] args) {
		String str = "";
		//自动资源管理  
		try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
			str = br.readLine();
			System.out.println(str);
		}catch(Exception e){
//			e.printStackTrace();
		}
		
		//在switch中可使用string 
		switch(str){
			case "1":
				System.out.println("str is 1");
			default:
				System.out.println("str is not 1 ,and it is "+str);
		}
		//数值可加下划线
		int one_million= 1_000_000;
		
		//对 collections 的支持
		//List<String> list = ["item"];
//		Map<String,Integer> map = {"item":1};
	}
}
