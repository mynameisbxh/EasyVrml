package com.bxh.easyvrml.node.basic;

import java.util.HashMap;
import java.util.Map;

import com.bxh.easyvrml.impl.Node;

public class Switch implements Node {

	private int		whichChoice;		//活动子项的标号，类似于一种索引。在 choice 域中有一些作为造型或场景的子节点作为被
										//选择的子项，第一个子项的标号是 0。这里的活动子项的标号代表了激活了哪一个子项，也就
										//是选择了哪一个子项。如果 whichChoice 的值小于 0 或者大于 choice 域中的项目数，那么不选
										//中任何子项。
	
	private Node[]		 choice;		//包含一些造型或场景的子节点作为被选择的各个子项。每个子项有一个隐含的序号或者
										//引，由 whichChoice 域中的活动子项标号确定选择哪个子项。第一个子项的隐含序号为 0。
	
	protected final Map<String,Integer> required;		//必填属性

	protected final Map<String,Integer> exsisted;		//已存在属性
	
	
	public Switch(Node[] choice) {
		this(0,choice);
	}
	
	public Switch(int whichChoice, Node[] choice) {
		this.whichChoice = whichChoice;
		this.choice = choice;
		required = new HashMap<>();
		required.put("choice", 0);
		
		exsisted = new HashMap<>();
		exsisted.put("choice", 0);
		exsisted.put("whichChoice", 1);
	}
	
	public int getWhichChoice() {
		return whichChoice;
	}
	public void setWhichChoice(int whichChoice) {
		this.whichChoice = whichChoice;
	}
	public Node[] getChoice() {
		return choice;
	}
	public void setChoice(Node[] choice) {
		this.choice = choice;
	}
}
