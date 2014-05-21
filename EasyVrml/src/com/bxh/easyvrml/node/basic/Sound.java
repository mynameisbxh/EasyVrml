package com.bxh.easyvrml.node.basic;

import com.bxh.easyvrml.impl.Node;

public class Sound implements Node {
	private Node 		source;			//其域值为 AudioClip 节点或者 MovieTexture 节点。如果两者都没有指定，不会发出声音
	
	private double	 intensity;			//设置声源的强度，0 为最小值，1 为最大值。
	
	private double	  priority;			//设置声音文件播放的优先级，优先级按照从 0 到 1 增加
	
	private double[]  location;			//设置声源所在位置的坐标
	
	private double[] direction;			//指定声音播放的方向，但是这个方向并不同于象光源那样的情况，这个域和下面的
										//minFront、maxFront、minBack 以及 maxBack 共同确定了声音播放的有效距离以及声音强度变
										//化、衰减的方式
	
	private double 	  minFront;			//最小前点，表示声源位置 location 沿 direction 方向到内椭球顶点的距离
	
	private double	  maxFront;			//最大前点，表示声源位置 location 沿 direction 方向到外椭球顶点的距离
	
	private double	   minBack;			//最小后点，表示声源位置 location 沿 direction 的相反方向到内椭球顶点的距离
	
	private double	   maxBack;			//最大后点，表示声源位置 location 沿 direction 的相反方向到外椭球顶点的距离。
	
	private boolean	spatialize;	 		//指出声音经过什么方式播放。选 TRUE 方式，这时候的声音是经过浏览器
										//处理的，使之接近于现实中的声音。如果选择 FALSE 方式，则声音文件不经过任何处理直接
										//播放。

	
	public Sound(Node source) {
		this(source,1.0,1.0,new double[]{0.0,0.0,0.0},new double[]{0.0,0.0,1.0},1.0,10.0,1.0,10.0,true);
	}

	public Sound(Node source, double intensity, double priority,double[] location, double[] direction, double minFront,
			double maxFront, double minBack, double maxBack, boolean spatialize) {
		this.source = source;
		this.intensity = intensity;
		this.priority = priority;
		this.location = location;
		this.direction = direction;
		this.minFront = minFront;
		this.maxFront = maxFront;
		this.minBack = minBack;
		this.maxBack = maxBack;
		this.spatialize = spatialize;
	}

	public Node getSource() {
		return source;
	}

	public void setSource(Node source) {
		this.source = source;
	}

	public double getIntensity() {
		return intensity;
	}

	public void setIntensity(double intensity) {
		this.intensity = intensity;
	}

	public double getPriority() {
		return priority;
	}

	public void setPriority(double priority) {
		this.priority = priority;
	}

	public double[] getLocation() {
		return location;
	}

	public void setLocation(double[] location) {
		this.location = location;
	}

	public double[] getDirection() {
		return direction;
	}

	public void setDirection(double[] direction) {
		this.direction = direction;
	}

	public double getMinFront() {
		return minFront;
	}

	public void setMinFront(double minFront) {
		this.minFront = minFront;
	}

	public double getMaxFront() {
		return maxFront;
	}

	public void setMaxFront(double maxFront) {
		this.maxFront = maxFront;
	}

	public double getMinBack() {
		return minBack;
	}

	public void setMinBack(double minBack) {
		this.minBack = minBack;
	}

	public double getMaxBack() {
		return maxBack;
	}

	public void setMaxBack(double maxBack) {
		this.maxBack = maxBack;
	}

	public boolean isSpatialize() {
		return spatialize;
	}

	public void setSpatialize(boolean spatialize) {
		this.spatialize = spatialize;
	}
}
