package com.bxh.easyvrml.node.basic;

import java.util.HashMap;
import java.util.Map;

import com.bxh.easyvrml.impl.Texture;

public class ImageTexture implements Texture {
	private String  	 url;			//指定作为纹理文件的外部图像文件路径。该路径是磁盘上的特定位置，默认是当前文件夹。
										//在 url 后面可以指定多个图像文件的路径，浏览器会按照指定的先后顺序装载该表中第一个能
										//够找到的文件，以免当有些路径失效的时候造型不能添加纹理
	private boolean  repeatS;			//这个域值指明在纹理坐标 S 方向上的纹理映射是否会重复填满整个几何造型的表面
	
	private boolean  repeatT;			//这个域值指明在纹理坐标 T 方向上的纹理映射是否会重复填满整个几何造型的表面

	protected final Map<String,Integer> required;		//必填属性

	protected final Map<String,Integer> exsisted;		//已存在属性
	
	
	public ImageTexture(String url) {
		this(url,false,false);
	}

	public ImageTexture(String url, boolean repeatS, boolean repeatT) {
		this.url = url;
		this.repeatS = repeatS;
		this.repeatT = repeatT;
		
		required = new HashMap<>();
		required.put("url", 0);
		
		exsisted = new HashMap<>();
		exsisted.put("url", 0);
		exsisted.put("repeatS", 1);
		exsisted.put("repeatT", 1);
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
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
