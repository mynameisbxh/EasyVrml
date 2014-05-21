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

public class H2O {

	private DocumentManager manager;

	@Test
	public void test(){
		manager = new DocumentManager();
		VDocument doc = new VDocument();

		double _ro = 1;
		double _rh = 0.5;
		double _loh = 2;
		
		doc.addNode(Define.addDefine(new Shape(new Appearance(new Material(ColorConfig.SOFT_COLOR_RED)),new Sphere(_ro)), "o"));
		doc.addLabelForNode(new Transform(Define.getNodeByName("o")), new Label("O", 0.5));
		
		double _x = VrmlUtils._cos(30)*_loh;
		double _y = VrmlUtils._sin(30)*_loh;
		
		Transform _tran = TransformGenerator.moveNodeTo(Define.addDefine(new Shape(new Sphere(_rh)),"h"), new Point3D(_x,-_y,0));
		doc.addNode(_tran);
		doc.addLabelForNode(_tran, new Label("H", 0.5));
		
		Transform _tran1 = TransformGenerator.moveNodeTo(Define.getNodeByName("h"),new Point3D(-_x,-_y,0));
		doc.addNode(_tran1);
		doc.addLabelForNode(_tran1, new Label("H", 0.5));
		
		doc.addEdge(new Edge(new Transform(Define.getNodeByName("o")), _tran));
		doc.addEdge(new Edge(new Transform(Define.getNodeByName("o")), _tran1));
		
		doc.addCoordinate();
		manager.write(doc,"H2O.wrl");
	}
}
