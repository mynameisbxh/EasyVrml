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
import com.bxh.easyvrml.tools.AppearanceConfig;
import com.bxh.easyvrml.tools.ColorConfig;
import com.bxh.easyvrml.tools.VrmlUtils;

public class C6H6 {

	private DocumentManager manager;

	@Test
	public void test(){
		manager = new DocumentManager();
		VDocument doc = new VDocument();

		double _rc = 0.7;
		double _rh = 0.5;
		double _loh = 3;
		
//		Transform _trans[] = new Transform[6];
		
		for(int i = 0;i< 6;i++){
			Shape _shape = new Shape(new Appearance(new Material(ColorConfig.SOFT_COLOR_RED)),new Sphere(_rc)); 
			if(i%2 == 0){
				doc.addNode(TransformGenerator.moveNodeTo(_shape,new Point3D(VrmlUtils._cos(i*60)*_loh,VrmlUtils._sin(i*60)*_loh,0)));
				if(i>=1){
					doc.addEdgeByPoints(new Edge(new Point3D(VrmlUtils._cos((i-1)*60)*(_loh),VrmlUtils._sin((i-1)*60)*(_loh),0), new Point3D(VrmlUtils._cos(i*60)*(_loh),VrmlUtils._sin(i*60)*(_loh),0)));
				}
			}else{
				doc.addEdgeByPoints(new Edge(new Point3D(VrmlUtils._cos((i-1)*60)*(_loh-0.2),VrmlUtils._sin((i-1)*60)*(_loh-0.2),0), new Point3D(VrmlUtils._cos(i*60)*(_loh-0.2),VrmlUtils._sin(i*60)*(_loh-0.2),0)));
				doc.addEdgeByPoints(new Edge(new Point3D(VrmlUtils._cos((i-1)*60)*(_loh+0.2),VrmlUtils._sin((i-1)*60)*(_loh+0.2),0), new Point3D(VrmlUtils._cos(i*60)*(_loh+0.2),VrmlUtils._sin(i*60)*(_loh+0.2),0)));
				doc.addNode(TransformGenerator.moveNodeTo(_shape,new Point3D(VrmlUtils._cos(i*60)*_loh,VrmlUtils._sin(i*60)*_loh,0)));
			}
			doc.addNode(TransformGenerator.moveNodeTo(new Shape(new Sphere(_rh)), new Point3D(VrmlUtils._cos(i*60)*(_loh+1),VrmlUtils._sin(i*60)*(_loh+1),0)));
		}
		doc.addEdgeByPoints(new Edge(new Point3D(VrmlUtils._cos((5)*60)*(_loh),VrmlUtils._sin((5)*60)*(_loh),0), new Point3D(VrmlUtils._cos(6*60)*(_loh),VrmlUtils._sin(6*60)*(_loh),0)));
//		doc.addEdges(_trans);
		doc.addCoordinate();
		manager.write(doc,"C6H6.wrl");
	}
}
