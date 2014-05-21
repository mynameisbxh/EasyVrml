package com.bxh.easyvrml.tools;

import com.bxh.easyvrml.node.basic.Appearance;
import com.bxh.easyvrml.node.basic.Material;

public class AppearanceConfig {

	//获取指定颜色的材质
	public static Appearance getColorAppearance(int type){
		return new Appearance(new Material(type));
	}
		
}
