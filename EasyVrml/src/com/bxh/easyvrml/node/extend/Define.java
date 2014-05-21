package com.bxh.easyvrml.node.extend;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.dom4j.Element;

import com.bxh.easyvrml.impl.Geometry;
import com.bxh.easyvrml.impl.Light;
import com.bxh.easyvrml.impl.Node;
import com.bxh.easyvrml.node.basic.TimeSensor;

public class Define {
	
	private static Map<Integer,Map<String,Node>> define ;			//键为Node节点的HashCode编码，值为该对象的预定义名和该对象的值
	
	private static Map<Integer,Boolean> states;						//键位Node节点的HashCode编码，值为该对象是否被访问过
	
	static{define = new HashMap<>();
		   states = new HashMap<>();}
	
	/**
	 * 预定义一个集合体
	 * @param geometry
	 * @param value
	 * @return
	 */
	public static Geometry addGeometryDefine(Geometry geometry,String value){
		return (Geometry)(addDefine(geometry,value));
	}
	
	/**
	 * 预定义一个时钟
	 * @param time 需要定义的时钟
	 * @param value 时钟的名字
	 * @return
	 */
	public static TimeSensor addTimerDefine(TimeSensor time,String value){
		return (TimeSensor)(addDefine(time,value));
	}
	
	/**
	 * 预定义一个灯光
	 * @param light 需要定义的灯光
	 * @param value 灯光的名字
	 * @return
	 */
	public static Light addLightDefine(Light light,String value){
		return (Light)(addDefine(light,value));
	}
	
	/**
	 * 添加预定义节点名
	 * @param node
	 * @param value
	 * @return
	 */
	public static Node addDefine(Node node,String value){
		Map<String,Node> dv = new HashMap<>();
		dv.put(value, node);
		define.put(node.hashCode(), dv);
		states.put(node.hashCode(), false);
		return node;
	}
	
	/**
	 * 删除预定义
	 * @param node
	 */
	public static void removeDefine(Node node){
		define.remove(node.hashCode());
		states.remove(node.hashCode());
	}
	
	/**
	 * 清空所有预定义节点名
	 */
	public static void clearDefine(){
		define.clear();
		states.clear();
	}
	/**
	 * 判断该节点是否有预定义名
	 * @param node
	 * @return
	 */
	public static boolean isContainDefine(Node node){
		return define.containsKey(node.hashCode());
	}
	
	/**
	 * 通过节点获取节点的名称
	 * @param node
	 * @return
	 */
	public static String selectDefine(Node node){
		if(define.containsKey(node.hashCode())){
			states.put(node.hashCode(), true);
			return (String)(define.get(node.hashCode()).keySet().toArray()[0]);
		}
		return null;
	}
	
	public static Boolean selectStates(Node node){
		return states.get(node.hashCode());
	}
	/**
	 * 通过预定意名获取一个几何体
	 * @param name
	 * @return
	 */
	public static Geometry getGeometryByName(String name){
		return (Geometry)(getNodeByName(name));
	}
	
	/**
	 * 通过预定意名获取一个时钟
	 * @param name
	 * @return
	 */
	public static TimeSensor getTimerByName(String name){
		return (TimeSensor)(getNodeByName(name));
	}

	/**
	 * 通过预定意名获取一个灯光
	 * @param name
	 * @return
	 */
	public static Light getLightByName(String name){
		return (Light)(getNodeByName(name));
	}

	/**
	 * 通过预定意名获取一个节点
	 * @param name
	 * @return
	 */
	public static Node getNodeByName(String name){
		Set<Integer> keys = define.keySet();
		for(Iterator<Integer> iterator = keys.iterator();iterator.hasNext();){
			Integer i = iterator.next();
			if(((String)(define.get(i).keySet().toArray()[0])).equals(name)){
				return define.get(i).get(name);
			}
		}
		return null;
	}
	
	public static Map<Integer, Map<String, Node>> getDefine() {
		return define;
	}
}
