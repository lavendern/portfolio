package com.kirbypyro.engine.button;

import com.kirbypyro.engine.Polygon;

public class Button {
	public int x;
	public int y;
	public int width;
	public int height;
	public String glshape;
	public ButtonFunction function;
	
	public Button(Polygon polygon, ButtonFunction function) {
		this.x = polygon.x;
		this.y = polygon.y;
		this.width = polygon.width;
		this.height = polygon.height;
		this.function = function;
	}
	
	public void Clicked() {
		function.execute();
	}
}
