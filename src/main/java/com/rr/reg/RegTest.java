package com.rr.reg;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 测试正则表达式
 * @author Administrator
 *
 */
public class RegTest {

	public static void main(String[] args) {
		
		
		/*//
		Pattern p = Pattern.compile(".{3}(?=a)");
		String s = "344a66b";
		Matcher m = p.matcher(s);
		while(m.find()){
			System.out.println(m.group());
		}
		*/
		
		//back references
		Pattern p = Pattern.compile("(\\d\\d)\\1");
		String s = "1212";
		Matcher m = p.matcher(s);
		System.out.println(m.matches());
		
		//flags的简写
		System.out.println("Java".matches("(?i)(java)"));
	}

}
