package com.bxh.easyvrml.node.basic;

import com.bxh.easyvrml.impl.Node;

/**
 *    WorldInfo 节点可以位于 VRML 文件中的任何地方，含有场景的有关信息。它对该场景的
 * 视觉效果和动作没有任何影响，仅仅作为文档出现。使用 WorldInfo 节点对文档进行说明能提
 * 高程序的可读性，有助于理解程序。
 *
 * @author BXH
 */
public class WorldInfo implements Node {

	private String title;		//在浏览器窗口的标题栏上显示的当前场景的标题
	private String info[];		//关于场景的其他信息，如作者、创作时间、版权信息等
								//info ["Author:Wubeixin","Date:2003-11-03"]
	
	public WorldInfo(){
		this("",new String[]{""});
	}
	
	public WorldInfo(String title,String info[]){
		this.title = title;
		this.info = info;
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String[] getInfo() {
		return info;
	}

	public void setInfo(String[] info) {
		this.info = info;
	}
}
