package com.bxh.easyvrml.node.basic;

import java.util.HashMap;
import java.util.Map;

import com.bxh.easyvrml.impl.Node;
import com.bxh.easyvrml.impl.Texture;

public class Appearance implements Node {

	private Material 				material;	//该域值通过使用 Material 节点设置了造型的基本对外表现的特征。
	
	private Texture 				texture;	//用来给造型设置静态或者动态纹理，从而使造型更加生动、逼真
	
	private TextureTransform textureTransform;	// 用来设置纹理的变换， 如纹理的平移、旋转和缩放等等，使纹理更加准确
	
	protected final Map<String,Integer> required;		//必填属性

	protected final Map<String,Integer> exsisted;		//已存在属性
	
	public Appearance(){
		this(new Material());
	}
	
	public Appearance(Material material){
		this.material = material;
		required = new HashMap<>();
		required.put("material", 0);
		
		exsisted = new HashMap<>();
		exsisted.put("material", 0);
	}
	
	public Appearance(Texture texture){
		this(texture,new TextureTransform());
	}
	
	public Appearance(Texture texture,TextureTransform textureTransform){
		this.texture = texture;
		this.textureTransform = textureTransform;
		
		required = new HashMap<>();
		required.put("texture", 0);
		
		exsisted = new HashMap<>();
		exsisted.put("texture", 0);
		exsisted.put("textureTransform", 1);
	}
	
	public Material getMaterial() {
		return material;
	}

	public void setMaterial(Material material) {
		this.material = material;
	}

	public Texture getTexture() {
		return texture;
	}

	public void setTexture(Texture texture) {
		this.texture = texture;
	}

	public TextureTransform getTextureTransform() {
		return textureTransform;
	}

	public void setTextureTransform(TextureTransform textureTransform) {
		this.textureTransform = textureTransform;
	}
}
