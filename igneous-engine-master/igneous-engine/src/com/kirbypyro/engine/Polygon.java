package com.kirbypyro.engine;

public class Polygon {
	public float[] color = new float[4];
	public int x;
	public int y;
	public int width;
	public int height;
	public String glshape;
	public int vertex;
	
	
	public Polygon(int x, int y, int width, int height, String glshape, boolean usecolor ,float r, float g, float b, float alpha, int vertex) {
		if(usecolor == true) {
		//System.out.println(true);
		this.color[0] = r;
		this.color[1] = g;
		this.color[2] = b;
		this.color[3] = alpha;
		}
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.glshape = glshape;
		this.vertex = vertex;
		System.out.println("[DEBUG]" + "Initializing a " + this.glshape + " with coordinates of: " + this.x + "," + this.y + " and with a width and height of: " + this.width + "," + this.height);
	}
	
	public void translate(int addX, int addY) {
		x += addX;
		y += addY;
	}
	
}
