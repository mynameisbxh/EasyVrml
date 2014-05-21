package com.bxh.easyvrml.node.basic;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;

import com.bxh.easyvrml.impl.Node;

public class Group implements Node {

	private double[]  bboxCenter;		//用来定义组中对象的最大包围区域的中心
	
	private double[]    bboxSize;		//包围该组子节点的包围区域在 X、Y、Z 方向的大小
	
	private Node[] 		children;    	//包含在该 Group 节点下面的子节点的列表，默认值为空值，既不包含任何子节点

	protected final Map<String,Integer> required;		//必填属性

	protected final Map<String,Integer> exsisted;		//已存在属性
	
	public Group(Node[] children) {
		this(new double[]{0.0,0.0,0.0},new double[]{-1,-1,-1},children);
	}

	public Group(double[] bboxCenter, double[] bboxSize, Node[] children) {
		this.bboxCenter = bboxCenter;
		this.bboxSize = bboxSize;
		this.children = children;
		
		required = new HashMap<>();
		required.put("children", 0);
		
		exsisted = new HashMap<>();
		exsisted.put("children", 0);
		exsisted.put("bboxSize", 2);
		exsisted.put("bboxCenter", 2);
	}

	public double[] getBboxCenter() {
		return bboxCenter;
	}

	public void setBboxCenter(double[] bboxCenter) {
		this.bboxCenter = bboxCenter;
	}

	public double[] getBboxSize() {
		return bboxSize;
	}

	public void setBboxSize(double[] bboxSize) {
		this.bboxSize = bboxSize;
	}

	public Node[] getChildren() {
		return children;
	}

	public void setChildren(Node[] children) {
		this.children = children;
	}

	@Override
	public Group clone() {
		ByteArrayOutputStream byteOut = null;   
        ObjectOutputStream objOut = null;   
        ByteArrayInputStream byteIn = null;   
        ObjectInputStream objIn = null;   
           
        try {   
            byteOut = new ByteArrayOutputStream();    
            objOut = new ObjectOutputStream(byteOut);    
            objOut.writeObject(this);   
  
            byteIn = new ByteArrayInputStream(byteOut.toByteArray());   
            objIn = new ObjectInputStream(byteIn);   
               
            return (Group) objIn.readObject();   
        } catch (Exception e) {   
            throw new RuntimeException("Clone Object failed in IO.",e);      
        } finally{   
            try{   
                byteIn = null;   
                byteOut = null;   
                if(objOut != null) objOut.close();      
                if(objIn != null) objIn.close();      
            }catch(IOException e){      
            }      
        } 
	}
	
}
