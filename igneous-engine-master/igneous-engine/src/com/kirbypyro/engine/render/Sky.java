package com.kirbypyro.engine.render;

import com.kirbypyro.engine.Polygon;

public class Sky {
	public Polygon sky;
	public String texture;
	
	public Sky(String type) {
		sky = new Polygon(0, 0, 1300, 1000, "GL_QUADS", true, 1, 1, 1, 1,0);
		texture = "sky/" + type;
	}
}
