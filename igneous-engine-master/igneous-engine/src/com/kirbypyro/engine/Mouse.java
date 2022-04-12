package com.kirbypyro.engine;

import com.kirbypyro.engine.button.Button;



public class Mouse {

public static boolean isSelected(Button poly) {
	int mouseY = 600 - org.lwjgl.input.Mouse.getY();
	
	if(org.lwjgl.input.Mouse.getX() >= poly.x && org.lwjgl.input.Mouse.getX() <= poly.x + poly.width) {
		int y2 = poly.y+poly.height;
		
		if(mouseY >= poly.y && mouseY <= y2) {
			return true;
		}
		
	}
	return false;
}

}
