package com.kirbypyro.engine.render;

import java.io.FileNotFoundException;
import java.io.IOException;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;

public class Textures {

	
	public static Texture loadTexture(String key) {
		try {
			//return TextureLoader.getTexture("PNG", new FileInputStream(new File("res/" + key + ".png")));
			return TextureLoader.getTexture("PNG", Textures.class.getClassLoader().getResourceAsStream("res/" + key + ".png"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
}
