package com.bxh.easyvrml.impl;

import org.dom4j.Document;

import com.bxh.easyvrml.document.VDocument;

/**
 * Compiler 接口声明了VRML编译器的各种功能和相关参数，实现该接口并且复写
 * 相应的方法可以完成将Java程序翻译成VRML的功能
 */

public interface Compiler {

	//利用代码转换算法生成中间代码文件（XML）
	public Document compileDocument(VDocument doc);
	
}
