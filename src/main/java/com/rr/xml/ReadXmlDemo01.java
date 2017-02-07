package com.rr.xml;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;




/**
 * 使用javaAPI来操作XML文件
 * @author Administrator
 *
 */
public class ReadXmlDemo01 {
	public static void main(String[] args) throws Exception {
		//创建解析工厂
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		//创建解析器
		DocumentBuilder db = factory.newDocumentBuilder();
		//创建xml文档
		Document doc = db.parse(ReadXmlDemo01.class.getResourceAsStream("/sys-config.xml"));
		//获取根节点
		Element root = doc.getDocumentElement();
		//System.out.println(root.getNodeName());
		
		/*NodeList list = root.getElementsByTagName("db-info");
		
		Node nodeInfo = list.item(0);
		
		Element dbInfo = (Element) nodeInfo;*/
		
		Element dbInfo = (Element) root.getElementsByTagName("db-info").item(0);
		
		System.out.println("driver\t="+XmlUtils.getValue(dbInfo, "driver-name"));
		System.out.println("url\t="+XmlUtils.getValue(dbInfo, "url"));
		System.out.println("username\t="+XmlUtils.getValue(dbInfo, "username"));
		System.out.println("password\t="+XmlUtils.getValue(dbInfo, "password"));
		
	}

	/**
	 * 遍历xml的所有子节点
	 */
	/*public static void queryXml(NodeList list){
		for(int i=0;i<list.getLength();i++){
			//获取此节点的子节点
			Node node = list.item(i);
			//输出此节点的名称，和内容
			System.out.println(node.getNodeName()+"  =  "+node.getTextContent());
			System.out.println(node.getChildNodes().getLength());
			if(node.hasChildNodes()){
				queryXml(node.getChildNodes());
			}
		}
	}*/
}
