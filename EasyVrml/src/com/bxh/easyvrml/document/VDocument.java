package com.bxh.easyvrml.document;

import java.util.LinkedList;
import java.util.List;

import com.bxh.easyvrml.element.field.Point3D;
import com.bxh.easyvrml.generator.ExtrusionGenerator;
import com.bxh.easyvrml.generator.IndexedLineGenerator;
import com.bxh.easyvrml.generator.TransformGenerator;
import com.bxh.easyvrml.impl.Geometry;
import com.bxh.easyvrml.impl.Interpolator;
import com.bxh.easyvrml.impl.Layout;
import com.bxh.easyvrml.impl.Light;
import com.bxh.easyvrml.impl.Node;
import com.bxh.easyvrml.node.basic.Appearance;
import com.bxh.easyvrml.node.basic.Billboard;
import com.bxh.easyvrml.node.basic.Cone;
import com.bxh.easyvrml.node.basic.Cylinder;
import com.bxh.easyvrml.node.basic.Extrusion;
import com.bxh.easyvrml.node.basic.FontStyle;
import com.bxh.easyvrml.node.basic.Material;
import com.bxh.easyvrml.node.basic.PROTO;
import com.bxh.easyvrml.node.basic.Script;
import com.bxh.easyvrml.node.basic.Shape;
import com.bxh.easyvrml.node.basic.Sphere;
import com.bxh.easyvrml.node.basic.Text;
import com.bxh.easyvrml.node.basic.TimeSensor;
import com.bxh.easyvrml.node.basic.Transform;
import com.bxh.easyvrml.node.basic.Version;
import com.bxh.easyvrml.node.basic.Viewpoint;
import com.bxh.easyvrml.node.extend.Define;
import com.bxh.easyvrml.node.extend.Edge;
import com.bxh.easyvrml.node.extend.EventIn;
import com.bxh.easyvrml.node.extend.Label;
import com.bxh.easyvrml.node.extend.ROUTE;
import com.bxh.easyvrml.node.extend.Rotation;
import com.bxh.easyvrml.tools.ColorConfig;
import com.bxh.easyvrml.tools.ViewpointConfig;
import com.bxh.easyvrml.tools.VrmlUtils;

/**
 * Document 表示独立的VRML文档，内部拥有一个元素
 * 
 * @author BXH
 *
 */
public class VDocument{

	private Version version;						//文档的版本信息
	
	private List<Node> nodes ;						//节点列表，存储文档中的所有元素
	
	private List<ROUTE> routes;						//路由列表
	
	private List<PROTO> protos;						//原型声明列表
	
	public static boolean isPrintCode;				//是否打印代码
	
	public VDocument(){
		this(new Version());
	}
	
	public VDocument(Version version){
		nodes  = new LinkedList<>();				//初始化节点列表
		routes = new LinkedList<>();				//初始化路由节点列表
//		protos = new LinkedList<>();				//初始化预定义节点列表
		setVersion(version);						//设置文档版本信息
	}
	
	public Transform rotationNode(Node node,Rotation rotation){
		return (Transform)addNode(TransformGenerator.rotateNode(node, rotation));
	}
	
	public Node moveAndRotateNodeTo(Node node,Point3D point,Rotation rotation){
		return addNode(TransformGenerator.moveAndRotateNodeTo(node,point,rotation));
	}
	
	public Transform moveNodeTo(Node node,Point3D point){
		Transform tran = TransformGenerator.moveNodeTo(node, point);
		return (Transform)addNode(tran);
	}
	
	public Shape addShape(Geometry geometry,int colorType){
		return (Shape)addNode(new Shape(new Appearance(new Material(colorType)),geometry));
	}
	
	public Shape addShape(Geometry geometry){
		return (Shape)addNode(new Shape(geometry));
	}
	
	public Shape addShape(Appearance appearance,Geometry geometry){
		return (Shape)addNode(new Shape(appearance,geometry));
	}
	public void addAllViewpoint(){
		addViewpoint(ViewpointConfig.V_FRONT);
		addViewpoint(ViewpointConfig.V_BACK);
		addViewpoint(ViewpointConfig.V_LEFT);
		addViewpoint(ViewpointConfig.V_RIGHT);
		addViewpoint(ViewpointConfig.V_DOWN);
		addViewpoint(ViewpointConfig.V_UP);
		addViewpoint(ViewpointConfig.V_FRONT_LEFT_UP);
		addViewpoint(ViewpointConfig.V_FRONT_RIGHT_UP);
	}
	/**
	 * 添加一个视点节点
	 * @param type	视点的方向
	 * @return	视点
	 */
	public Viewpoint addViewpoint(int type){
		return (Viewpoint)addNode(ViewpointConfig.getViewpoint(type));
	}
	/**
	 * 天剑一个视点节点
	 * @param view	自定义的视点
	 * @return
	 */
	public Viewpoint addViewpoint(Viewpoint view){
		return (Viewpoint)addNode(view);
	}
	/**
	 * 
	 * @param tran
	 * @param label
	 * @return
	 */
	public Label addLabelForNode(Transform tran,String label){
		Billboard b = new Billboard(new Node[]{new Shape(new Text(new String[]{label},
														 		  new double[]{0}, 
														 		  0,
														 		  new FontStyle(0.5)))});
		addNode(TransformGenerator.moveNodeTo(b, 
											  VrmlUtils.getLabelLocation(tran)));
		return new Label(label,0.5);
	}
	/**
	 * 
	 * @param tran
	 * @param label
	 * @return
	 */
	public Label addLabelForNode(Transform tran,Label label){
		Billboard b = new Billboard(new Node[]{new Shape(new Text(new String[]{label.getText()},
																  new double[]{0}, 
																  0, 
																  new FontStyle(label.getSize())))});
		addNode(TransformGenerator.moveNodeTo(b, 
											  VrmlUtils.getLabelLocation(tran)));
		return label;
	}
	/**
	 * 
	 * @param edge
	 * @return
	 */
	public Edge addEdgeByPoints(Edge edge){
		Point3D _start = edge.get_start();
		Shape shape = new Shape(new Extrusion(
				ExtrusionGenerator.getSpineByIndexedLineSet(IndexedLineGenerator.getLine(_start, 
																						 edge.get_end())), 
				ExtrusionGenerator.getCrossSectionByIndexedLineSet(IndexedLineGenerator.getLineCircle(0.1))));
		addNode(shape);
		return edge;
	}
	/**
	 * 
	 * @param edge
	 * @return
	 */
	public Edge addEdge(Edge edge){
		Point3D _start = edge.getStartPoint();
		Shape shape = new Shape(new Extrusion(
				ExtrusionGenerator.getSpineByIndexedLineSet(IndexedLineGenerator.getLine(_start, 
																						 edge.getEndPoint())), 
				ExtrusionGenerator.getCrossSectionByIndexedLineSet(IndexedLineGenerator.getLineCircle(0.1))));
		addNode(shape);
		return edge;
	}
	/**
	 * 
	 * @param trans
	 */
	public void addEdges(Transform []trans){
		for(int i = 0;i<trans.length ;i++){
			Edge _e = new Edge(trans[i],trans[(i+1)%trans.length]);
			addEdge(_e);
		}
	}
	
	/**
	 * 添加原型声明
	 * @param proto 原型
	 * @return 
	 */
	public PROTO addProto(PROTO proto){
		protos.add(proto);
		return proto;
	}
	
	/**
	 * 添加一个节点到节点列表中
	 * @param node 需要添加的节点
	 * @return 刚刚添加的节点
	 */
	public Node addNode(Node node){
		nodes.add(node);
		return node;
	}
	/**
	 * 添加一个节点数组到节点列表中
	 * @param node
	 * @return
	 */
	public Node[] addNode(Node[] node){
		for(int i =0;i<node.length;i++){
			nodes.add(node[i]);
		}
		return node;
	}
	
	/**
	 * 删除指定的节点
	 * @param node
	 */
	public void deleteNode(Node node){
		if(nodes.contains(node)){
			nodes.remove(node);
		}else{
			System.out.println("未找到删除对象!");
		}
	}
	
	/**
	 * 为文档添加坐标系
	 */
	public void addCoordinate(){
		addNode(new Shape(IndexedLineGenerator.getCoordinate()));
		addNode(TransformGenerator.moveAndRotateNodeTo(Define.addDefine(new Shape(new Cone(0.2, 0.1)), "_c_x_"), 
													   new Point3D(10,0,0), 
													   new Rotation(0, 0, 1, -90)));
		addNode(TransformGenerator.moveNodeTo(Define.getNodeByName("_c_x_"), 
											  new Point3D(0,10,0)));
		addNode(TransformGenerator.moveAndRotateNodeTo(Define.getNodeByName("_c_x_"), 
													   new Point3D(0,0,10), 
													   new Rotation(1, 0, 0, 90)));
	}
	
	//添加一个面
	public void addFace(){
		
	}
	
	/**
	 * 添加光源
	 * @param light 需要添加的光源
	 * @return 刚刚添加的光源
	 */
	public Light addLight(Light light){
		return (Light)(addNode(light));
	}
	
	/**
	 * 添加计时器
	 * @param time
	 * @return
	 */
	public TimeSensor addTimer(TimeSensor time){
		return (TimeSensor)(addNode(time));
	}
	
	/**
	 * 获取节点列表
	 * @return 节点列表
	 */
	public List<Node> getNodes() {
		return nodes;
	}

	/**
	 * 获取文档版本信息
	 * @return
	 */
	public Version getVersion() {
		return version;
	}

	/**
	 * 设置文档的版本信息
	 * @param version
	 */
	public void setVersion(Version version) {
		this.version = version;
	}

	/**
	 * 获取文档的路由列表
	 * @return 
	 */
	public List<ROUTE> getRoutes() {
		return routes;
	}

	/**
	 * 向路由列表里添加路由
	 * @param route
	 */
	public void addRoutes(ROUTE route) {
		this.routes.add(route);
	}
	
	/**
	 * 添加插补动画路由
	 * @param time 时钟
	 * @param interpolator 插补器
	 * @param node 需要改变属性的节点
	 * @param in 需要改变节点的事件
	 */
	public void addInterpolatorRoutes(TimeSensor time,Interpolator interpolator,Node node,EventIn in) {
		addRoutes(new ROUTE(time,
							time.getFraction_changed(),
							interpolator,
							interpolator.getSet_fraction()));
		addRoutes(new ROUTE(interpolator,
							interpolator.getValue_changed(),
							node,
							in));
	}

	public static boolean isPrintCode() {
		return isPrintCode;
	}

	public static void setPrintCode(boolean isPrintCode) {
		VDocument.isPrintCode = isPrintCode;
	}
}
