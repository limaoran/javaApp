package com.rr.xml;

import org.w3c.dom.Element;

public class XmlUtils {
	
	/**
	 * 传入一个node节点，可以在根据name返回此节点下的子节点的值
	 * @param node
	 * @param tagName
	 * @return
	 */
	public static String getValue(Element root , String tagName){
		return root.getElementsByTagName(tagName).item(0).getTextContent();
	}
	/**
	 * 传入一个node节点，可以在根据name返回此节点下的子节点的值
	 * 可以选择要返回的节点的第几个元素
	 * @param node
	 * @param tagName
	 * @return
	 */
	public static String getValue(Element root , String tagName,int index){
		return root.getElementsByTagName(tagName).item(index).getTextContent();
	}
	
}
