package com.bxh.easyvrml.node.basic;

import com.bxh.easyvrml.impl.Texture;

public class MovieTexture implements Texture {
	 private String    url;		//指定作为纹理的视频文件的路径,视频纹理支持 MPEG 格式的 文件
	
	 private double    speed;		//指定映射到造型上的视频纹理的播放速度，这个域值是一个乘数因子,以值 1 表示以正常速度播放，大于 1 表示快速播放，小于 1 表示慢速播放，而 负值表示倒放
	 
	 private boolean    loop;		//指明视频纹理是否循环播放
	 
	 private int  startTime;    	//指定视频纹理开始播放的时间
	 
	 private int   stopTime;  		//指定视频纹理停止播放的时间
	 
	 private boolean repeatS;		//这个域值指明在纹理坐标 S 方向上的纹理映射是否会重复填满整个几何造型的表面
	 
	 private boolean repeatT;		//这个域值指明在纹理坐标 T 方向上的纹理映射是否 会重复填满整个几何造型的表面
	 
	 public MovieTexture(String url){
		 this(url,1.0,true,0,0,false,false);
	 }
	 
	public MovieTexture(String url, double speed, boolean loop,int startTime, int stopTime, boolean repeatS, boolean repeatT) {
		this.url = url;
		this.speed = speed;
		this.loop = loop;
		this.startTime = startTime;
		this.stopTime = stopTime;
		this.repeatS = repeatS;
		this.repeatT = repeatT;
	}
	
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public double getSpeed() {
		return speed;
	}
	public void setSpeed(double speed) {
		this.speed = speed;
	}
	public boolean isLoop() {
		return loop;
	}
	public void setLoop(boolean loop) {
		this.loop = loop;
	}
	public long getStartTime() {
		return startTime;
	}
	public void setStartTime(int startTime) {
		this.startTime = startTime;
	}
	public int getStopTime() {
		return stopTime;
	}
	public void setStopTime(int stopTime) {
		this.stopTime = stopTime;
	}
	public boolean isRepeatS() {
		return repeatS;
	}
	public void setRepeatS(boolean repeatS) {
		this.repeatS = repeatS;
	}
	public boolean isRepeatT() {
		return repeatT;
	}
	public void setRepeatT(boolean repeatT) {
		this.repeatT = repeatT;
	}
}
