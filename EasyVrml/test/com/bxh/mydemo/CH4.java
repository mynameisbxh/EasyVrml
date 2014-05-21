package com.bxh.mydemo;

import java.io.IOException;

import org.jaxen.function.TranslateFunction;
import org.junit.Test;

import com.bxh.easyvrml.document.DocumentManager;
import com.bxh.easyvrml.document.VDocument;
import com.bxh.easyvrml.element.field.Point3D;
import com.bxh.easyvrml.generator.ExtrusionGenerator;
import com.bxh.easyvrml.generator.IndexedLineGenerator;
import com.bxh.easyvrml.generator.TransformGenerator;
import com.bxh.easyvrml.node.basic.Appearance;
import com.bxh.easyvrml.node.basic.Box;
import com.bxh.easyvrml.node.basic.Cone;
import com.bxh.easyvrml.node.basic.Extrusion;
import com.bxh.easyvrml.node.basic.ImageTexture;
import com.bxh.easyvrml.node.basic.Material;
import com.bxh.easyvrml.node.basic.Shape;
import com.bxh.easyvrml.node.basic.Sphere;
import com.bxh.easyvrml.node.basic.Transform;
import com.bxh.easyvrml.node.extend.Define;
import com.bxh.easyvrml.node.extend.Edge;
import com.bxh.easyvrml.node.extend.Label;
import com.bxh.easyvrml.tools.ColorConfig;
import com.bxh.easyvrml.tools.VrmlUtils;

public class CH4 {

	private DocumentManager manager;

	@Test
	public void test(){
		manager = new DocumentManager();
		VDocument doc = new VDocument();

		double _rc = 1;
		double _rh = 0.5;
		double _loh = 2;
		
		Shape c = new Shape(new Appearance(new Material(ColorConfig.SOFT_COLOR_BLUE)),new Sphere(_rc));
		Transform _c  = new Transform(c);
		doc.addNode(_c);
		doc.addLabelForNode(_c, "C");
		
		Shape h0 = new Shape(new Sphere(_rh));
		Define.addDefine(h0, "h");
		Transform _c0  = TransformGenerator.moveNodeTo(h0,new Point3D(0,_loh,0));
		doc.addNode(_c0);
		doc.addEdge(new Edge(new Transform(c), _c0));
		doc.addLabelForNode(_c0, "H");
		
		double _l = VrmlUtils._cos(45)*_loh;
		Transform _c1  = TransformGenerator.moveNodeTo(Define.getNodeByName("h"),new Point3D(0,-VrmlUtils._sin(60)*_loh,-_l));
		doc.addNode(_c1);
		doc.addEdge(new Edge(new Transform(c), _c1));
		doc.addLabelForNode(_c1, "H");
		
		Transform _c2  = TransformGenerator.moveNodeTo(Define.getNodeByName("h"),new Point3D(-VrmlUtils._sin(60)*_l,-VrmlUtils._sin(60)*_loh,VrmlUtils._cos(60)*_l));
		doc.addNode(_c2);
		doc.addEdge(new Edge(new Transform(c), _c2));
		doc.addLabelForNode(_c2, "H");
		
		Transform _c3  = TransformGenerator.moveNodeTo(Define.getNodeByName("h"),new Point3D(VrmlUtils._sin(60)*_l,-VrmlUtils._sin(60)*_loh,VrmlUtils._cos(60)*_l));
		doc.addNode(_c3);
		doc.addEdge(new Edge(new Transform(c), _c3));
		doc.addLabelForNode(_c3, "H");
		
		doc.addCoordinate();
		manager.write(doc,"CH4.wrl");
	}
}
