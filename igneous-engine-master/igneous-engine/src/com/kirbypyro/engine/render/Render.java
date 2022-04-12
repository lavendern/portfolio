package com.kirbypyro.engine.render;


import static org.lwjgl.opengl.GL11.*;

import org.newdawn.slick.opengl.Texture;

import com.kirbypyro.engine.Humanoid;
import com.kirbypyro.engine.Polygon;
import com.kirbypyro.engine.Text;


public class Render {
private static Texture texture;

	public static void render(Polygon polygon) {
		
		int x = polygon.x;
		int y = polygon.y;
		int width = polygon.width;
		int height = polygon.height;
		String glshape = polygon.glshape;
		float[] color = {};
		glDisable(GL_BLEND);
		if (polygon.color != null) {
		glEnable(GL_BLEND);
		glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);
		color = new float[4];
		color[0] = polygon.color[0];
		color[1] = polygon.color[1];
		color[2] = polygon.color[2];
		color[3] = polygon.color[3];
		}
		int vertex = polygon.vertex;
		//System.out.println(polygon.color[1]);
		
		if (color.length != 0) {
			glColor4f(color[0], color[1], color[2], color[3]);
		} else {
			glColor3f(1.0f,1.0f,1.0f);
			}
		
		if (glshape == "GL_QUADS") {
			glBegin(GL_QUADS);
			glVertex2i(x,y); //Point of origin
			glVertex2i(x + width,  y); // Normally top right
			glVertex2i(x + width, y + height); // Normally bottom right
			glVertex2i(x, y + height); // Normally bottom left
		} else if (glshape == "GL_TRIANGLES") {
			glBegin(GL_TRIANGLES);
			glVertex2i(x,y);
			glVertex2i(x + width, y + height);
			glVertex2i(x + vertex, y + height);
		}
		glEnd();
		//glClearColor(0, 0, 0, 1);
		/*if (polygon.color != null) { //Debug render
		System.out.println("[DEBUG]" + "Rendering a " + glshape + " with coordinates of: " + x + "," + y + ", with a width and height of: " + width + "," + height + " and with color " + color[0] +","+ color[1] +","+ color[2]);
		} else {
		System.out.println("[DEBUG]" + "Rendering a " + glshape + " with coordinates of: " + x + "," + y + ", with a width and height of: " + width + "," + height + " and with color white.");
		}*/
	}
	
	public static void render(Text text) {
		glEnable(GL_TEXTURE_2D);
		text.font.drawString(text.x, text.y, text.text, text.color);
		glDisable(GL_TEXTURE_2D);
}
	
	public static void render(Polygon polygon, String tex) {
		glEnable(GL_TEXTURE_2D);
		int x = polygon.x;
		int y = polygon.y;
		int width = polygon.width;
		int height = polygon.height;
		String glshape = polygon.glshape;
		float[] color = {};
		glDisable(GL_BLEND);
		if (polygon.color != null) {
		glEnable(GL_BLEND);
		glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);
		color = new float[4];
		color[0] = polygon.color[0];
		color[1] = polygon.color[1];
		color[2] = polygon.color[2];
		color[3] = polygon.color[3];
		}
		int vertex = polygon.vertex;
		//System.out.println(polygon.color[1]);
		
		if (color.length != 0) {
			glColor4f(color[0], color[1], color[2], color[3]);
		} else {
			glColor3f(1.0f,1.0f,1.0f);
			}
		texture = Textures.loadTexture(tex);
		texture.bind();
		if (glshape == "GL_QUADS") {
			glBegin(GL_QUADS);
			glTexCoord2f(0,0);
			glVertex2i(x,y); //Point of origin
			glTexCoord2f(1,0);
			glVertex2i(x + width,  y); // Normally top right
			glTexCoord2f(1,1);
			glVertex2i(x + width, y + height); // Normally bottom right
			glTexCoord2f(0,1);
			glVertex2i(x, y + height); // Normally bottom left
		} else if (glshape == "GL_TRIANGLES") {
			glBegin(GL_TRIANGLES);
			glVertex2i(x,y);
			glVertex2i(x + width, y + height);
			glVertex2i(x + vertex, y + height);
		}
		glEnd();
		glDisable(GL_TEXTURE_2D);
		//glClearColor(0, 0, 0, 1);
		/*if (polygon.color != null) { //Debug render
		System.out.println("[DEBUG]" + "Rendering a " + glshape + " with coordinates of: " + x + "," + y + ", with a width and height of: " + width + "," + height + " and with color " + color[0] +","+ color[1] +","+ color[2]);
		} else {
		System.out.println("[DEBUG]" + "Rendering a " + glshape + " with coordinates of: " + x + "," + y + ", with a width and height of: " + width + "," + height + " and with color white.");
		}*/
	}
	
	public static void render(Sky sky) {
		render(sky.sky, sky.texture);
	}
	
	public static void render(Humanoid humanoid) {
		if (humanoid.body != null && humanoid.head != null) {
		render(humanoid.body, humanoid.bodytex);
		render(humanoid.head, humanoid.expression);
		//render(humanoid.head);
		} else {
			System.out.println("Unable to render a humanoid, parts = null");
		}
	}

}
