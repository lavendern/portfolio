package com.kirbypyro.engine;

import static org.lwjgl.opengl.GL11.GL_MODELVIEW;
import static org.lwjgl.opengl.GL11.GL_PROJECTION;
import static org.lwjgl.opengl.GL11.glClearColor;
import static org.lwjgl.opengl.GL11.glEnable;
import static org.lwjgl.opengl.GL11.glLoadIdentity;
import static org.lwjgl.opengl.GL11.glMatrixMode;
import static org.lwjgl.opengl.GL11.glOrtho;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;

import com.kirbypyro.engine.settings.GameInfo;

public class Engine {
	public Engine() {
		initDisplay();
		initProjection();
	}

	public static void initDisplay() {
		try {
			Display.setDisplayMode(new DisplayMode(800,600));
			Display.setTitle(GameInfo.title);
			Display.create();
		}
		catch (LWJGLException e) {
			e.printStackTrace();
		}
	}
	
	private void initProjection() 
	{
		glMatrixMode(GL_PROJECTION);
		glLoadIdentity();
		glOrtho(0,800,600,0, 1, -1); 
		glMatrixMode(GL_MODELVIEW);
		//glEnable(GL_TEXTURE_2D);
		glClearColor(0,0,0,0);
		glEnable(GL11.GL_BLEND);
        GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);

	}
	
	
}
