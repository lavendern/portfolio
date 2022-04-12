package com.kirbypyro.engine.settings;

import org.newdawn.slick.Color;

import com.kirbypyro.engine.Polygon;
import com.kirbypyro.engine.Text;
import com.kirbypyro.engine.button.Button;
import com.kirbypyro.engine.button.ButtonFunction;
import com.kirbypyro.engine.render.Render;

public class Credits {

	static Polygon bg = new Polygon(0, 0, 800, 600, "GL_QUADS", true, 0f, 0f, .5f, 1, 0);
	static Polygon backbutton = new Polygon(50, 40, 100, 50, "GL_QUADS", true, 1f, 1f, 1f, 1, 0);
	
	static Text back = new Text(70, 50, "Back", Color.black, 24, "Arial");
	static Text credits1 = new Text(150, 200, GameInfo.credits1, Color.white, 24, "Arial");
	static Text credits2 = new Text(150, 250, GameInfo.credits2, Color.white, 24, "Arial");

	//static ButtonFunction tomenu = new ToStartMenu();
	//public static Button goback = new Button(backbutton, tomenu);
	
	public static void render() {
		Render.render(bg);
		Render.render(backbutton);
		Render.render(back);
		Render.render(credits1);
		Render.render(credits2);

		
	}

}
