package com.rr.nio.nio04_charset;

import java.nio.charset.Charset;
import java.util.SortedMap;

/**
 * 获取java支持的编码
 * @author Administrator
 *
 */
public class Demo01_Charset {
	public static void main(String[] args) {
		SortedMap<String,Charset> map = Charset.availableCharsets();
		for(String charset : map.keySet()){
			System.out.println(charset+"\t"+map.get(charset));
		}
	}
}
