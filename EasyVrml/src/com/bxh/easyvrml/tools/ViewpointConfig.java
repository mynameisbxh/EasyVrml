package com.bxh.easyvrml.tools;

import com.bxh.easyvrml.node.basic.Viewpoint;
/**
 * 该类主要负责的是常用方向视点的创建
 * @author BXH
 */
public class ViewpointConfig {

	public static final int V_FRONT = 0x00000000;		//正前方
	
	public static final int V_BACK  = 0x00000001;		//正后方
	
	public static final int V_LEFT  = 0x00000002;		//正左方
	
	public static final int V_RIGHT = 0x00000003;		//正右方
	
	public static final int V_UP    = 0x00000004;		//正上方
	
	public static final int V_DOWN  = 0x00000005;		//正下方
	
	public static final int V_FRONT_RIGHT_UP   = 0x00000006;		//右前上
	
	public static final int V_FRONT_LEFT_UP    = 0x00000007;		//左前上
	

	/**
	 * 获取指定方向的视点
	 * @param type	指定方向
	 * @return	指定方向的视点
	 */
	public static Viewpoint getViewpoint(int type){
		Viewpoint _vp = new Viewpoint();
		switch(type){
		case V_BACK:
			_vp.setPosition(new double[]{0.0,0.0,-20.0});
			_vp.setOrientation(new double[]{0.0,1.0,0.0,VrmlUtils.getDegree(180)});
			_vp.setFieldOfView(VrmlUtils.getDegree(45));
			_vp.setDescription("back");
			break;
		case V_LEFT:
			_vp.setPosition(new double[]{-20.0,0.0,0.0});
			_vp.setOrientation(new double[]{0.0,1.0,0.0,VrmlUtils.getDegree(-90)});
			_vp.setFieldOfView(VrmlUtils.getDegree(45));
			_vp.setDescription("left");
			break;
		case V_RIGHT:
			_vp.setPosition(new double[]{20.0,0.0,0.0});
			_vp.setOrientation(new double[]{0.0,1.0,0.0,VrmlUtils.getDegree(90)});
			_vp.setFieldOfView(VrmlUtils.getDegree(45));
			_vp.setDescription("right");
			break;
		case V_UP:
			_vp.setPosition(new double[]{0.0,20.0,0.0});
			_vp.setOrientation(new double[]{-1.0,0.0,0.0,VrmlUtils.getDegree(90)});
			_vp.setFieldOfView(VrmlUtils.getDegree(45));
			_vp.setDescription("up");
			break;
		case V_DOWN:
			_vp.setPosition(new double[]{0.0,-20.0,0.0});
			_vp.setOrientation(new double[]{-1.0,0.0,0.0,VrmlUtils.getDegree(-90)});
			_vp.setFieldOfView(VrmlUtils.getDegree(45));
			_vp.setDescription("down");
			break;
		case V_FRONT_LEFT_UP:
			_vp.setPosition(new double[]{-10.0,10.0,10.0});
			_vp.setOrientation(new double[]{-1.0,-1.0,-0.28,Math.acos(1.732/3)});
			_vp.setFieldOfView(VrmlUtils.getDegree(45));
			_vp.setDescription("front_left_up");
			break;
		case V_FRONT_RIGHT_UP:
			_vp.setPosition(new double[]{10.0,10.0,10.0});
			_vp.setOrientation(new double[]{-1.0,1.0,0.0,Math.acos(1.732/3)});
			_vp.setFieldOfView(VrmlUtils.getDegree(45));
			_vp.setDescription("front_right_up");
			break;
		case V_FRONT:
		default:
			_vp.setPosition(new double[]{0.0,0.0,20.0});
			_vp.setOrientation(new double[]{1.0,0.0,0.0,VrmlUtils.getDegree(10)});
			_vp.setFieldOfView(VrmlUtils.getDegree(45));
			_vp.setDescription("front");
			break;
		}
		return _vp;
	}

	public static Viewpoint getFrontViewpoint(){
		return getViewpoint(V_FRONT);
	}
	
	public static Viewpoint getBacktViewpoint(){
		return getViewpoint(V_BACK);
	}
	
	public static Viewpoint getLeftViewpoint(){
		return getViewpoint(V_LEFT);
	}

	public static Viewpoint getRightViewpoint(){
		return getViewpoint(V_RIGHT);
	}
	
	public static Viewpoint getUpViewpoint(){
		return getViewpoint(V_UP);
	}
	
	public static Viewpoint getDownViewpoint(){
		return getViewpoint(V_DOWN);
	}
	
	public static int getvFrontRightUp() {
		return V_FRONT_RIGHT_UP;
	}

	public static int getvFrontLeftUp() {
		return V_FRONT_LEFT_UP;
	}
}
