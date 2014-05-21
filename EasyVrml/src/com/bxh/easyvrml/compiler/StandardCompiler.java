package com.bxh.easyvrml.compiler;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.Element;

import com.bxh.easyvrml.document.VDocument;
import com.bxh.easyvrml.impl.Node;
import com.bxh.easyvrml.tools.Log;
import com.bxh.easyvrml.tools.VrmlUtils;
import com.bxh.easyvrml.tools.XMLUtils;
import com.bxh.easyvrml.impl.Compiler;
import com.bxh.easyvrml.node.basic.Version;
import com.bxh.easyvrml.node.extend.Define;
import com.bxh.easyvrml.node.extend.ROUTE;

/**
 * StandardCompiler 负责基本的代码翻译工作，实现Java Code向XML文件的转换
 * 
 * @author BXH
 */
public class StandardCompiler implements Compiler {

	public int element_index = 0;
	
	/**
	 * 解析VDocument文档并返回生成的相应Document对象用于产生XML文件
	 */
	@Override
	public Document compileDocument(VDocument doc) {
		if(doc == null){ return null; }
		
		Document xmlDoc = XMLUtils.createDocument();	//创建一个Document对象用于存放结果
		List<Node> nodes =  doc.getNodes();				//获取文档中的所有节点
		if(nodes == null){ return null; }
		
		Element root = xmlDoc.getRootElement();
		root.addElement("Version").addText(doc.getVersion().toString());
		//编译节点
		for(Node node : nodes){
			if(VrmlUtils.isFullyFields(node)){
				try {
					addChildElement(root,node);				//将node节点下的所有域添加到ele元素下
				} catch (Exception e) {
					e.printStackTrace();
				}	
			}
		}
		//编译事件路由
		List<ROUTE> routes = doc.getRoutes();
		for(ROUTE route:routes){
			root.addElement("ROUTE").addText(route.getRoute());
		}
		Log.showReport();
		return xmlDoc;
	}
	
	/**
	 *  获取类中的私有属性[private属性是需要编译的属性，protected属性是事件]
	 * @param fields	类的所有属性
	 * @return	类的私有属性
	 */
	public Field[]	getPrivateFields(Field[] fields){
		List<Field> fieldsList = new LinkedList<Field>();						//用于存储私有属性
		for(Field field:fields){
			if(field.getModifiers()==2){										//判断属性是否是私有属性[public:1,private:2,默认:3,protected:4]
				fieldsList.add(field);
			}
		}
		return (Field[])(fieldsList.toArray(new Field[fieldsList.size()]));
	}
	
	/**
	 * 递归调用方法，用于遍历节点的属性并生成XML Document
	 * @param ele
	 * @param node
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 */
	public void addChildElement(Element ele,Node node) throws IllegalArgumentException, IllegalAccessException{
		if(Define.isContainDefine(node)&&Define.selectStates(node)){
			ele = ele.addElement("USE").addText("USE "+Define.selectDefine(node));		//生成USE节点
		}else{
			Field fields[] = getPrivateFields(node.getClass().getDeclaredFields());		//获取节点的所有属性
			
			if(fields!=null){
				ele = ele.addElement(VrmlUtils.getNodeName(node.getClass()))
											  .addAttribute("name",getElementName(node))
											  .addAttribute("type", node.getClass().getName());	//向节点中添加type属性
				if(XMLUtils.isNode(ele.getName())){
					element_index++;
				}
				
				for(Field field : fields){
					if(VrmlUtils.isCanShow(node, field)){
						
						//需要判断属性的值是否有效
						field.setAccessible(true);										//设置节点属性可以被访问
						Element fele = ele;
						if(field.get(node)!=null){
							fele = ele.addElement(field.getName());					//添加属性节点
						}
						
						Log.logInfo("NodeName:" + VrmlUtils.getNodeName(node.getClass()) + "...............TypeName:"+field.getType().getSimpleName());
						
						String typeName = field.getType().getSimpleName();				//获取属性类型
					
						if("double".equals(typeName)){									//属性类型为double
							Double value = field.getDouble(node);
							if(value != null){
								fele.addAttribute("type", "double").addText(""+value);
							}
						}else if("double[]".equals(typeName)){							//属性类型为double数组
							double values[] = (double[])(field.get(node));
							if(values !=null&&values.length>0){
								String text = "";
								for(int i =0;i<values.length;i++){
									text = text + values[i] + " ";
								}
								fele.addAttribute("type", "double[]").addText(text.trim());
							}
						}else if("double[][]".equals(typeName)){						//属性类型为double二维数组
							double values[][] = (double[][])(field.get(node));
							if(values !=null&&values.length>0){
								String text = "";
								for(int i =0;i<values.length;i++){
									for(int j=0;j<values[i].length;j++){
										text = text + values[i][j] + " ";
									}
									text = text.trim().concat(",");
								}
								fele.addAttribute("type", "double[][]").addText(text.substring(0,text.length()-1));
							}
						}else if("int[][]".equals(typeName)){							//属性类型为int二维数组
							int values[][] = (int[][])(field.get(node));
							if(values !=null&&values.length>0){
								String text = "";
								for(int i =0;i<values.length;i++){
									for(int j=0;j<values[i].length;j++){
										text = text + values[i][j] + " ";
									}
									text = text.trim().concat(",");
								}
								fele.addAttribute("type", "int[][]").addText(text.substring(0,text.length()-1));
							}
						}else if("int[]".equals(typeName)){								//属性类型为int数组
							int values[] = (int[])(field.get(node));
							if(values !=null&&values.length>0){
								String text = "";
								for(int i =0;i<values.length;i++){
									text = text + values[i] + ",";
								}
								fele.addAttribute("type", "int[]").addText(text.substring(0,text.length()-1>=0?text.length()-1:0));
							}
						}else if("int".equals(typeName)){								//属性类型为int类型
							Integer value = field.getInt(node);	
							if(value!=null){
								fele.addAttribute("type", "int").addText(""+value);
							}
						}else if("Long".equals(typeName)){								//属性类型为long类型
							Long value = (Long)field.get(node);	
							if(value!=null){
								fele.addAttribute("type", "long").addText(""+value);
							}
						}else if("boolean".equals(typeName)){							//属性类型为boolean类型
							Boolean value = field.getBoolean(node);
							if(value!=null){
								fele.addAttribute("type", "boolean").addText((""+value).toUpperCase());
							}
						}else if("String".equals(typeName)){							//属性类型为boolean类型
							String value = (String)(field.get(node));
							if(value!=null){
								if(fele.getParent().getName().equals("Script")&&!fele.getName().equals("url")){
									fele.addAttribute("type", "String").addText(value);
								}else{
									fele.addAttribute("type", "String").addText("\""+value+"\"");
								}
							}
						}else if("String[]".equals(typeName)){							//属性类型为boolean类型
							String values[] = (String[])(field.get(node));
							if(values !=null&&values.length>0){
								String text = "";
								for(int i =0;i<values.length;i++){
									text = text + "\"" + values[i] + "\" ";
								}
								fele.addAttribute("type", "String[]").addText(text.trim());
							}
						}else if("Node[]".equals(typeName)){							//属性类型为boolean类型
							Node[] values = (Node[])(field.get(node));
							if(values !=null&&values.length>0){
								for(int i =0;i<values.length;i++){
									if(VrmlUtils.isFullyFields(values[i])){
										addChildElement(fele.addAttribute("type", "Node[]").addAttribute("length", values.length+""),values[i]);
									}
								}
							}
						}else if(VrmlUtils.isFullyFields((Node)(field.get(node)))){															//属性类型为boolean类型
							if(XMLUtils.isNode(fele.getName())){
								element_index++;
							}
							addChildElement(fele.addAttribute("type", "Node"),(Node)(field.get(node)));
						}
					}
				}
			}
		}
	}

	/**
	 * 获取节点的名字，如果该节点已经预定义过，则显示预定义名称，否则显示自动生成名称
	 * @param node 节点
	 * @return 节点的名字
	 */
	private String getElementName(Node node) {
		String name ;
		if((name = Define.selectDefine(node))!=null){
			return name;
		}
		return "Ele_" + getElement_index();
	}
	
	public int getElement_index() {
		return element_index;
	}

	public void setElement_index(int element_index) {
		this.element_index = element_index;
	}

}
