package com.kirbypyro.engine;

public class Humanoid {
	public String bodytex;
	public String expression;
	public Polygon head;
	public Polygon body;
	public int x;
	public int y;
	public int size;
	
	//NOTE: Size = length of 1 side of body
	public Humanoid(int x, int y, int size, int r, int g, int b, int a, String expression) {
		this.size = size;
		this.x = x;
		this.y = y;
		this.expression = ("humanoid/"+"face_"+expression);
		bodytex = "humanoid/body";
		body = new Polygon(x, y, size, size, "GL_QUADS", true, r, g, b, a, 0);
		head = new Polygon((int) (x+.12*size),(int) (y-.8*size), (int) (size*.8), (int) (size*.8), "GL_QUADS", true, 1f,1f,1f, 1, 0);
		
	}

	public void translate(int x, int y) {
		this.x += x;
		this.y += y;
		body.translate(x, y);
		head.translate(x, y);
	}
}
