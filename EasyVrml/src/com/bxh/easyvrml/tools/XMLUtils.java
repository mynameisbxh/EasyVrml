package com.bxh.easyvrml.tools;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;
import java.util.Iterator;

import org.apache.commons.io.FileUtils;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
/**
 * XMLUtils 提供了一组用于XML文件的管理工具，负责完成各种基于XML的操作
 * 
 * @author BXH
 *
 */
public class XMLUtils {

	/**
	 * createDocument 负责创建一个默认XML 文档
	 * @return 一个默认的XML Document
	 */
	public static Document createDocument() {
		Document document = DocumentHelper.createDocument();
		document.addElement("VRML");	//添加根节点VRML
		return document;
	}
	
//	public static void deleteDocument(Document){
//		FileUtils.deleteQuietly(new File())
//	}
	
	public static void listXMLDocument(Document doc){
		Element vrml = doc.getRootElement();
		for ( Iterator<Element> i = vrml.elementIterator(); i.hasNext(); ) {
            Element element = (Element) i.next();
            System.out.println(element.getTextTrim());
        }
	}
	
	
	
	/**
	 * write 方法重载
	 * @param doc 用于持久化的Document对象
	 */
	public static void write(Document doc) {
		write(doc,true);		
	}
	
	/**
	 * write 方法重载
	 * @param doc	用于持久化的Document对象
	 * @param isformat	是否格式化
	 */
	public static void write(Document doc,boolean isformat){
		try {
			write(doc,new FileOutputStream("result.xml"),isformat);		//默认生成文档名为result.xml
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	 * @param doc 需要写入硬盘的XML 文档
	 * @param writer Writer对象
	 * @param isformat 是否进行格式化(默认是不进行格式化)
	 */
	public static void write(Document doc,OutputStream writer,boolean isformat) {
		XMLWriter xwriter = null;
		try {
			if(isformat){
				OutputFormat format = OutputFormat.createPrettyPrint();				//格式化输出流
				xwriter = new XMLWriter(writer,format);
			}else{
				xwriter = new XMLWriter(writer);
			}
			xwriter.write(doc);
		} catch (IOException e) {
			e.printStackTrace();
		} finally{
			try {
				writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	/**
	 * 判断给定的节点是否有子节点
	 * @param node
	 * @param parent
	 * @return
	 */
	public static boolean hasChildren(Element node,String parent){
		//System.out.println(parent + "/" + node.getName() +"/*" +(node.selectNodes(parent + "/" + node.getName() +"/*").size()!=0));
		return node.selectNodes(parent + "/" + node.getName() +"/*").size()>0;
	}
	
	/**
	 * 判断节点内容是否为空
	 * @param node
	 * @return
	 */
	public static boolean hasContent(Node node){
		return node.hasContent() && !(node.getText().equals("\"\""));
	}
	
	/**
	 * 获取一个节点的深度
	 * @param path	节点所在的路径
	 * @return	节点所处的深度
	 */
	public static int getDeepLevel(String path){
		int deep = 0;
		String []nodes = path.substring(1, path.length() - 2).split("/");
		for(int i = 0;nodes!=null&&i < nodes.length;i++){
			int location = nodes[i].indexOf("[");
			if(isNode(location>=0?nodes[i].substring(0, location):nodes[i])){
				deep ++;
			}
		}
		return deep;
	}
	
	/**
	 * 判断一个字符串是否是节点名
	 * @param nodeName
	 * @return
	 */
	public static boolean isNode(String nodeName){
		return nodeName.matches("([A-Z]{1}[a-z]+)+") || nodeName.equals("ROUTE") || nodeName.equals("USE") || nodeName.equals("LOD");
	}
	
	public static Document getDocument(File file) throws DocumentException{
		SAXReader reader = new SAXReader();
		Document doc = reader.read(file);
		return doc;
	}
}
