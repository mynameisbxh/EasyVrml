package com.bxh.easyvrml.impl;

import com.bxh.easyvrml.node.extend.EventIn;
import com.bxh.easyvrml.node.extend.EventOut;

public interface Interpolator extends Node {

	public EventIn getSet_fraction();

	public EventOut getValue_changed();
}
