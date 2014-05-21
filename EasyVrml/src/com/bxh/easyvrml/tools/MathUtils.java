package com.bxh.easyvrml.tools;

import java.math.BigDecimal;

public class MathUtils {
	
	//进行4舍5入,默认精度是小数点后4位
	public static double divide(double value){
		return divide(value,4);
	}
	
	public static double divide(double value,int scale){
		return new BigDecimal(value).divide(new BigDecimal(1.0), scale, BigDecimal.ROUND_HALF_UP).doubleValue();
	}
	
}
