package com.kirbypyro.engine.settings;

import org.newdawn.slick.Color;

import com.kirbypyro.engine.Polygon;
import com.kirbypyro.engine.Text;
import com.kirbypyro.engine.button.Button;
import com.kirbypyro.engine.button.ButtonFunction;
import com.kirbypyro.engine.render.Render;

public class StartMenu {
	
	public static Polygon titlebox = new Polygon(190, 50, 400, 70, "GL_QUADS", true, 0.2f,.2f,1.0f, 1, 0);
	public static Polygon startbutton = new Polygon(300,250, 150, 40, "GL_QUADS", true, 0f, 0.5f, 0f, 1, 0);
	static Polygon background = new Polygon(0,0, 800, 600, "GL_QUADS", true, 0f, 0f, 0.2f, 1, 0);
	static Polygon credits = new Polygon(600, 500, 100, 50, "GL_QUADS", true, 0f, 0.8f, 0f, 1, 0);

	
	static Text title = new Text(200,50, GameInfo.title, Color.white, 24, "Arial");
	static Text title2 = new Text(200,70, GameInfo.title2, Color.white, 24, "Arial");
	static Text title3 = new Text(200,95, GameInfo.title3, Color.white, 24, "Arial");
	static Text presstostart = new Text(300, 250, "Click to start", Color.white, 24, "Arial");
	static Text credittex = new Text(610, 510, "Credits", Color.black, 24, "Arial");
	
//	public static ButtonFunction StartGame = new StartGame();
//	public static Button start = new Button(startbutton, StartGame);
//	
//	public static ButtonFunction ShowCredits = new ShowCredits();
//	public static Button credits2 = new Button(credits, ShowCredits);
	
	public static void renderGUI() {
		Render.render(background);
		Render.render(titlebox);
		Render.render(title);
		Render.render(title2);
		Render.render(title3);
		Render.render(startbutton);
		Render.render(presstostart);
		Render.render(credits);
		Render.render(credittex);

		

	}
}
